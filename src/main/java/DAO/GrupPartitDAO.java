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
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class GrupPartitDAO {
    /**
     * Insereix un nou GrupPartit a la base de dades
     * @param g
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void inserir(GrupPartit g) throws SQLException, ClassNotFoundException{
        try (Connection con = Connexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO grup_partit VALUES(?,?,?,?)");
            ps.setInt(1, g.getIdGrupPartit());
            ps.setString(2, g.getNom());
            ps.setDate(3, g.getDataAlta());
            ps.setDate(4, g.getDataBaixa());
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    /**
     * Llista tots els GrupsPartits de la base de dades
     * @return LlistaGrupsPartits
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static LlistaGrupsPartits llistar() throws SQLException, ClassNotFoundException
    {
        LlistaGrupsPartits llistatGrupsPartits = new LlistaGrupsPartits();
            
            Connection con = Connexio.initializeDatabase(); 
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
    /**
     * Esborra el GrupPartit que correspon al id de la base de dades
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Connexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM grup_partit WHERE id_tarifa = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
    /**
     * Modifica el GrupPartit amb la nova informació pasada per paràmetre
     * @param g
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void modificar(GrupPartit g) throws SQLException, ClassNotFoundException{
            Connection con = Connexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE grup_partit SET nom = '" + g.getNom()
                                                            + "', data_alta= '" + g.getDataAlta()
                                                            + "', data_baixa= '" + g.getDataBaixa()
                                                            + "' WHERE id_grup_partit = '" + g.getIdGrupPartit() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
