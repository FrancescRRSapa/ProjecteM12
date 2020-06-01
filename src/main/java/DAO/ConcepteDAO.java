/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Concepte;
import Model.LlistaConceptes;
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
public class ConcepteDAO {
    /**
     * Insereix un Concepte a la base de dades
     * @param c
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void inserir(Concepte c) throws SQLException, ClassNotFoundException{
        try (Connection con = Connexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO concepte VALUES(?,?,?,?)");
            ps.setInt(1, c.getIdConcepte());
            ps.setString(2, c.getNom());
            ps.setDate(3, c.getDataAlta());
            ps.setDate(4, c.getDataBaixa());
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    /**
     * Llista tots els conceptes de la base de dades
     * @return LlistaConceptes
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static LlistaConceptes llistar() throws SQLException, ClassNotFoundException
    {
        LlistaConceptes llistatConceptes = new LlistaConceptes();
            
            Connection con = Connexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM concepte";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int idConcepte = rs.getInt("id_concepte");
                String nom = rs.getString("nom");
                Date dataAlta = rs.getDate("data_alta");
                Date dataBaixa = rs.getDate("data_baixa");
                Concepte c = new Concepte(idConcepte, nom, dataAlta, dataBaixa);
                llistatConceptes.add(c);
            }
            rs.close();
            con.close(); 
            
            return llistatConceptes;
    }
    /**
     * Esborra el Concepte de la base de dades que correspon al id
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Connexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM concepte WHERE id_concepte = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
    /**
     * Modifica un concepte amb l'informació passada per parametre
     * @param c
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void modificar(Concepte c) throws SQLException, ClassNotFoundException{
            Connection con = Connexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE concepte SET nom = '" + c.getNom()
                                                            + "', data_alta= '" + c.getDataAlta()
                                                            + "', data_baixa= '" + c.getDataBaixa()
                                                            + "' WHERE id_grup_partit = '" + c.getIdConcepte() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
