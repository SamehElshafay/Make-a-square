/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import finalproject.View.SquareView;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eng.SamehElshafay
 */
public class Finalproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {
        new SquareView().setVisible(true);
    }
}
