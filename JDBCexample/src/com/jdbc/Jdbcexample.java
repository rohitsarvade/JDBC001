package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcexample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement prep=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DataBaseName","root","Rohit@0889");
		System.out.println("connection created");
		
		Statement stmt=con.createStatement();
//		stmt.execute("create table emp2(emp_id varchar(50),emp_name varchar(50),emp_city varchar(20))");
//		System.out.println("Table Created");
//		stmt.execute("insert into emp2 values('013','Ajay','Baner')");
//		System.out.println("Data Inserted");
		
//		PreparedStatement prep=con.prepareStatement("insert into emp2 values(?,?,?)");
//		prep.setString(1, "014");
//		prep.setString(2, "Vijay");
//		prep.setString(3, "Mumbai");
//		prep.executeUpdate();
//		System.out.println("Data inserted Successfully");
		
//		stmt.execute("update emp2 set emp_name='amol' where emp_id=010");
//		System.out.println("Data Inserted");
		
//		PreparedStatement prep=con.prepareStatement("update emp2 set emp_name=?,emp_city=? where emp_id=?");
//		prep.setString(1, "amol");
//		prep.setString(2, "talegaon");
//		prep.setString(3, "011");
//		prep.executeUpdate();
//		System.out.println("Data updated Successfully");
		
//		PreparedStatement prep=con.prepareStatement("delete from emp2 where emp_id=?");
//		prep.setString(1, "014");
//		prep.executeUpdate();
//		System.out.println("Data deleted Successfully");
		
		prep=con.prepareStatement("select * from emp2 where emp_id=?");
		prep.setString(1, "012");
		ResultSet result=prep.executeQuery();
		String id=null;
		String name=null;
		String city=null;
		while(result.next())
		{
			id=result.getString("emp_id");
			name=result.getString("emp_name");
			city=result.getString("emp_city");
		}
		System.out.println(id);
		System.out.println(name);
		System.out.println(city);

	}

}
