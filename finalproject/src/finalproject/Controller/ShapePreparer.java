/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Controller;

import finalproject.Model.Shape;

/**
 *
 * @author Eng.SamehElshafay
 */
public class ShapePreparer extends Shape {
    private Shape shape ;
    private int [][] index ;
    private boolean inserted = false ;
    private ShapePreparer []differentShapesOfShape = new ShapePreparer[3] ;
    private Rotator rotation = new Rotator();
    
    public ShapePreparer(int [][]shapeStructure) {
        setShape(shapeStructure);
        index = new int [ getNumberOfZerosOnesInTheShape()[1] ][ 2 ] ;
    }
    
    public int[] getNumberOfZerosOnesInTheShape(){
        int []numberOfZerosOnesInTheShape = new int [2] ;
        int shapeRows = shape.getShapeStructure().length ,
            shapeColumns = shape.getShapeStructure()[0].length ;
        
        numberOfZerosOnesInTheShape[0] = 0 ;
        numberOfZerosOnesInTheShape[1] = 0 ;
        for(int i = 0 ; i < shapeRows ; i++)
            for(int y = 0 ; y < shapeColumns ; y++)
                if(shape.getShapeStructure()[i][y] != 0)
                    numberOfZerosOnesInTheShape[1]++;
        
        numberOfZerosOnesInTheShape[0] = shapeRows*shapeColumns - numberOfZerosOnesInTheShape[1];
        return numberOfZerosOnesInTheShape ;
    }
    
    public Shape getShape() {
        return shape;
    }
        
    public void setShape(Shape shape) {
        shape = shape ;
    }
    
    public void setShape(int[][] shape) {
        this.shape = Shape.setShapeStructure(shape);
    }
    
    public void getShapeRotations(){
        differentShapesOfShape = rotation.getShapesRotation(shape.getShapeStructure());
    }
    
    public ShapePreparer[] getDifferentShapesOfShape() {
        getShapeRotations();
        return differentShapesOfShape ;
    }
    
    public boolean isInserted() {
        return inserted;
    }

    public void setInserted(boolean inserted) {
        this.inserted = inserted;
    }
    
    @Override
    public int[][] getShapeStructure() {
        return shape.getShapeStructure();
    }
}
