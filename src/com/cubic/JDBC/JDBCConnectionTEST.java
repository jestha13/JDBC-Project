package com.cubic.JDBC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCConnectionTEST {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		JDBCConnection jc = new JDBCConnection();
		Connection con = jc.getConnection();
		if (con != null)
			System.out.println("Connection Successful");
	
		else {
			System.out.println("Not Connected");
		}
		
		Statement st = con.createStatement();
		PreparedStatement pst =con.prepareStatement("INSERT INTO students values(?,?,?,?,?,?)");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter id");
		//int id=Integer.parseInt(br.readLine());//buffer to make it faster compared to scanner
		int id=sc.nextInt();
		System.out.println("Enter name");
		String name=br.readLine();
		System.out.println("Enter subject");
		String subject=br.readLine();
		System.out.println("Enter score");
		int score=Integer.parseInt(br.readLine());
		System.out.println("Enter Grade");
		String grade=br.readLine();
		System.out.println("Enter Subject id");
		int subjectid=Integer.parseInt(br.readLine());
		
		pst.setInt(1, id);//1, means 1st parameter
		pst.setString(2, name);
		pst.setString(3, subject);
		pst.setInt(4,score);
		pst.setString(5, grade);
		pst.setInt(6, subjectid);
		int n=pst.executeUpdate();
		//int  updateDelete=st.executeUpdate("delete students where id IN(5,9,10)");
		System.out.println(n+ " row/ss affected");
		System.out.println("-----Displaying the Table-----");
		ResultSet rs=st.executeQuery("Select* from students");
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6));
		}
		con.close();
	}
}
