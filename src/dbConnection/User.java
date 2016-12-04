package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class User {
	public static String [] getPsswrdRole(String username) throws FileNotFoundException, IOException, SQLException{
		
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement passwordFromUsername = (PreparedStatement) conn.prepareStatement("SELECT password, role, iduser FROM user WHERE username=?");
		passwordFromUsername.setString(1, username);
		ResultSet rs = passwordFromUsername.executeQuery();
		
		if (rs.next()){
			return new String [] {rs.getString(1), rs.getString(2), rs.getString(3)};
		}else{
			return null;
		}
	}
}
