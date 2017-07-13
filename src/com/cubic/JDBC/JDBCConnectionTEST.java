package com.cubic.JDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionTEST {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JDBCConnection jc = new JDBCConnection();
		Connection con = jc.getConnection();
		if (con != null)
			System.out.println("Connection Successful");
	
		else {
			System.out.println("Not Connected");
		}
		
		Statement st = con.createStatement();
		int  updateDelete=st.executeUpdate("delete students where id IN(5,9,10)");
		System.out.println(updateDelete+ " rows affected");
		System.out.println("-----Displaying the Table-----");
		ResultSet rs=st.executeQuery("Select* from students");
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6));
		}
		con.close();
	}
}
