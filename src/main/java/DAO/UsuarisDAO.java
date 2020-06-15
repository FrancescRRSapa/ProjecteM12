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
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class UsuarisDAO {
    /**
     * Llista tots els Usuaris de la base de dades
     * @return LlistaUsuaris
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static LlistaUsuaris llistar() throws SQLException, ClassNotFoundException
    {
        LlistaUsuaris llistatUsuaris = new LlistaUsuaris();
            
            Connection con = Connexio.initializeDatabase(); 
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
    /**
     * Cerca el Usuari al que correspon el id passat per paràmetre
     * @param id
     * @return Usuari
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Usuari buscar(int id) throws SQLException, ClassNotFoundException{
        Connection con = Connexio.initializeDatabase(); 
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
    /**
     * Cerca el id d'Usuari al que correspon al correu passat per paràmetre, si no existeix retorna 0
     * @param id
     * @return Usuari
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static int buscarId(String correu) throws SQLException, ClassNotFoundException{
        int idUsuari = 0;
        Connection con = Connexio.initializeDatabase(); 
        Statement stmt = con.createStatement();

        String sql = "SELECT * FROM usuaris WHERE correu='" + correu + "'";
        ResultSet rs = stmt.executeQuery(sql);
            
        while(rs.next()){
            idUsuari  = rs.getInt("id_usuari");
        }

        rs.close();
        con.close(); 
            
        return idUsuari;
    }
}
