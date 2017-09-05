package Main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.SwingUtilities;

import Controller.Control;

public class main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {		
		// setup
		Class.forName("org.sqlite.JDBC");
		String dbURL = "jdbc:sqlite:bookstore.db";
		Connection conn = DriverManager.getConnection(dbURL);
		if (conn != null) {
			System.out.println("Connected to the database....");
			// display database information
			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			// execute SQL statements
			System.out.println("----- Data in Book table -----");
			String query = "Select * from book";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String day = resultSet.getString(1);
				String month = resultSet.getString(2);
				String year = resultSet.getString(3);
				Control.day1.add(resultSet.getString(1));
				Control.month1.add(resultSet.getString(2));
				Control.year1.add(resultSet.getString(3));
				System.out.println("D/M/Y:"+day+" TIME:"+month+" DETAIL: "+year);
			}
		// close connection
		conn.close();
		Control c1 = new Control();
		c1.link();
		}
	}

}
