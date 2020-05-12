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