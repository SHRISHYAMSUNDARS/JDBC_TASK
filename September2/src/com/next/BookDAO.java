package com.next;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BookDAO implements BookDAOImp1 {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName(driverclass);
			con=DriverManager.getConnection(jdbcurl,username,password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	@Override
	public void insertBook(Book b)  {
		// TODO Auto-generated method stub
		String query="insert into Book values(?,?,?,?)";
		try(Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, b.getSerialNumber());
			ps.setString(2, b.getBookName());
			ps.setString(3, b.getBookAuthor());
			ps.setDouble(4, b.getBookCost());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Book selectBook(long SerialNumber) {
		// TODO Auto-generated method stub
		Book b=null;
		String query="select * from Book where SerialNumber=?";
		try(Connection con=getConnection()){
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1,SerialNumber);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new Book();
				b.setSerialNumber(SerialNumber);
				b.setBookName(rs.getString(2));
				b.setBookAuthor(rs.getString(3));
				b.setBookCost(rs.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Book> selectAllBook() {
		// TODO Auto-generated method stub
		List<Book> a=new ArrayList<Book>();
		try(Connection con=getConnection()){
		String query="select * from Book";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet s=ps.executeQuery(query);
		while(s.next()) {
			Book b=new Book();
			b.setSerialNumber(s.getLong(1));
			b.setBookName(s.getString(2));
			b.setBookAuthor(s.getString(3));
			b.setBookCost(s.getDouble(4));
			a.add(b);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public boolean deleteBook(long SerialNumber) {
		// TODO Auto-generated method stub
		boolean res=false;
		String query="delete from Book where SerialNumber=?";
		try(Connection con=getConnection()){
		PreparedStatement ps=con.prepareStatement(query);
		ps.setLong(1, SerialNumber);
		int i=ps.executeUpdate();
		if(i>0)
		{
			res=true;
		}
		else {
			res=false;
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public boolean updateBook(String name) {
		// TODO Auto-generated method stub
		boolean res=false;
		try(Connection con=getConnection()){
		String query="update Book set SerialNumber=90807 where BookName like ?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, name);
		int i=ps.executeUpdate();
		if(i>0)
		{
			res=true;
		}
		else {
			res=false;
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
