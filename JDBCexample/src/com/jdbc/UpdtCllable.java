package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class UpdtCllable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DataBaseName","root","Rohit@0889");
		System.out.println("connection created");
		
		System.out.println("enter roll no to be updated");
		int rn=sc.nextInt();
		System.out.println("enter new student name");
		String sn=sc.next();
		System.out.println("enter new city");
		String ct=sc.next();
		
		CallableStatement cst=con.prepareCall("{call proc_updt(?,?,?)}");
		
		cst.setString(1, sn);
		cst.setString(2, ct);
		cst.setInt(3, rn);
		
		cst.execute();
		
		System.out.println("Done...");

	}

}
