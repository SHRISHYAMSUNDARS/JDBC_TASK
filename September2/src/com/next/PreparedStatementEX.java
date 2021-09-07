package com.next;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter The Values For StudentDetails Table");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();sc.nextLine();
		String name=sc.nextLine();
		String clg=sc.nextLine();
		Double Percent=sc.nextDouble();sc.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/New","SHRI","Shri@123");
			String query="insert into StudentDetails values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, clg);
			ps.setDouble(4, Percent);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Updated Sucessfully");
			}
			else {
				System.out.println("Not Updated");
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
