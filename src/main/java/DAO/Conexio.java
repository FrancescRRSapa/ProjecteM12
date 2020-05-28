/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ferna
 */
public class Conexio {
    String driver;
    String url;
    String usuari;
    String pwd;
    
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException 
    { 
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String mysqlConnUrl = "jdbc:mysql://localhost:3306/projecte";
        String dbUsername = "root"; 
        String dbPassword = ""; 
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(mysqlConnUrl, dbUsername, dbPassword); 
        return con; 
        
    }
}
