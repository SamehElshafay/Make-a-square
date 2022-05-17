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
public class Square{
    private int square [][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}} ;
    private int squareID ;
    private String squareName ;
    private int firstShapeID ;
    private int secondShapeID ;
    private int thirdShapeID ;
    private int fourthShapeID ;
    private int fifthShapeID ;
    private int numberOfShapes ; 
    
    public int[][] getSquare() {
        return square;
    }

    
    public void setSquare(int[][] square) {
        for(int levelRow = 0 ; levelRow < 4 ; levelRow++){
            for(int levelColumn = 0 ; levelColumn < 4 ; levelColumn++){
                this.square[levelRow][levelColumn] = square[levelRow][levelColumn];
            }
        }
    }

    
    public int getSquareID() {
        return squareID;
    }

    
    public void setSquareID(int squareID) {
        this.squareID = squareID;
    }
    
    
    public int getFifthShapeID() {
        return fifthShapeID;
    }

    
    public void setFifthShapeID(int fifthShapeID) {
        this.fifthShapeID = fifthShapeID;
    }

    
    public int getFirstShapeID() {
        return firstShapeID;
    }

    
    public void setFirstShapeID(int firstShapeID) {
        this.firstShapeID = firstShapeID;
    }

    
    public int getFourthShapeID() {
        return fourthShapeID;
    }

    
    public void setFourthShapeID(int fourthShapeID) {
        this.fourthShapeID = fourthShapeID;
    }

    
    public int getNumberOfShapes() {
        return numberOfShapes;
    }

    
    public void setNumberOfShapes(int numberOfShapes) {
        this.numberOfShapes = numberOfShapes;
    }

    
    public int getSecondShapeID() {
        return secondShapeID;
    }

    
    public void setSecondShapeID(int secondShapeID) {
        this.secondShapeID = secondShapeID;
    }

    
    public int getThirdShapeID() {
        return thirdShapeID;
    }

    
    public void setThirdShapeID(int thirdShapeID) {
        this.thirdShapeID = thirdShapeID;
    }
    
    
    public String getSquareName() {
        return squareName;
    }
    
    
    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }
}
