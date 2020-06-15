/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Utilitats;
import Model.Usuari;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class LoginDAO {
    /**
     * Comproba quin rol té un Usuari
     * @param u
     * @param c
     * @return String
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public String loguear(String u, String c) throws SQLException, ClassNotFoundException{
        Connection conn = Connexio.initializeDatabase();
        PreparedStatement pst;
        ResultSet rs;
        String tipusUsuari= "0";
        String sql = "select tipus_usuari, id_usuari from usuaris where nom='" + u + "' and password='" + c + "'";
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
    public Usuari loguear2(String u, String c) throws SQLException, ClassNotFoundException{
        Connection conn = Connexio.initializeDatabase();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from usuaris where nom='" + u + "' and password='" + c + "'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();

        Usuari usuari = new Usuari(rs.getInt("id_usuari"), rs.getString("nom"), rs.getString("cognoms"), rs.getString("dni"), rs.getString("adreca"), rs.getString("correu"), rs.getString("telefon"), rs.getString("password"), rs.getString("tipus_usuari"), rs.getString("llista_examens"));
        
        rs.close();
        pst.close();
        conn.close();            
        return usuari;
    }
    /*
    public static String tipusUsuari (String nomUsuari, String contrassenya) throws SQLException, ClassNotFoundException {
                Connection con = Connexio.initializeDatabase();
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
*/
}
