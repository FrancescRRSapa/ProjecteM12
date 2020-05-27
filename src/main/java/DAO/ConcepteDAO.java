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
 *
 * @author ferna
 */
public class ConcepteDAO {
    public static void inserir(Concepte c) throws SQLException, ClassNotFoundException{
        try (Connection con = Conexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO concepte VALUES(?,?,?,?)");
            ps.setInt(1, c.getIdConcepte());
            ps.setString(2, c.getNom());
            ps.setDate(3, c.getDataAlta());
            ps.setDate(4, c.getDataBaixa());
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    
    public static LlistaConceptes llistar() throws SQLException, ClassNotFoundException
    {
        LlistaConceptes llistatConceptes = new LlistaConceptes();
            
            Connection con = Conexio.initializeDatabase(); 
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
    
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Conexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM concepte WHERE id_concepte = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
    
    public static void modificar(Concepte c) throws SQLException, ClassNotFoundException{
            Connection con = Conexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE concepte SET nom = '" + c.getNom()
                                                            + "', data_alta= '" + c.getDataAlta()
                                                            + "', data_baixa= '" + c.getDataBaixa()
                                                            + "' WHERE id_grup_partit = '" + c.getIdConcepte() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
