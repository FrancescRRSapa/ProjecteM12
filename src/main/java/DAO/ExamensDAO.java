/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Codi;
import Model.Examen;
import Model.LlistaExamens;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ferna
 */
public class ExamensDAO {
    public static void inserir(Examen e) throws SQLException, ClassNotFoundException{
        try (Connection con = Conexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuari_certificacio VALUES(?,?,?,?)");
            ps.setInt(1, e.getId_usuari());
            ps.setInt(2, e.getId_certificacio());
            ps.setBoolean(3, false);
            ps.setDate(4, new Date(System.currentTimeMillis()));
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    
    public static LlistaExamens llistar() throws SQLException, ClassNotFoundException
    {
        LlistaExamens llistatExamens = new LlistaExamens();
            
            Connection con = Conexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM usuari_certificacio";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int idExamen = rs.getInt("id_examen");
                int idUsuari = rs.getInt("id_usuari");
                int idCertificacio = rs.getInt("id_certificacio");
                boolean pagat = rs.getBoolean("pagat");
                Date dataSolicitud = rs.getDate("data_solicitud");
                Date dataPagament = rs.getDate("data_pagament");
                String codiId = rs.getString("codi_id");
                String estat = rs.getString("estat");
                
                Examen e = new Examen(idExamen, idUsuari, idCertificacio, pagat, dataSolicitud, dataPagament, codiId, estat);
                llistatExamens.add(e);
            }
            rs.close();
            stmt.close();
            con.close();
            
            return llistatExamens;
    }
    
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Conexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM usuari_certificacio WHERE id_examen = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
    
    public static void pagat(Examen e,Codi c) throws SQLException, ClassNotFoundException{
            Connection con = Conexio.initializeDatabase();
            
            PreparedStatement pt = con.prepareStatement("UPDATE usuari_certificacio SET pagat = '" + true
                                                            + "', data_pagament= '" + new Date(System.currentTimeMillis())
                                                            + "', codi_id= '" + c.getUsuari()
                                                            + "', estat= '" + "No evaluat"
                                                            + "' WHERE id_examen = '" + e.getId_examen() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
    
    public static void qualificat(Examen e, String resultat) throws SQLException, ClassNotFoundException{
            Connection con = Conexio.initializeDatabase();
            
            PreparedStatement pt = con.prepareStatement("UPDATE usuari_certificacio SET  estat= '" + resultat
                                                            + "' WHERE id_examen = '" + e.getId_examen() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
