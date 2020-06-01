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
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class ReservesDAO {
    /**
     * Insereix una nova Reserva a la base de dades
     * @param r
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void inserir(Reserva r) throws SQLException, ClassNotFoundException{
        try (Connection con = Connexio.initializeDatabase()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO reserva VALUES(?,?)");
            ps.setInt(1, r.getUsuari().getIdUsuari());
            ps.setInt(2, r.getHoraExamen().getIdHoraExamen());
            
            ps.executeUpdate();
            
            ps.close();
        }
    }
    /**
     * llista les reserves existents a la base de dades
     * @return LlistaReserves
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static LlistaReserves llistar() throws SQLException, ClassNotFoundException
    {
        LlistaReserves llistatTarifes = new LlistaReserves();
            
            Connection con = Connexio.initializeDatabase(); 
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
    /**
     * Esborra la Reserva a la que correspon el id
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void esborrar(String id) throws SQLException, ClassNotFoundException
    {
            Connection con = Connexio.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("DELETE FROM reserva WHERE id_reserva = '" + id + "'");

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
    }
}
