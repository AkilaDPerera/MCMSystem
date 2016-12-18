package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Student {
	
	public static String addStudent(String first_name, String last_name, String phone, String alt_phone, String address, String email, String dob, String gender, String family_id) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add student
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`student`(`first_name`, `last_name`, `phone`, `alt_phone`, `address`, `email`, `dob`, `gender`, `family_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
		addEntry.setString(1, first_name);
		addEntry.setString(2, last_name);
		addEntry.setString(3, phone);
		addEntry.setString(4, alt_phone);
		addEntry.setString(5, address);
		addEntry.setString(6, email);
		addEntry.setString(7, dob);
		addEntry.setString(8, gender);
		addEntry.setString(9, family_id);
		addEntry.executeUpdate();
		
		//Return the id
		PreparedStatement getID = (PreparedStatement) conn.prepareStatement("SELECT id FROM `mcms`.`student` WHERE `first_name`=? AND `last_name`=? AND `phone`=? AND `alt_phone`=? AND `address`=? AND `email`=? AND `dob`=? AND `gender`=? AND `family_id`=?;");
		getID.setString(1, first_name);
		getID.setString(2, last_name);
		getID.setString(3, phone);
		getID.setString(4, alt_phone);
		getID.setString(5, address);
		getID.setString(6, email);
		getID.setString(7, dob);
		getID.setString(8, gender);
		getID.setString(9, family_id);
		ResultSet rs = getID.executeQuery();
		
		if (rs.next()){
			return rs.getString(1);
		}else{
			return null;
		}
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
