package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Teacher {
	
	public static String addTeacher(String first_name, String last_name, String phone, String alt_phone, String address, String email, String user_id) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add teacher
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`teacher`(`first_name`, `last_name`, `phone`, `alt_phone`, `address`, `email`, `user_id`) VALUES (?, ?, ?, ?, ?, ?, ?);");
		addEntry.setString(1, first_name);
		addEntry.setString(2, last_name);
		addEntry.setString(3, phone);
		addEntry.setString(4, alt_phone);
		addEntry.setString(5, address);
		addEntry.setString(6, email);
		addEntry.setString(7, user_id);
		addEntry.executeUpdate();
		
		//Get user id
		PreparedStatement getID = (PreparedStatement) conn.prepareStatement("SELECT id FROM `mcms`.`teacher` WHERE `first_name`=? AND `last_name`=? AND `phone`=? AND `alt_phone`=? AND `address`=? AND `email`=? AND `user_id`=?;");
		getID.setString(1, first_name);
		getID.setString(2, last_name);
		getID.setString(3, phone);
		getID.setString(4, alt_phone);
		getID.setString(5, address);
		getID.setString(6, email);
		getID.setString(7, user_id);
		ResultSet rs = getID.executeQuery();
		
		if (rs.next()){
			return rs.getString(1);
		}else{
			return null;
		}
		
	}
	
	
	
	
//	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
//		// TODO Auto-generated method stub
//		System.out.println(addTeacher("Suram", "appo", "0716360198", "", "dsgds", "adfg@dfj.com", "2"));
//
//	}

}
