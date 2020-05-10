package com.mycompany.proyectom12.DAO;
import java.sql.*;

public class ConnexioBDD {
	public static Statement statementBDD() throws SQLException, ClassNotFoundException{
		Statement myStmt = conexioBDD().createStatement();
		return myStmt;
	}
	
	public static Connection conexioBDD() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection myConn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/practicam12?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		return myConn;
	}
}
		
		
	   //Posar tot aix� al fitxer ClientDAO
	   /*
	   //create statement
	   Statement myStmt = myConn.createStatement();
	   
	   String sql = "Select * from clients";
	   //execute sql query
	   ResultSet myRs = myStmt.executeQuery(sql);
	
	   myConn.close();
	   //results set
	   while (myRs.next()) {
	    System.out.println(myRs.getString("COL 1")+ " , "+myRs.getString("COL 2")+ " , "+myRs.getString("COL 3") +" , "+myRs.getString("COL 4"));
	   }
	   myRs.close();
	   myStmt.close();
	   myConn.close();
	  */