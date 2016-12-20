package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Attendance {
	
	public static void setAttendence(String session_id, String student_id, String present) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`attendance` (session_id, student_id, present) VALUES (?, ?, ?);");
		addEntry.setString(1, session_id);
		addEntry.setString(2, student_id);
		addEntry.setString(3, present);
		addEntry.executeUpdate();
	}
	
	public static void editAttendence(String session_id, String student_id, String present) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("UPDATE `mcms`.`attendance` SET present=? WHERE session_id=? AND student_id=?;");
		addEntry.setString(1, present);
		addEntry.setString(2, session_id);
		addEntry.setString(3, student_id);
		addEntry.executeUpdate();
	}
	
	public static String getAttendence(String session_id, String studentId) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement getEntry = (PreparedStatement) conn.prepareStatement("SELECT present FROM `mcms`.`attendance` WHERE session_id=? AND student_id=?;");
		getEntry.setString(1, session_id);
		getEntry.setString(2, studentId);
		ResultSet rs = getEntry.executeQuery();
		
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
