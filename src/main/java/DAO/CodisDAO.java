/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.CodiMTA;
import Model.CodiMOS;
import Model.LlistaCodisMTA;
import Model.LlistaCodisMOS;
import java.io.InputStream;
import java.sql.Connection;
/**
 *
 * @author Francesc
 * @author Sergio
 */

public class CodisDAO {
    /*
    public static void inserirCodisMTA(InputStream file) throws SQLException, ClassNotFoundException {
        LlistaCodisMTA llistatCodis = new LlistaCodisMTA();
        ArrayList<CodiMTA> codis = new ArrayList<>();
        codis =(ArrayList<CodiMTA>) llistatCodis.llegirCodis(file);
        for(int i = 0; i < codis.size(); i++){
            String query = "INSERT INTO `codis_mta`(`usuari`, `password`, `practicetest`) VALUES ('"+codis.get(i).getUsuari()+"', '"+codis.get(i).getPassword()+"', '"+codis.get(i).getPracticeTest()+"');";
            PreparedStatement statement = ConnexioBDD.conexioBDD().prepareStatement(query);
            int files = statement.executeUpdate(query);
        }
    }
    public static void inserirCodisMOS(InputStream file) throws SQLException, ClassNotFoundException {
        LlistaCodisMOS llistatCodis = new LlistaCodisMOS();
        ArrayList<CodiMOS> codis = new ArrayList<>();
        codis =(ArrayList<CodiMOS>) llistatCodis.llegirCodis(file);
        for(int i = 0; i < codis.size(); i++){
            String query = "INSERT INTO `codis_mos`(`usuari`, `password`, `practicetest`, `codiexamen`) VALUES ('"+codis.get(i).getUsuari()+"', '"+codis.get(i).getPassword()+"', '"+codis.get(i).getCodiExamen()+"', '"+codis.get(i).getPracticeTest()+");";
            PreparedStatement statement = ConnexioBDD.conexioBDD().prepareStatement(query);
            int files = statement.executeUpdate(query);
        }
    }
*/
    //Per inserir codis de MOS
    public static void inserirCodisMOS(ArrayList<CodiMOS> llistaMOS){
       try{
            for(int i = 0; i < llistaMOS.size(); i++){
                Connection con = Conexion.initializeDatabase();
            
                PreparedStatement st = con.prepareStatement("INSERT INTO codis_mos VALUES(?, ?, ?, ?)"); 

                st.setString(1, llistaMOS.get(i).getUsuari()); 
                st.setString(2, llistaMOS.get(i).getPassword()); 
                st.setString(3, llistaMOS.get(i).getPracticeTest()); 
                st.setString(4, llistaMOS.get(i).getCodiExamen());

                st.executeUpdate(); 
                con.close();
                st.close(); 
            }
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();  
        }finally{
       }
    }
    //Per inserir codis de MTA
    public static void inserirCodisMTA(ArrayList<CodiMOS> llistaMTA){
       try{
            for(int i = 0; i < llistaMTA.size(); i++){
                Connection con = Conexion.initializeDatabase();
            
                PreparedStatement st = con.prepareStatement("INSERT INTO codis_mta VALUES(?, ?, ?)"); 

                st.setString(1, llistaMTA.get(i).getUsuari()); 
                st.setString(2, llistaMTA.get(i).getPassword()); 
                st.setString(3, llistaMTA.get(i).getPracticeTest()); 

                st.executeUpdate(); 
                con.close();
                st.close(); 
            }
        }catch (ClassNotFoundException | SQLException e){ 
            e.printStackTrace();
        }finally{
       }
    }
}

