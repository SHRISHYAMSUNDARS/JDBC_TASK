package com.next;

import java.sql.Connection;
import java.util.List;

public interface BookDAOImp1 {
	public static final String jdbcurl="jdbc:mysql://localhost:3306/New";
	public static final String driverclass="com.mysql.cj.jdbc.Driver";
	public static final String username="SHRI";
	public static final String password="Shri@123";
	Connection getConnection();
	void insertBook(Book b);
	Book selectBook(long SerialNumber);
	List<Book> selectAllBook();
	boolean deleteBook(long SerialNumber);
	boolean updateBook(String name);

}
