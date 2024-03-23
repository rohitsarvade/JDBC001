package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement p=null;
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DataBaseName","root","Rohit@0889");
		System.out.println("connection created");
		
//		p=con.prepareStatement("create table books(book_id int,book_name varchar(20),book_rate int)");
//		int i=p.executeUpdate();
//		System.out.println("Table created.. success="+i);
		
//		System.out.println("enter book code");
//		int bc=sc.nextInt();
//		System.out.println("enter book Name");
//		String bn=sc.next();
//		System.out.println("enter book Rate");
//		int br=sc.nextInt();
//		p=con.prepareStatement("insert into books values(?,?,?)");
//		p.setInt(1, bc);
//		p.setString(2, bn);
//		p.setInt(3, br);
//		int i=p.executeUpdate();
//		System.out.println("Data inserted.. success="+i);
		
		System.out.println("enter book code to be updated");
		int bc=sc.nextInt();
		System.out.println("enter new book Name");
		String bn=sc.next();
		System.out.println("enter new book Rate");
		int br=sc.nextInt();
		p=con.prepareStatement("update books set book_name =?, book_rate=? where book_id=?");
		p.setString(1, bn);
		p.setInt(2, br);
		p.setInt(3, bc);
		int i=p.executeUpdate();
		System.out.println("Data updated.. success="+i);
		
//		System.out.println("enter book code to be deleted");
//		int bc=sc.nextInt();
//		p=con.prepareStatement("delete from books where book_id=?");
//		p.setInt(1, bc);
//		int i=p.executeUpdate();
//		System.out.println("Data deleted.. success="+i);
		
//		System.out.println("enter book code to print");
//		int bc=sc.nextInt();
//		p=con.prepareStatement("select * from books where book_id=?");
//		p.setInt(1, bc);
//		ResultSet r=p.executeQuery();
//		String id=null;
//		String name=null;
//	    String rate=null;
//		while(r.next())
//		{
//			id=r.getString("book_id");
//			name=r.getString("book_name");
//			rate=r.getString("book_rate");
//		}
//		System.out.println("Book ID is: "+id);
//		System.out.println("Book name is: "+name);
//		System.out.println("Book rate is: "+rate);

	}

}
