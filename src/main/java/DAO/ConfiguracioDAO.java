/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Configuracio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ferna
 */
public class ConfiguracioDAO {
    
    public static Configuracio llistar() throws SQLException, ClassNotFoundException
    {
            
            Connection con = Conexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM configuracio";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
           
            int codisMin = rs.getInt("codis_min");
            int alumnesAula = rs.getInt("alumnes_aula");
            String direccioCorreu = rs.getString("direccio_correu");
            String contrasenyaCorreu = rs.getString("contrasenya_correu");
            String correuEnviaCodis = rs.getString("correu_envia_codis");
            String correuEnviaAlertaCodis = rs.getString("correu_envia_alerta_codis");
            Configuracio c = new Configuracio(codisMin, alumnesAula, direccioCorreu, contrasenyaCorreu, correuEnviaCodis, correuEnviaAlertaCodis);
            
            rs.close();
            con.close(); 
            
            return c;
    }
    /*
    public static void modificar(Configuracio c) throws SQLException, ClassNotFoundException{
            Connection con = Conexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE concepte SET nom = '" + c.getNom()
                                                            + "', data_alta= '" + c.getDataAlta()
                                                            + "', data_baixa= '" + c.getDataBaixa()
                                                            + "' WHERE id_grup_partit = '" + c.getIdConcepte() + "'"); 

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
    */
}
