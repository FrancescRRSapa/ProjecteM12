/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.GrupPartit;
import Model.LlistaGrupsPartits;
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
public class GrupPartitDAO {
    public static void inserir(GrupPartit g) throws SQLException, ClassNotFoundException{
        try (Connection con = Conexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO grup_partit VALUES(?,?,?,?)");
            ps.setInt(1, g.getIdGrupPartit());
            ps.setString(2, g.getNom());
            ps.setDate(3, g.getDataAlta());
            ps.setDate(4, g.getDataBaixa());
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    
    public static LlistaGrupsPartits llistar() throws SQLException, ClassNotFoundException
    {
        LlistaGrupsPartits llistatGrupsPartits = new LlistaGrupsPartits();
            
            Connection con = Conexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM grup_partit";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int idGrupPartit = rs.getInt("id_grup_partit");
                String nom = rs.getString("nom");
                Date dataAlta = rs.getDate("data_alta");
                Date dataBaixa = rs.getDate("data_baixa");
                GrupPartit g = new GrupPartit(idGrupPartit, nom, dataAlta, dataBaixa);
                llistatGrupsPartits.add(g);
            }
            rs.close();
            con.close(); 
            
            return llistatGrupsPartits;
    }
    
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Conexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM grup_partit WHERE id_tarifa = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
    
    public static void modificar(GrupPartit g) throws SQLException, ClassNotFoundException{
            Connection con = Conexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE grup_partit SET nom = '" + g.getNom()
                                                            + "', data_alta= '" + g.getDataAlta()
                                                            + "', data_baixa= '" + g.getDataBaixa()
                                                            + "' WHERE id_grup_partit = '" + g.getIdGrupPartit() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
