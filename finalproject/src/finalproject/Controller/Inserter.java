/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Controller;

import finalproject.Model.Square;

/**
 *
 * @author Eng.SamehElshafay
 */
public class Inserter {
    private ShapePreparer shapePreparer ;
    
    public Square insertShapesInSquare(ShapePreparer[] shapes){
        Square square = new Square();
        int numberOfShapes = shapes.length ;
        for(int i = 0 ; i < numberOfShapes ; i++)
            if(!shapes[i].isInserted())
                square = insert(square , shapes[i]);
        return square ;
    }
    
    public Square insert(Square square , ShapePreparer shapePreparer){
        Square FinalSquare = square ;
        this.shapePreparer = shapePreparer ;
        for(int levelRow = 0 ; levelRow < 4 && shapePreparer.isInserted() != true ; levelRow++){
            for(int levelColumn = 0 ; levelColumn < 4 ; levelColumn++)
                if(checkIfShapecCanBeAdded(square, levelRow , levelColumn)){
                    FinalSquare = insertTheShape(square, levelRow , levelColumn) ;
                    shapePreparer.setInserted(true);
                    break;
                }
        }
        return FinalSquare ;
    }
    
    public boolean checkIfShapecCanBeAdded(Square square , int levelRow , int levelColumn){
        int counter = 0 , shapeRows = getShapePreparer().getShapeStructure().length
                , shapeColumns = shapePreparer.getShapeStructure()[0].length ,
                onesInTheShape = shapePreparer.getNumberOfZerosOnesInTheShape()[1] ;
        
        if(shapeRows + levelRow > 4 || shapeColumns + levelColumn > 4)
            return false ;
        
        for(int rowIndex = 0 ; rowIndex < shapeRows ; rowIndex++)
            for(int columnIndex = 0 ; columnIndex < shapeColumns ; columnIndex++)
                if(square.getSquare()[levelRow+rowIndex][levelColumn + columnIndex] == 0 && getShapePreparer().getShapeStructure()[rowIndex][columnIndex] != 0 )
                    counter++ ;
        
        return counter == onesInTheShape ;
    }
    // TODO : check all index in the square

    
    public Square insertTheShape(Square square , int levelRow , int levelColumn ){
        int[][] shape = getShapePreparer().getShapeStructure();
        int shapeColumns = shape[0].length;
        int shapeRows = shape.length;
        int[][] ShapeStructure = square.getSquare();

        for(int rowIndex = 0 ; rowIndex < shapeRows ; rowIndex++)
            for(int columnIndex = 0 ; columnIndex < shapeColumns ; columnIndex++)
                if(ShapeStructure[levelRow+rowIndex][levelColumn + columnIndex] == 0 && shape[rowIndex][columnIndex] != 0 )
                    ShapeStructure[levelRow+rowIndex][levelColumn + columnIndex] = shape[rowIndex][columnIndex] ; 
        
        square.setSquare(ShapeStructure);
        return square ;
    }
    
    public ShapePreparer getShapePreparer() {
        return shapePreparer ;
    }

    public void setShape(ShapePreparer shape) {
        this.shapePreparer = shape;
    }
}
