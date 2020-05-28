/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Codi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.LlistaCodis;
import java.sql.Connection;
import java.sql.Date;
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
            
                PreparedStatement st = con.prepareStatement("INSERT INTO codis_mos VALUES(?, ?, ?, ?, ?, ?)"); 

                st.setString(1, llistaMOS.get(i).getUsuari()); 
                st.setString(2, llistaMOS.get(i).getPassword()); 
                st.setString(3, llistaMOS.get(i).getPracticeTest()); 
                st.setString(4, llistaMOS.get(i).getCodiExamen());
                st.setDate(5, new Date(System.currentTimeMillis()));
                st.setInt(6, 0);
                
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
            
                PreparedStatement st = con.prepareStatement("INSERT INTO codis_mta VALUES(?, ?, ?, ?, ?)"); 

                st.setString(1, llistaMTA.get(i).getUsuari()); 
                st.setString(2, llistaMTA.get(i).getPassword()); 
                st.setString(3, llistaMTA.get(i).getPracticeTest());
                st.setDate(4, new Date(System.currentTimeMillis()));
                st.setInt(5, 0);
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