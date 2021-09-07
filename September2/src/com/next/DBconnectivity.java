package com.next;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnectivity{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/New","SHRI","Shri@123");
			Statement st=con.createStatement();
			String query="insert into StudentDetails values(101,'Virat','MRF',100.00)";
			int i=st.executeUpdate(query);
			if(i>0) {
				System.out.println("Updated Sucessfully");
			}
			else {
				System.out.println("Not Updated");
			}
			st.close();
			con.close();	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}   
	}
}
