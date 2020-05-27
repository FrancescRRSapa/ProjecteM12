/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.CodiMTA;
import Model.CodiMOS;
import Model.LlistaCodis;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Francesc
 * @author Sergio
 */

public class CodisDAO {
    //Per inserir codis de MOS
    public static void inserirCodisMOS(LlistaCodis llistaMOS){
       try{
            for(int i = 1; i < llistaMOS.size(); i++){
                Connection con = Conexio.initializeDatabase();
            
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
    public static void inserirCodisMTA(LlistaCodis llistaMTA){
       try{
            for(int i = 1; i < llistaMTA.size(); i++){
                Connection con = Conexio.initializeDatabase();
            
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
    
    public static LlistaCodis llistarCodiMTA() throws SQLException, ClassNotFoundException{
        LlistaCodis llistatCodis = new LlistaCodis();
        Connection con = Conexio.initializeDatabase();
        Statement stmt = con.createStatement();
        String sql = "SELECT ^ from codi_mta";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String usuari = rs.getString("");
        }
    }
}