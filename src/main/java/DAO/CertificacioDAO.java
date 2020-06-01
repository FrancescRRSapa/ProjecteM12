/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Certificacio;
import Model.LlistaCertificacions;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class CertificacioDAO {
    /**
     * Insereix una Certificacio a la base de dades
     * @param c
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void inserir(Certificacio c) throws SQLException, ClassNotFoundException{
        try (Connection con = Connexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO certificacions VALUES(?,?,?,?,?)");
            ps.setString(1, c.getNom());
            ps.setString(2, c.getDescripcio());
            ps.setDate(3, c.getDataPublicacio());
            ps.setString(4, c.getNivellAlumneRecomanat());
            ps.setString(5, String.join("; ",c.getTarifes()));
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    /**
     * Llegeix totes les Certificacions de la base de dades
     * @return LlistaCertificacions
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static LlistaCertificacions llistar() throws SQLException, ClassNotFoundException
    {
        LlistaCertificacions llistatCertificacions = new LlistaCertificacions();
            
            Connection con = Connexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM certificacions";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int idCertificacio = rs.getInt("id_certificacio");
                String nom = rs.getString("nom");
                String descripcio = rs.getString("descripcio");
                Date dataPublicacio = rs.getDate("data_publicacio");
                String nivellAlumneRecomanat = rs.getString("nivell_alumne_recomanat");
                String tarifes = rs.getString("tarifes");
                Certificacio c = new Certificacio(idCertificacio, nom, descripcio, dataPublicacio, nivellAlumneRecomanat, tarifes);
                llistatCertificacions.add(c);
            }
            rs.close();
            con.close(); 
            
            return llistatCertificacions;
    }
    /**
     * Esborra el registre de la base de dades que correspon al id
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Connexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM certificacions WHERE id_certificacio = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
    /**
     * Modifica la Certificacio amb la noves dades i les enregistra a base de dades
     * @param c
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void modificar(Certificacio c) throws SQLException, ClassNotFoundException{
            Connection con = Connexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE certificacions SET nom = '" + c.getNom()
                                                            + "', descripcio= '" + c.getDescripcio()
                                                            + "', data_publicacio= '" + c.getDataPublicacio()
                                                            + "', nivell_alumne_recomanat= '" + c.getNivellAlumneRecomanat()
                                                            + "', tarifes= '" + String.join("; ",c.getTarifes())
                                                            + "', descripcio= '" + c.getDescripcio()
                                                            + "' WHERE id_certificacio = '" + c.getIdCertificacio() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
