/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.Controller;

import javax.swing.JFrame;

/**
 *
 * @author Eng.SamehElshafay
 */
public class View {
    public void openView(JFrame destinationFrame,JFrame sourceFrame){
        startView(destinationFrame);
        closeView(sourceFrame);
    }
    public void startView(JFrame nextFrame){
        nextFrame.setVisible(true);
    }
    public void closeView(JFrame currentFrame){
        currentFrame.dispose();
    }
}
