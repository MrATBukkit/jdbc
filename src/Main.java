
import java.sql.*;

public class Main {

	static Connection conn = null;
	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		Statement stmt = null; 
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/referat?serverTimezone=Europe/Vienna&" +
		                                   "user=referat&password=!Hallo123");

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		printData();
		System.out.println("Insert Into");
		stmt = conn.createStatement();
		String sql = "INSERT INTO customer (name, surname, address) VALUES ('Max', 'Müller', 'Grazerstraße 47')";
	    stmt.executeUpdate(sql);
	    printData();
	    
	    System.out.println("Update Data");
	    sql = "UPDATE customer set name='Mueller' where name='Müller'";
	    stmt = conn.createStatement();
	    stmt.executeUpdate(sql);
	    printData();
	    conn.close();
	}
	
	public static void printData() {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM customer";
		    ResultSet rs = stmt.executeQuery(sql);
		      
		    while(rs.next()){
		    	System.out.println(rs.getInt("id") + "\t" + rs.getString("surname")+ 
		    			"\t" + rs.getString("name") + "\t" + rs.getString("address"));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
