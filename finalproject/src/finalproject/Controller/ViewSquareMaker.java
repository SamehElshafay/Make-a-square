/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Controller;

import finalproject.DataBase.DataBase;
import finalproject.Model.ShapeStructure;
import finalproject.Model.Square;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eng.SamehElshafay
 */
public class ViewSquareMaker extends ButtonsViewer{
    private ArrayList <ShapePreparer> shapes = new ArrayList<>();
    private ArrayList<Square> bestSolution = new ArrayList<>();
    private DataBase dataBase = new DataBase("makeasquare", "");
    private ArrayList <Square> squares = new ArrayList();
    private Square square = new Square();
    private ArrayList <JButton> buttons = new ArrayList<>();
    private ArrayList <JTextField> field = new ArrayList<>();
    int next = 0 ;
    int counter = 0 ;
    
    public ViewSquareMaker(ArrayList <JButton> buttons, ArrayList <JTextField> field ){
        this.buttons.addAll(buttons);
        this.field.addAll(field);
        addColorsInArrayList();
    }
    
    public void addSquaresNameInComboBox(JComboBox SquaresName){
        squares.addAll(dataBase.getAllSquares());
        for(Square square : squares){
            SquaresName.addItem(square.getSquareName());
        }
    }
    
    public void changeFieldsValue(JComboBox SquaresName){
        setAllFieldsWithNullValue();
        fillFields(SquaresName);
    }
    
    public void setAllFieldsWithNullValue(){
        for(int i = 0 ; i < field.size() ; i++){
            field.get(i).setText("");
        }
    }
    
    public void fillFields(JComboBox SquaresName){
        square = squares.get(SquaresName.getSelectedIndex());
        checkValueOfShapeID(dataBase.getAllSquares().get(SquaresName.getSelectedIndex()).getFirstShapeID()) ;
        checkValueOfShapeID(dataBase.getAllSquares().get(SquaresName.getSelectedIndex()).getSecondShapeID());
        checkValueOfShapeID(dataBase.getAllSquares().get(SquaresName.getSelectedIndex()).getThirdShapeID()) ;
        checkValueOfShapeID(dataBase.getAllSquares().get(SquaresName.getSelectedIndex()).getFourthShapeID());
        checkValueOfShapeID(dataBase.getAllSquares().get(SquaresName.getSelectedIndex()).getFifthShapeID()) ;
    }
    
    void checkValueOfShapeID(int value){
        if(value != 0){
            System.out.println(field.get(value-1).getText().equals(""));
            if(field.get(value-1).getText().equals(""))
                field.get(value-1).setText("0");
            field.get(value-1).setText(String.valueOf(Integer.parseInt(field.get(value-1).getText()) + 1));
        }
    }
    
    public ArrayList <ShapePreparer> getShapesFromGui(JTextField fields , int ShapeStructureID){
        ArrayList <ShapePreparer> shapes = new ArrayList();
        if(!fields.getText().equals("")){
            for(int i = 0 ; i < Integer.parseInt(fields.getText()) ; i++){
                ShapeStructure shapeStructure = new ShapeStructure(ShapeStructureID) ;
                shapes.add(new ShapePreparer( shapeStructure.getShapeStructure() ));
            }
            counter += Integer.parseInt(fields.getText());
        }
        return shapes;
    }

    public ShapePreparer[] convertArrayListToArray(ArrayList <ShapePreparer> shapes){
        ShapePreparer shapesStructure [] = new ShapePreparer[shapes.size()];
        for(int i = 0 ; i < shapes.size() ; i++)
            shapesStructure [i] = shapes.get(i) ;
        
        return shapesStructure ;
    }

    public void addShapesInArrayList(){
        for(int i = 0 ; i < 9 ; i++)
            shapes.addAll(getShapesFromGui(field.get(i) , i+1));
    }

    public void formateSquareLabel(ArrayList <Square> Squares , JLabel allsolution , JLabel nextText){
        allsolution.setText(Squares.size()+"");
        nextText.setText("1");
    }

    @Override
    public void buttonChangeColor(int next, ArrayList<JButton> buttons) {
        for(int i = 0 ; i < 16 ; i++){
            Color color = colors.get(Integer.parseInt(buttons.get(i).getText())-1);
            buttons.get(i).setBackground(color);
        }
        System.out.println("===================");
    }

    public void putSquareInView(JLabel allsolution , JLabel nextText){
        shapes.clear();
        bestSolution.clear();
        addShapesInArrayList();
        SquareMaker squareMaker = new SquareMaker(convertArrayListToArray(shapes));
        bestSolution.addAll(squareMaker.makeACompleteAndUniqeSquare());
        formateSquareLabel(bestSolution , allsolution , nextText);
        if(bestSolution.size()!=0)
            showSquare(bestSolution, buttons, 0);
        ShapeStructure.number = 1 ;
    }
    
    public void moveToRight(JLabel nextText){
        next = ( next + 1 ) % bestSolution.size() ;
        showSquare(bestSolution, buttons, next);
        nextText.setText(next + 1 + "");
    }
    
    public void moveToLeft(JLabel nextText){
        if(next == 0){
            next = bestSolution.size() - 1 ;
            showSquare(bestSolution, buttons, next);
            nextText.setText(next+1+"");
        }else{
            next--;
            showSquare(bestSolution, buttons, next);
            nextText.setText(""+next);
        }
    }
    
}
