/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ferna
 */
public class Conexion {
    String driver;
    String url;
    String usuari;
    String pwd;
    public Conexion(){
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/practicam12";
        usuari = "root";
        pwd = "";
    }
    
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
