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
public class ShapeFormer {
    
    //TODO : To make all objects has no the same reference in the memory
    public ArrayList<ShapePreparer[]> deepCopy(ArrayList<ShapePreparer[]> rotatedShapes) {
        ArrayList <ShapePreparer[]> shapeProbabilitiesRotation = new ArrayList<>();
        for(int i = 0 ; i < rotatedShapes.size() ; i++){
            ShapePreparer Shapes[] = new ShapePreparer[rotatedShapes.get(0).length];
            for(int y = 0 ; y < Shapes.length ; y++){
                int shapeStructure [][] = rotatedShapes.get(i)[y].getShapeStructure() ;
                Shapes[y] = new ShapePreparer(shapeStructure);
            }
            shapeProbabilitiesRotation.add(Shapes);
        }
        return shapeProbabilitiesRotation ;
    }
    
    public ArrayList<ShapePreparer[]> formAllShapesProbability(ShapePreparer[] basicShapes) {
        ArrayList<ShapePreparer[]> finalShapes = new ArrayList<ShapePreparer[]> ();
        int numberOfShapes = basicShapes.length ;
        finalShapes = generateAllDiffrentOrderOfShapes(numberOfShapes, basicShapes, finalShapes);
        return finalShapes;
    }
    
    public ArrayList<ShapePreparer[]> generateAllDiffrentOrderOfShapes(int numberOfShapes , 
            ShapePreparer[] basicShapes , ArrayList<ShapePreparer[]> finalShapes) {
        
        if (numberOfShapes == 1)
            finalShapes.add(basicShapes.clone());
        else {
            finalShapes = generateAllDiffrentOrderOfShapes(numberOfShapes - 1 ,
                    basicShapes , finalShapes);
            
            for (int i = 0 ; i < numberOfShapes - 1; i++) {
                if (numberOfShapes % 2 == 0) swapShapes(basicShapes, i , numberOfShapes);
                else swapShapes(basicShapes, 0 , numberOfShapes);
                generateAllDiffrentOrderOfShapes(numberOfShapes-1, basicShapes, finalShapes);
            }
        }
        return finalShapes;
    }
        
    public void swapShapes(ShapePreparer[] basicShapes , int shapeNumber , int numberOfShapes){
        ShapePreparer emptyShape = basicShapes[shapeNumber];
        basicShapes[shapeNumber] = basicShapes[numberOfShapes-1];
        basicShapes[numberOfShapes-1] = emptyShape;
    }
}
