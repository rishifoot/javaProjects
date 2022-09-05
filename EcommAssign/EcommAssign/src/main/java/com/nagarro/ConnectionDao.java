package com.nagarro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
	private static Connection con;

    public static Connection getCon() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        return con;
    }
}
