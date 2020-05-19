/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Francesc
 */
public class LoginDAO {
    public static String tipusUsuari (String nomUsuari, String contrassenya) throws SQLException, ClassNotFoundException {
		String sql = "Select tipusUsuari from usuaris where nom='" + nomUsuari + "' AND contrassenya='" + contrassenya + "';";
                String tipusUsuari = "";
	   //execute sql query
	   	ResultSet resultat = ConnexioBDD.statementBDD().executeQuery(sql);
		while(resultat.next()){
			tipusUsuari = resultat.getString("tipusUsuari");
		}
                
		return tipusUsuari;

	}
}
