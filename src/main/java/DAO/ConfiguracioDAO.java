/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Configuracio;
import Model.Utilitats;
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
public class ConfiguracioDAO {
    
    public static Configuracio llistar() throws SQLException, ClassNotFoundException, Exception
    {
            
            Connection con = Connexio.initializeDatabase(); 
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM configuracio";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
           
            int codisMin = rs.getInt("codis_min");
            int alumnesAula = rs.getInt("alumnes_aula");
            String direccioCorreu = rs.getString("direccio_correu");
            String contrasenyaCorreu = Utilitats.Desencriptar(rs.getString("contrasenya_correu"));
            String correuEnviaCodis = rs.getString("correu_envia_codis");
            String correuEnviaAlertaCodis = rs.getString("correu_envia_alerta_codis");
            Configuracio c = new Configuracio(codisMin, alumnesAula, direccioCorreu, contrasenyaCorreu, correuEnviaCodis, correuEnviaAlertaCodis);
            
            rs.close();
            con.close(); 
            
            return c;
    }
    public static void modificar(Configuracio c) throws SQLException, ClassNotFoundException{
            Connection con = Connexio.initializeDatabase(); 

            PreparedStatement pt = con.prepareStatement("UPDATE configuracio SET codis_min = '" + c.getCodisMin()
                                                            + "', alumnes_aula= '" + c.getAlumnesAula()
                                                            + "', direccio_correu= '" + c.getDireccioCorreu()
                                                            + "', contrasenya_correu= '" + Utilitats.Encriptar(c.getContrasenyaCorreu())
                                                            + "', correu_envia_codis= '" + c.getCorreuEnviaCodis()
                                                            + "', correu_envia_alerta_codis= '" + c.getCorreuEnviaAlertaCodis() + "'");

            pt.executeUpdate(); 

            pt.close(); 
            con.close();
    }
}
