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
		PreparedStatement passwordFromUsername = (PreparedStatement) conn.prepareStatement("SELECT password, privileges, id FROM user WHERE username=?");
		passwordFromUsername.setString(1, username);
		LogWriter.writeQueryToLog(passwordFromUsername);
		ResultSet rs = passwordFromUsername.executeQuery();
		
		if (rs.next()){
			return new String [] {rs.getString(1), rs.getString(2), rs.getString(3)};
		}else{
			return null;
		}
	}
	
	public static Boolean isUserThere(String username) throws SQLException, FileNotFoundException, IOException{

		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement passwordFromUsername = (PreparedStatement) conn.prepareStatement("SELECT * FROM user WHERE username=?");
		passwordFromUsername.setString(1, username);
		ResultSet rs = passwordFromUsername.executeQuery();
		
		if (rs.next()){
			return true;
		}else{
			return false;
		}
	}
	
	public static Boolean isTeacherThere(String teacher_id) throws SQLException, FileNotFoundException, IOException{

		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement passwordFromUsername = (PreparedStatement) conn.prepareStatement("SELECT * FROM user WHERE teacher_id=?");
		passwordFromUsername.setString(1, teacher_id);
		ResultSet rs = passwordFromUsername.executeQuery();
		
		if (rs.next()){
			return true;
		}else{
			return false;
		}
	}
	
	public static void setUser(String privileges, String username, String password, String email, String teacher_id) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`user`(`privileges`, `username`, `password`, `email`, `teacher_id`) VALUES (?, ?, ?, ?, ?);");
		addEntry.setString(1, privileges);
		addEntry.setString(2, username);
		addEntry.setString(3, password);
		addEntry.setString(4, email);
		addEntry.setString(5, teacher_id);
		addEntry.executeUpdate();
	}
	
	public static void updateUser(String privileges, String username, String password, String email, String teacher_id) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("UPDATE `mcms`.`user` SET `privileges`=?, `username`=?, `password`=?, `email`=? WHERE `teacher_id`=?;");
		addEntry.setString(1, privileges);
		addEntry.setString(2, username);
		addEntry.setString(3, password);
		addEntry.setString(4, email);
		addEntry.setString(5, teacher_id);
		addEntry.executeUpdate();
	}
}
