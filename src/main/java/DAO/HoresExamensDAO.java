/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.HoraExamen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ferna
 */
public class HoresExamensDAO {
    /*
    public static void inserir(HoraExamen h) throws SQLException, ClassNotFoundException{
        try (Connection con = Conexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO hora_examen VALUES(?,?,?)");
            ps.setDate(1, h.getDiaSetmana());
            ps.setDate(2, g.getDataAlta());
            ps.setDate(3, g.getDataBaixa());
            
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
*/
}
