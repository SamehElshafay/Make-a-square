/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Controller;

import finalproject.Model.Square;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Eng.SamehElshafay
 */
public class ButtonsViewer {
    public ArrayList<Color> colors = new ArrayList<>();
    
    public void showSquare(ArrayList<Square> bestSolution , ArrayList<JButton> buttons  ,int next){
        insertValuesOfSquareInButtonsValue(bestSolution, next, buttons);
        buttonChangeColor(next, buttons);
    }
    public void insertValuesOfSquareInButtonsValue(ArrayList<Square> bestSolution , int next , ArrayList<JButton> buttons ){
        int buttonCurser = 0 ;
        int square[][] = bestSolution.get(next).getSquare() ;
        for(int i = 0 ; i < 4 ; i++){
            for(int y = 0 ; y < 4 ; y++){
                buttons.get(buttonCurser).setText(String.valueOf(square[i][y]));
                buttonCurser++;
            }
        }
    }
    public void buttonChangeColor(int next , ArrayList<JButton> buttons){
        for(int i = 0 ; i < 16 ; i++){
            if(buttons.get(i).getText().equals(String.valueOf(1)))
                buttons.get(i).setBackground(java.awt.Color.DARK_GRAY);

            else if(buttons.get(i).getText().equals(String.valueOf(2)))
                buttons.get(i).setBackground(java.awt.Color.BLACK);

            else if(buttons.get(i).getText().equals(String.valueOf(3)))
                buttons.get(i).setBackground(java.awt.Color.CYAN);

            else if(buttons.get(i).getText().equals(String.valueOf(4)))
                buttons.get(i).setBackground(java.awt.Color.PINK);

            else if(buttons.get(i).getText().equals(String.valueOf(5)))
                buttons.get(i).setBackground(java.awt.Color.GREEN);
        }
    }

    public void addColorsInArrayList(){
        colors.add(java.awt.Color.BLACK);
        colors.add(java.awt.Color.BLUE);
        colors.add(java.awt.Color.CYAN);
        colors.add(java.awt.Color.DARK_GRAY);
        colors.add(java.awt.Color.GRAY);
        colors.add(java.awt.Color.GREEN);
        colors.add(java.awt.Color.LIGHT_GRAY);
        colors.add(java.awt.Color.ORANGE);
        colors.add(java.awt.Color.PINK);
        colors.add(java.awt.Color.RED);
        colors.add(java.awt.Color.WHITE);
        colors.add(java.awt.Color.YELLOW);
    }
}
