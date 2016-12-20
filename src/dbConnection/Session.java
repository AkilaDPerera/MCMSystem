package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Session {
	
	public static String CreateSession(String class_id, String date) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add entry
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`session` (class_id, teacher_id, substitute_teacher, date) VALUES (?, NULL, NULL, ?);");
		addEntry.setString(1, class_id);
		addEntry.setString(2, date);
		addEntry.executeUpdate();
		
		//Return the id
		PreparedStatement getID = (PreparedStatement) conn.prepareStatement("SELECT id FROM `mcms`.`session` WHERE `class_id`=? AND `date`=?;");
		getID.setString(1, class_id);
		getID.setString(2, date);
		ResultSet rs = getID.executeQuery();
		
		if (rs.next()){
			return rs.getString(1);
		}else{
			return null;
		}
	}
	
	public static void editSession(String session_id, String teacher_id, String substitute_teacher) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add entry
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("UPDATE `mcms`.`session` SET `teacher_id`=?, `substitute_teacher`=? WHERE `id`=?;");
		addEntry.setString(1, teacher_id);
		addEntry.setString(2, substitute_teacher);
		addEntry.setString(3, session_id);
		
		addEntry.executeUpdate();
	}
	
	public static String[] getSession(String class_id, String date) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add entry
		PreparedStatement getEntry = (PreparedStatement) conn.prepareStatement("SELECT id, teacher_id, substitute_teacher FROM `mcms`.`session` WHERE class_id=? AND date=?;");
		getEntry.setString(1, class_id);
		getEntry.setString(2, date);
		ResultSet rs = getEntry.executeQuery();
		
		if (rs.next()){
			return new String[] {rs.getString(1), rs.getString(2), rs.getString(3)};
		}else{
			return null;
		}
	}
	
	


//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
