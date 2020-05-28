/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.LlistaReserves;
import Model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ferna
 */
public class ReservesDAO {
    public static void inserir(Reserva r) throws SQLException, ClassNotFoundException{
        try (Connection con = Conexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO reserva VALUES(?,?)");
            ps.setInt(1, r.getIdUsuari());
            ps.setInt(2, r.getIdHoraExamen());
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    
    public static LlistaReserves llistar() throws SQLException, ClassNotFoundException
    {
        LlistaReserves llistatTarifes = new LlistaReserves();
            
            Connection con = Conexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM reserva";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int idReserva  = rs.getInt("id_reserva");
                int idUsuari = rs.getInt("id_usuari");
                int idHoraExamen = rs.getInt("id_hora_examen");
                Reserva r = new Reserva(idReserva, idUsuari, idHoraExamen);
                llistatTarifes.add(r);
            }
            rs.close();
            con.close(); 
            
            return llistatTarifes;
    }
    
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Conexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM reserva WHERE id_reserva = '" + id + "'");

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
}
