
import java.sql.*;

public class Main {

	static Connection conn = null;
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
		try {
			
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/referat?useLegacyDatetimeCode=false&serverTimezone=America/New_York&" +
		                                   "user=referat&password=!Hallo123");

		    // Do something with the Connection

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		printData();
	}
	
	public static void printData() throws SQLException {
		Statement stmt;
		stmt = conn.createStatement();
	

	    String sql = "SELECT * FROM offices";
	    ResultSet rs = stmt.executeQuery(sql);
	      
	    while(rs.next()){
	    	System.out.println(rs.getInt("officeCode") + "\t" + rs.getString("city") + "\t" + rs.getString("phone"));
	    }
	}

}
