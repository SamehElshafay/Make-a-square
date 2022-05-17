/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.DataBase;

import finalproject.Model.Square;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eng.SamehElshafay
 */
public class DataBase {
    private String DataBaseName ;
    private String DataBasePassword ;
    private Connection connection ;
    
    public DataBase(String DataBaseName , String DataBasePassword ){
        this.DataBaseName = DataBaseName ;
        this.DataBasePassword = DataBasePassword ;
    }
    
    private Connection createConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makeasquare?","root","");
        return connection;
    }
    void selectAllShapes() throws SQLException, ClassNotFoundException{
        connection = createConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from shape";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(String.valueOf(resultSet.getInt("ROWSNUMBER")));
        }
        connection.close();
    }
    
    public void insertSquare(String tableName , Square square) throws SQLException, ClassNotFoundException{
        connection = createConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO " + tableName + " VALUES ('"
                + square.getSquareID()
                + "','"  + square.getNumberOfShapes()
                + "', '" + square.getFirstShapeID()
                + "', '" + square.getSecondShapeID()
                + "', '" + square.getThirdShapeID()
                + "', '" + square.getFourthShapeID()
                + "', '" + square.getFifthShapeID()
                + "', '" + square.getSquareName() + "')");
        connection.close();
    }
    
    public int getNumberOfRows(String tableName){
        int count = 0 ;
        try {
            try {
                connection = createConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select count(*) from " + tableName);
                resultSet.next();
                count = resultSet.getInt(1);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    public ArrayList<String[]> getShapeStructureAndID(){
        ArrayList <String[]> shape = new ArrayList();
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from shapestructure";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                
                String shapeTemp[] = {
                    String.valueOf(resultSet.getInt("ShapeStructureID")) ,
                    String.valueOf(resultSet.getString("structure")) 
                } ;
                
                shape.add(shapeTemp);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shape ;
    }
    
    public ArrayList<Square> getAllSquares(){
        ArrayList <Square> squares = new ArrayList();
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from square";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                squares.add(getSquare(resultSet));
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return squares ;
    }
    public Square getSquare(ResultSet resultSet) throws SQLException{
        Square square = new Square();
        square.setSquareID(resultSet.getInt("SquareID")) ;
        square.setNumberOfShapes(resultSet.getInt("NumberOfShapes"));
        square.setFirstShapeID(resultSet.getInt("FirstShapeID"));
        square.setSecondShapeID(resultSet.getInt("SecondShapeID"));
        square.setThirdShapeID(resultSet.getInt("ThirdShapeID"));
        square.setFourthShapeID(resultSet.getInt("FourthShapeID"));
        square.setFifthShapeID(resultSet.getInt("FifthShapeID"));
        square.setSquareName(resultSet.getString("squareName"));
        return square;
    }
}