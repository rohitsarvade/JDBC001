package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbsWithExecption {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		PreparedStatement prep=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DataBaseName","root","Rohit@0889");
		System.out.println("connection created");
		
		String id1;
		String name1;
		String city1;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id of emp");
		id1=sc.next();
		System.out.println("enter name of emp");
		name1=sc.next();
		System.out.println("enter city of emp");
		city1=sc.next();
		prep=con.prepareStatement("insert into emp2 values(?,?,?)");
		try {
		prep.setString(1, id1);
		prep.setString(2, name1);
		prep.setString(3, city1);
//		}
		
//		catch(Exception e) {
//			throw new Exception("Cannot inserted data");
//		}
		
		int a=prep.executeUpdate();
		if(a>0)
		{
			System.out.println("Data inserted Successfully");
		}
		else
		{
			throw new Exception("data not inserted");
		}
		}
		catch(Exception e) {
			throw new Exception("data not inserted");
		}
		
//		System.out.println("Data inserted Successfully");
		prep=con.prepareStatement("select * from emp2 where emp_id=?");
		prep.setString(1, id1);
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
		System.out.println("Record of recently added emp is :-");
		System.out.println("Employee id= "+id);
		System.out.println("Employee name= "+name);
		System.out.println("Employee city= "+city);

	}

}
