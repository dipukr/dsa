import java.io.*;
import java.nio.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import java.util.stream.*;

public class JDBC {

	private static void dumpUser(ResultSet rs) throws Exception {
		System.out.printf("%-10s%-10s%-10s%-20s%-16s\n",
			rs.getString(1),
			rs.getString(2),
			rs.getString(3),
			rs.getString(4),
			rs.getString(5));
	}

	private static void dumpStudent(ResultSet rs) throws Exception {
		System.out.printf("%-5d%-10s%-10s%-20s%-20s%-20s\n",
			Integer.parseInt(rs.getString(1)),
			rs.getString(2),
			rs.getString(3),
			rs.getString(4),
			rs.getString(5),
			rs.getString(6));
	}

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/studentdb";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "root", "root");
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from student");
		while (rs.next()) dumpStudent(rs);
	}
}
