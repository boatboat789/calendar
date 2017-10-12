//thiti
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcSQLiteConnection {
public static void main(String[] args) {
try {
// setup
Class.forName("org.sqlite.JDBC");
String dbURL = "jdbc:sqlite:DeserveSeat.db";
Connection conn = DriverManager.getConnection(dbURL);
if (conn != null) {
System.out.println("Connected to the database....");
// display database information
DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
System.out.println("Driver name: " + dm.getDriverName());
System.out.println("Product name: " + dm.getDatabaseProductName());
// execute SQL statements
System.out.println("----- Data in Book table -----");
String query = "Select * from DeserveSeat";
Statement statement = conn.createStatement();
ResultSet resultSet = statement.executeQuery(query);
while (resultSet.next()) {
String Table = resultSet.getString(1);
String Id = resultSet.getString(2);
String TimeIn = resultSet.getString(3);
String TimeOut = resultSet.getString(4);

System.out.println("id:"+Table+" name:"+Id+" price: "+TimeIn+ TimeOut);
}
// close connection
conn.close();
}
} catch (ClassNotFoundException ex) {
ex.printStackTrace();
} catch (SQLException ex) {
ex.printStackTrace();
}
}
}