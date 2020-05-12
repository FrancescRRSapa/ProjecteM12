/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectom12.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mycompany.llegircsv.llistaCodis;
import com.mycompany.llegircsv.Codi;
/**
 *
 * @author Francesc
 */
public class CodisDAO {
    public static void inserirCodis() throws SQLException, ClassNotFoundException {
            llistaCodis llistatCodis = new llistaCodis();
            ArrayList<Codi> codis = new ArrayList<>();
            codis =(ArrayList<Codi>) llistatCodis.llegirCodis();
            for(int i = 0; i < codis.size(); i++){
                String query = "INSERT INTO `codis`(`usuari`, `password`, `practicetest`) VALUES ('"+codis.get(i).getUsuari()+"', '"+codis.get(i).getPassword()+"', '"+codis.get(i).getPracticeTest()+"');";
                PreparedStatement statement = ConnexioBDD.conexioBDD().prepareStatement(query);
                int files = statement.executeUpdate(query);    
            }
	}
}
