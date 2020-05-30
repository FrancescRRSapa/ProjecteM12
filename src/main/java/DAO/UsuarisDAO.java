/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.LlistaUsuaris;
import Model.Usuari;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ferna
 */
public class UsuarisDAO {
    public static LlistaUsuaris llistar() throws SQLException, ClassNotFoundException
    {
        LlistaUsuaris llistatUsuaris = new LlistaUsuaris();
            
            Connection con = Conexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM usuaris";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int idUsuari  = rs.getInt("id_usuari");
                String nom = rs.getString("nom");
                String cognoms = rs.getString("cognoms");
                String dni = rs.getString("dni");
                String adreca = rs.getString("adreca");
                String correu = rs.getString("correu");
                String telefon = rs.getString("telefon");
                String password = rs.getString("password");
                String tipusUsuari = rs.getString("tipus_usuari");
                String llistaExamens = rs.getString("llista_examens");
                
                Usuari u = new Usuari(idUsuari, nom, cognoms, dni, adreca, correu, telefon, password, tipusUsuari, llistaExamens);
                llistatUsuaris.add(u);
            }
            rs.close();
            con.close(); 
            
            return llistatUsuaris;
    }
    
    public static Usuari buscar(int id) throws SQLException, ClassNotFoundException{
        Connection con = Conexio.initializeDatabase(); 
        Statement stmt = con.createStatement();

        String sql = "SELECT * FROM usuaris WHERE id_usuari='" + id + "'";
        ResultSet rs = stmt.executeQuery(sql);
            
        rs.next();
        
        int idUsuari  = rs.getInt("id_usuari");
        String nom = rs.getString("nom");
        String cognoms = rs.getString("cognoms");
        String dni = rs.getString("dni");
        String adreca = rs.getString("adreca");
        String correu = rs.getString("correu");
        String telefon = rs.getString("telefon");
        String password = rs.getString("password");
        String tipusUsuari = rs.getString("tipus_usuari");
        String llistaExamens = rs.getString("llista_examens");

        Usuari u = new Usuari(idUsuari, nom, cognoms, dni, adreca, correu, telefon, password, tipusUsuari, llistaExamens);   
        rs.close();
        con.close(); 
            
        return u;
    }
}
