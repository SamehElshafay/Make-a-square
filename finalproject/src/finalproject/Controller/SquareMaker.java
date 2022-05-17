/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Controller;

import finalproject.Model.Square;
import com.sun.corba.se.impl.orbutil.concurrent.SyncUtil;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.monitor.Monitor;
import sun.misc.Signal;

/**
 *
 * @author Eng.SamehElshafay
 */
public class SquareMaker extends ShapeFormer {
    private ShapePreparer shapes [] ;
    private ArrayList <ShapePreparer[]> ShapeProbability = new ArrayList<>();
    private ArrayList <Square> bestSolution = new ArrayList<>() ;
    private Inserter insertion = new Inserter();
    private Rotator rotation = new Rotator() ;
    private final SquareMaker THIS_CLASS = this ;
    
    
    public SquareMaker(ShapePreparer[] shapes) {
        this.shapes = shapes ;
        ShapeProbability.addAll(formAllShapesProbability(shapes));
    }
    
    @Override
    public ArrayList<ShapePreparer[]> formAllShapesProbability(ShapePreparer[] basicShapes) {
        return generateAllDiffrentOrderOfShapes(basicShapes.length, basicShapes, new ArrayList<ShapePreparer[]> ());
    }
    
    public ArrayList <Square> formSquares(){
        ArrayList <Square> squares = new ArrayList<>();

        ArrayList <ShapePreparer[]> groupsOfShapes = 
            separateObjects(rotation.getProbabilityOfRotatedShape(getShapeProbability() ,
                    THIS_CLASS )) ;
        
        for(int i = 0 ; i < groupsOfShapes.size() ; i++)
            squares.add(insertion.insertShapesInSquare(groupsOfShapes.get(i))) ;

        return squares;
    }
    public ArrayList<Square> makeACompleteAndUniqeSquare(){
        ArrayList <Square> squares = formSquares();
        for(int i = 0 ; i < squares.size() ;i++ )
            if(isSquareCompleated(squares.get(i)))
                bestSolution.add(squares.get(i));
        return bestSolution ;
    }
    
    //TODO : To make all objects has no the same reference in the memory
    public ArrayList<ShapePreparer[]> separateObjects(ArrayList<ShapePreparer[]> rotatedShapes) {
        ArrayList <ShapePreparer[]> shapeProbabilitiesRotation = new ArrayList<>();
        for(int i = 0 ; i < rotatedShapes.size() ; i++){
            ShapePreparer Shapes[] = new ShapePreparer[rotatedShapes.get(0).length];
            for(int y = 0 ; y < Shapes.length ; y++){
                int shapeStructure [][] = rotatedShapes.get(i)[y].getShape().getShapeStructure() ;
                Shapes[y] = new ShapePreparer(shapeStructure);
            }
            shapeProbabilitiesRotation.add(Shapes);
        }
        return shapeProbabilitiesRotation ;
    }
    
    public boolean isSquareCompleated(Square square){
        int rows = square.getSquare().length ;
        int columns = square.getSquare()[0].length ;
        for(int i = 0 ; i < rows ;i++)
            for(int y = 0 ; y < columns ;y++)
                if(square.getSquare()[i][y] == 0)
                    return false ;
        
        return true ;
    }
    
    public ArrayList<ShapePreparer[]> getShapeProbability() {
        return ShapeProbability;
    }
    
    
}