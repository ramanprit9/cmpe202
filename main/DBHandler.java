package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
	
	static Connection conn = null;

	/* Connect to DB connection at the beginning of main function of MainApplication */
	public static void connectDB() {
		
		try {
//			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/cmpe202";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/* Close DB connection at the end of main function of MainApplication */
	public static void closeDBConnection() {
		try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	}

	/* Use this function to Insert, Update, and Delete */
	public static void updateDB(String str) {
		connectDB();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	/* Use this function for querying (Select operations) */
	public static ResultSet queryDB(String str) {
		connectDB();
		ResultSet rs = null;
		Statement stmt = null;
		try {
			System.out.println("Query DB: " + str);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(str);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}
	
	//Just for testing purposes
	public static void testing() {
		connectDB();
		/* Example on how to iterate rs results */
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from user_request");
			while (rs.next()) {
				String id = rs.getString("request_id");
				String pickup = rs.getString("request_pickup_loc");
				System.out.println("ID: " + id + ", MIPS: " + pickup);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}

	}
		
}
