/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Codi;
import Model.CodiMOS;
import Model.CodiMTA;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.LlistaCodis;
import java.sql.Connection;
import java.sql.Date;
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
    
    public static LlistaCodis llistarCodisMOS()
    {
        LlistaCodis llista = new LlistaCodis();
        try
        {
            Connection con = Conexio.initializeDatabase();
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM codis_mos";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                String usuari  = rs.getString("usuari");
                String password = rs.getString("password");
                String practiceTest = rs.getString("practice_test");
                String examen = rs.getString("examen");
                Date data = rs.getDate("date");
                int usuariId = rs.getInt("usuari_id");
                
                CodiMOS c = new CodiMOS(usuari, password, practiceTest, examen, data, usuariId);
                //llistaFeines.add(f);
                llista.add(c);
            }
            rs.close();
            con.close(); 
            
        }
        catch (Exception e) { 
            e.printStackTrace();
        } 
        //return llistaFeines;
        return llista;
    }
    
    public static void esborrarCodisMOS(Date data)
    {
        try
        {
            Connection con = Conexio.initializeDatabase();
            PreparedStatement st = con.prepareStatement("DELETE FROM codis_mos WHERE date = '" + data + "'");

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
        }
        catch (Exception e) 
        { 
            e.printStackTrace();
        }
    }
    
    public static void assignarCodiMOS(int id, int usuari_id)
    {
        try
        {
            Connection con = Conexio.initializeDatabase();
            
            PreparedStatement st = con.prepareStatement("UPDATE codis_mos SET usuari_id = '" + usuari_id + "' WHERE usuari = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
        }
        catch (Exception e) 
        { 
            e.printStackTrace();
            
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
    public static LlistaCodis llistarCodisMTA()
    {
        LlistaCodis llista = new LlistaCodis();
        try
        {
            Connection con = Conexio.initializeDatabase();
            Statement stmt = con.createStatement();
            
            String sql = "SELECT * FROM codis_mta";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                String usuari  = rs.getString("usuari");
                String password = rs.getString("password");
                String practiceTest = rs.getString("practice_test");
                Date data = rs.getDate("date");
                int usuariId = rs.getInt("usuari_id");
                
                CodiMTA c = new CodiMTA(usuari, password, practiceTest, data, usuariId);
                //llistaFeines.add(f);
                llista.add(c);
            }
            rs.close();
            con.close(); 
            
        }
        catch (Exception e) { 
            e.printStackTrace();
        } 
        //return llistaFeines;
        return llista;
    }
    
    public static void esborrarCodisMTA(Date data)
    {
        try
        {
            Connection con = Conexio.initializeDatabase();
            PreparedStatement st = con.prepareStatement("DELETE FROM codis_mta WHERE date = '" + data + "'");

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
        }
        catch (Exception e) 
        { 
            e.printStackTrace();
        }
    }
    
    public static void assignarCodiMTA(int id, int usuari_id)
    {
        try
        {
            Connection con = Conexio.initializeDatabase();
            
            PreparedStatement st = con.prepareStatement("UPDATE codis_mta SET usuari_id = '" + usuari_id + "' WHERE usuari = '" + id + "'"); 

            st.executeUpdate(); 

            st.close(); 
            con.close(); 
        }
        catch (Exception e) 
        { 
            e.printStackTrace();
            
        } 
    }
}