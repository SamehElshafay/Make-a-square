/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Model;

/**
 *
 * @author Eng.SamehElshafay
 */
public class Shape{
    private int shapeStructure[][] ;
    private int columnsNumber ;
    private int rowsNumber ;
    private int shapeID ;
    private int shapesNumber ;
    private int shapeStructureID ;

    public Shape() {
    }
    
    private Shape(int rows ,int columns){
        shapeStructure = new int[rows][columns];
        columnsNumber = shapeStructure[0].length ;
        rowsNumber = shapeStructure.length ;
    }
    private Shape(int shape[][]){
        this.shapeStructure = shape ;
        rowsNumber = shape.length ;
        columnsNumber = shape[0].length ;
    }
    
    public static Shape setShapeStructure(int[][] Shape){
        return new Shape(Shape);
    }

    public static Shape setShapeRowsAndColumns(int rows ,int columns){
        return new Shape(rows, columns);
    }
    
    
    public int[][] getShapeStructure() {
        return shapeStructure;
    }
    
    
    public int getColumnsNumber() {
        return columnsNumber;
    }
    
    
    public void setColumnsNumber(int ColumnsNumber) {
        this.columnsNumber = ColumnsNumber;
    }
    
    
    public int getRowsNumber() {
        return rowsNumber;
    }
    
    
    public void setRowsNumber(int RowsNumber) {
        this.rowsNumber = RowsNumber;
    }
    
    
    public int getShapeID() {
        return shapeID;
    }

    
    public void setShapeID(int ShapeID) {
        this.shapeID = ShapeID;
    }

    
    public int getShapesNumber() {
        return shapesNumber;
    }

    
    public void setShapesNumber(int ShapesNumber) {
        this.shapesNumber = ShapesNumber;
    }

    
    public int getShapeStructureID() {
        return shapeStructureID;
    }

    
    public void setShapeStructureID(int ShapeStructureID) {
        this.shapeStructureID = ShapeStructureID;
    }
        
    
    public void setValueForIndexInTheShape(int rowNumber , int columnNumber , int value){
        shapeStructure[rowNumber][columnNumber] = value ;
    }
}