/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.LlistaTarifes;
import Model.Tarifa;
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
public class TarifaDAO {
    /**
     * Insereix una Tarifa a la base de dades
     * @param t
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void inserir(Tarifa t) throws SQLException, ClassNotFoundException{
        try (Connection con = Connexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tarifa VALUES(?,?,?,?,?,?)");
            ps.setInt(1, t.getIdGrupPartit());
            ps.setInt(2, t.getIdConcepte());
            ps.setString(3, t.getNom());
            ps.setDouble(4, t.getPreu());
            ps.setDate(5, t.getDataAlta());
            ps.setDate(6, t.getDataBaixa());
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    /**
     * Llista les tarifes existents a la base de dades
     * @return LlistaTarifes
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static LlistaTarifes llistar() throws SQLException, ClassNotFoundException
    {
        LlistaTarifes llistatTarifes = new LlistaTarifes();
            
            Connection con = Connexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM tarifa";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int idFeina  = rs.getInt("id_tarifa");
                int idGrupPartit = rs.getInt("id_grup_partit");
                int idConcepte = rs.getInt("id_concepte");
                String nom = rs.getString("nom");
                Double preu = rs.getDouble("preu");
                Date dataAlta = rs.getDate("data_alta");
                Date dataBaixa = rs.getDate("data_baixa");
                Tarifa t = new Tarifa(idFeina, idGrupPartit, idConcepte, nom, preu, dataAlta, dataBaixa);
                llistatTarifes.add(t);
            }
            rs.close();
            con.close(); 
            
            return llistatTarifes;
    }
    /**
     * Esborra la tarifa que correspon al id de la base de dades
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Connexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM tarifa WHERE id_tarifa = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
    /**
     * Modifica la tarifa amb les dades passades per paràmetre
     * @param t
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void modificar(Tarifa t) throws SQLException, ClassNotFoundException{
            Connection con = Connexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE tarifa SET id_grup_partit = '" + t.getIdGrupPartit()
                                                            + "', id_concepte = '" + t.getIdConcepte()
                                                            + "', nom = '" + t.getNom()
                                                            + "', preu= '" + t.getPreu()
                                                            + "', data_alta= '" + t.getDataAlta()
                                                            + "', data_baixa= '" + t.getDataBaixa()
                                                            + "' WHERE id_tarifa = '" + t.getIdTarifa() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
