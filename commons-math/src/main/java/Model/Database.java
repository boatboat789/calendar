package Model;
//thiti
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	public Database(){
		
	}
	public void delete(String Day) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		String sql = "DELETE  FROM book WHERE Day=?";
		String dbURL = "jdbc:sqlite:bookstore.db";
		Connection conn = DriverManager.getConnection(dbURL);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// set the corresponding param
		pstmt.setString(1,Day);
		// update 
		pstmt.executeUpdate();
		conn.close();
	}
	public void insert(String Day, String TIME , String DETAIL) throws ClassNotFoundException, SQLException {
        
        Class.forName("org.sqlite.JDBC");
        String sql = "INSERT INTO book(Day,TIME,DETAIL) VALUES(?,?,?)";
		String dbURL = "jdbc:sqlite:bookstore.db";
		Connection conn = DriverManager.getConnection(dbURL);
		PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,Day);
        pstmt.setString(2,TIME);
        pstmt.setString(3,DETAIL);
        pstmt.executeUpdate();
        conn.close();
       
    }
}
