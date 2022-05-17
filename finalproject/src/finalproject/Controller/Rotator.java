/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Controller;

import java.util.ArrayList;

/**
 *
 * @author Eng.SamehElshafay
 */
public class Rotator {
    private ShapePreparer []differentShapesOfShape = new ShapePreparer[3] ;
    
    public ShapePreparer[] getShapesRotation(int [][]shape){
        Rotator rotator = new Rotator() ;
        differentShapesOfShape[0] = new ShapePreparer(rotator.rotateShape(shape)) ;
        differentShapesOfShape[1] = new ShapePreparer(rotator.rotateShape(differentShapesOfShape[0].getShapeStructure()));
        differentShapesOfShape[2] = new ShapePreparer(rotator.rotateShape(differentShapesOfShape[1].getShapeStructure()));
        return differentShapesOfShape ;
    }
    
    private int[][] reverseColumns(int[][] rotatedShape){
        int rotatedShapeRows = rotatedShape.length ,
            rotatedShapeColumns = rotatedShape[0].length ,
            counter = 0 ;
        
        int[][] shape = new int[rotatedShapeRows][rotatedShapeColumns];
        for (int row = rotatedShapeRows - 1 ; row >= 0 ; row--){
            for (int col = 0 ; col < rotatedShapeColumns ; col++)
                shape[row][col] = rotatedShape[counter][col];
            counter++;
        }
        return shape ;
    }
    
    private int [][] oneSidedRotation(int shape[][]){
        int shapeRows = shape.length , shapeColumn = shape[0].length ,
        newShape[][] = new int [shapeColumn][shapeRows] ,
        newShapeColumns = shapeRows , newShapeRows = shapeColumn ,
        newShapeColumnsCounter = 0 , newShapeRowsCounter = 0 ;
        
        for (int i = 0 ; i < shapeRows ; i++){
            for (int j = 0 ; j < shapeColumn ; j++){
                newShape[newShapeRowsCounter][newShapeColumnsCounter] = shape[i][j] ;
                
                newShapeRowsCounter++;
                if(newShapeRowsCounter == newShapeRows)
                    newShapeRowsCounter = 0 ;
                
            }
            
            newShapeColumnsCounter++;
            if(newShapeColumnsCounter == newShapeColumns)
                newShapeColumnsCounter = 0 ;
            
        }
        return newShape ;
    }
    
    private int [][] rotateShape(int [][] shape){
        int newShape [][] = new int[shape.length][shape[0].length] ,
        newShapeRows = shape.length , newShapeColumns = shape[0].length;
        
        for(int i = 0 ; i < newShapeRows ; i++)
            for(int y = 0 ; y < newShapeColumns ; y++)
                newShape[i][y] = shape[i][y] ;
        
        return reverseColumns(oneSidedRotation(newShape)) ;
    }
    
    public ArrayList<ShapePreparer[]> getProbabilityOfRotatedShape(
            ArrayList <ShapePreparer[]> shapesProbabilities , SquareMaker square){
        
        ArrayList<ShapePreparer[]> allShapes = new ArrayList<>() ;
        ShapePreparer shapes[] = new ShapePreparer[3] ;
        
        for(int i = 0 ; i < shapesProbabilities.size() ; i++)
            for(int y = 0 ; y < shapesProbabilities.get(i).length ; y++)
                for(int x = 0 ; x < 3 ; x++){
                    shapes = shapesProbabilities.get(i) ;
                    ShapePreparer shape = shapes[y].getDifferentShapesOfShape()[x] ;
                    shapes[y] = shape ;
                    allShapes.addAll(square.formAllShapesProbability(shapes));
                }
        
        return allShapes ;
    }
}
