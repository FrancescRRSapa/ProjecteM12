/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Utilitats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Francesc
 */
public class LoginDAO {
    public String loguear(String u, String c) throws SQLException, ClassNotFoundException{
        Connection conn = Conexio.initializeDatabase();
        PreparedStatement pst;
        ResultSet rs;
        String tipusUsuari= "0";
        String sql = "select tipus_usuari from usuaris where nom='" + u + "' and password='" + c + "'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            tipusUsuari = rs.getString(1);
        }
        rs.close();
        pst.close();
        conn.close();            
        return tipusUsuari;
    }
    public static String tipusUsuari (String nomUsuari, String contrassenya) throws SQLException, ClassNotFoundException {
                Connection con = Conexio.initializeDatabase();
                Statement stmt = con.createStatement();
		String sql = "Select tipusUsuari from usuaris where nom='" + nomUsuari + "' AND password='" + contrassenya + "';";
                String tipusUsuari = "";
	   //execute sql query
	   	ResultSet resultat = stmt.executeQuery(sql);
		while(resultat.next()){
			tipusUsuari = resultat.getString("tipus_usuari");
		}
                resultat.close();
                stmt.close();
                con.close();
		return tipusUsuari;
	}
}
