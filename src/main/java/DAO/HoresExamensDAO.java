/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.HoraExamen;
import Model.LlistaHoresExamens;
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
public class HoresExamensDAO {
    
    public static void inserir(HoraExamen h) throws SQLException, ClassNotFoundException{
        try (Connection con = Conexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO hora_examen VALUES(?,?,?)");
            ps.setDate(1, h.getDiaSetmana());
            ps.setString(2, h.getHora());
            ps.setString(3, h.getTipus());
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    
    public static LlistaHoresExamens llistar() throws SQLException, ClassNotFoundException
    {
        LlistaHoresExamens llistatHoresExamens = new LlistaHoresExamens();
            
            Connection con = Conexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM hora_examen";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int idHoraExamen = rs.getInt("id_hora_examen");
                Date diaSetmana = rs.getDate("dia_setmana");
                String hora = rs.getString("hora");
                String tipus = rs.getString("tipus");
                HoraExamen h = new HoraExamen(idHoraExamen, diaSetmana, hora, tipus);
                llistatHoresExamens.add(h);
            }
            rs.close();
            con.close();
            
            return llistatHoresExamens;
    }
    
    public static HoraExamen buscar(int id) throws SQLException, ClassNotFoundException{
        Connection con = Conexio.initializeDatabase(); 
        Statement stmt = con.createStatement();

        String sql = "SELECT * FROM hora_examen WHERE id_hora_examen='" + id + "'";
        ResultSet rs = stmt.executeQuery(sql);
        
        int idHoraExamen = rs.getInt("id_hora_examen");
        Date diaSetmana = rs.getDate("dia_setmana");
        String hora = rs.getString("hora");
        String tipus = rs.getString("tipus");
        HoraExamen h = new HoraExamen(idHoraExamen, diaSetmana, hora, tipus);
        
        rs.close();
        con.close();
        
        return h;
    }
    
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Conexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM hora_examen WHERE id_hora_examen = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
    
    public static void modificar(HoraExamen h) throws SQLException, ClassNotFoundException{
            Connection con = Conexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE hora_examen SET dia_setmana = '" + h.getDiaSetmana()
                                                            + "', hora= '" + h.getHora()
                                                            + "', tipus= '" + h.getTipus()
                                                            + "' WHERE id_hora_examen = '" + h.getIdHoraExamen() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
