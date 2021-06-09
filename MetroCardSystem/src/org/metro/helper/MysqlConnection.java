package org.metro.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//1.2 Connect
		//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/metro", "root", "root");

	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/metro","root","");
		return connection;
	}
}
