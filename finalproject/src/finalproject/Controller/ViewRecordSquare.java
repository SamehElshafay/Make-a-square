/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Controller;

import finalproject.DataBase.DataBase;
import finalproject.Model.Square;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eng.SamehElshafay
 */
public class ViewRecordSquare {
    private DataBase dataBase = new DataBase("makeasquare", "");
    private ArrayList <JTextField> field = new ArrayList();
    private ArrayList <String> values = new ArrayList();

    public ViewRecordSquare(ArrayList <JTextField> field ) {
        this.field.addAll(field);
    }
    
    boolean isAllFieldValid(JTextField SquareName , ArrayList <JTextField> field ){
        boolean isValied = true ;
        for(int i = 0 ; i < 5 ;i++){
            isValied = isValied && isFieldValid(field.get(i)) ;
        }
        return !SquareName.getText().equals("") && isValied ;
    }
    
    boolean isFieldValid(JTextField field){
        return !field.getText().equals("") 
                && (Integer.parseInt(field.getText()) >= 0 
                && Integer.parseInt(field.getText()) <= 9) ;
    }
    
    public void insertValuesInArrayList(){
        for(int i = 0 ; i < field.size() ; i++){
            values.add(field.get(i).getText().toString());
        }
    }
    
    public int getNumberOfFieldsThatHaveNoZeroValues(){
        int count = 0 ;
        for(int i = 0 ; i < values.size() ; i++){
            if(!values.get(i).equals("0")){
                count++;
            }
        }
        values.clear();
        return count;
    }
    
    public int getNumberOfEnteredShapes(){
        insertValuesInArrayList();
        return getNumberOfFieldsThatHaveNoZeroValues();
    }
    
    public void recordSquare(JTextField SquareName , ArrayList <JTextField> field ){
        if(isAllFieldValid(SquareName , field)){
            try {
                Square square = new Square();
                square.setSquareID(dataBase.getNumberOfRows("square")+1);
                square.setNumberOfShapes(getNumberOfEnteredShapes());
                square.setFirstShapeID(Integer.parseInt(field.get(0).getText()));
                square.setSecondShapeID(Integer.parseInt(field.get(1).getText()));
                square.setThirdShapeID(Integer.parseInt(field.get(2).getText()));
                square.setFourthShapeID(Integer.parseInt(field.get(3).getText()));
                square.setFifthShapeID(Integer.parseInt(field.get(4).getText()));
                square.setSquareName(SquareName.getText());
                dataBase.insertSquare("square" , square );
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"breaking the rules");
        }
    }
}
