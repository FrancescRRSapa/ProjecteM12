/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class Connexio {
    String driver;
    String url;
    String usuari;
    String pwd;
    /**
     * Connexió a la base de dades
     * @return Connection
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
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
    /**
     * Comprova si un Usuari és troba a la base de dades i el seu rol
     * @param u
     * @param c
     * @return String rol
     */
    public String loguear(String u, String c){
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String tipusUsuari= "0";
        String sql = "select tipusUsuari from usuaris where nom='" + u + "' and contrassenya='" + c + "'";
        try{
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.usuari, this.pwd);
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                tipusUsuari = rs.getString(1);
            }
            conn.close();
        }catch (ClassNotFoundException | SQLException e){
            
        }
        return tipusUsuari;
        
    }
}
