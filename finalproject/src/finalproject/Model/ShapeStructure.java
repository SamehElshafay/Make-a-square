/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Model;

import finalproject.DataBase.DataBase;
import java.util.ArrayList;

/**
 *
 * @author Eng.SamehElshafay
 */
public class ShapeStructure {
    private int shapeStructureID ;
    private int[][] shapeStructure ;
    public static int number = 1 ;
    DataBase dataBase = new DataBase("makeasquare", "");
    
    public ShapeStructure(int shapeStructureID) {
        this.shapeStructureID = shapeStructureID;
        setShapeStructure(shapeStructureID);
        number++;
    }
    
    public int getShapeStructureID() {
        return shapeStructureID;
    }

    public void setShapeStructureID(int shapeStructureID) {
        this.shapeStructureID = shapeStructureID;
    }

    public int[][] getShapeStructure() {
        return shapeStructure;
    }

    public void setShapeStructure(int shapeStructureID) {
        int [][] shape ;
        ArrayList <String[]> shapes = dataBase.getShapeStructureAndID();
        for(int i = 0 ; i < shapes.size() ;i++){
            if(shapes.get(i)[0].equals(""+shapeStructureID)){
                this.shapeStructure = convertShapeStructure(shapes.get(i)[1]);
                setShapeNumbers(shapeStructure);
                break;
            }
        }
    }
    public void setShapeNumbers(int [][]shapeStructure) {
        for(int i = 0 ; i < shapeStructure.length ; i++){
            for(int y = 0 ; y < shapeStructure[0].length ; y++){
                if(shapeStructure[i][y] != 0)
                    shapeStructure[i][y] = number ;
            }
        }
    }
    public int[][]convertShapeStructure(String shape){
        String [] rows = shape.split("/");
        String shapeStructure[][] = new String[rows.length][];
        for(int i = 0 ; i < rows.length ; i++){
            shapeStructure[i] = rows[i].split(" ");
        }
        return IntegerParser(shapeStructure);
    }
    
    public int [][]IntegerParser(String shapeStructure[][]){
        this.shapeStructure = new int[shapeStructure.length][shapeStructure[0].length];
        for(int i = 0 ; i < shapeStructure.length ; i++){
            for(int y = 0 ; y < shapeStructure[0].length ; y++){
                this.shapeStructure[i][y] = Integer.parseInt(shapeStructure[i][y]);
            }
        }
        return this.shapeStructure;
    }
}