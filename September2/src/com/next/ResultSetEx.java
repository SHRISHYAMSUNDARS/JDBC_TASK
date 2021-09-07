package com.next;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/New","SHRI","Shri@123");
			Statement st=con.createStatement();
			String query="select * from StudentDetails";
			ResultSet s=st.executeQuery(query);
			while(s.next()) {
				System.out.println(s.getInt(1)+" | "+s.getString(2)+" | "+s.getString(3)+" | "+s.getInt(4));
			}
			st.close();
			con.close();	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}   

	}

}
