package newLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class userInfo {
	/*Connection code*/
	Connection connection = null;
	Connection conn = null;
	
	//Establish connection with the database
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			//Set this path to where  you put your database file in your computer
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/DatabaseFiles/user.db");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	
	
	//For login page
	public String[] validateInfo(String username, char[] password) {
		String loginResult[] = new String[3];
	try {

		connection = dbConnector();
		//Convert hidden char to string
		String pass = String.valueOf(password);
		
		//user is the name of the SQLite database, username and password are the fields
		String query = "SELECT username, role, name FROM user where username=? and password=?";
		PreparedStatement pst = connection.prepareStatement(query);
		pst.setString(1, username);
		pst.setString(2, pass);
		//This gets the values back one by one from the database
		ResultSet rs = pst.executeQuery();
		//Set strings 
		while(rs.next()) {
			loginResult[0] = rs.getString("role");
			loginResult[1] = rs.getString("name");
		}
	}
	catch(Exception f) {
		JOptionPane.showMessageDialog(null, f);
	}
	return loginResult;
	}
	
}
