package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Teaches {
	
	public static void addTeachesEntry(String class_id, String teacher_id, String hourly_salary) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add Teaches entry
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`teaches` (`class_id`, `teacher_id`, `hourly_salary`) VALUES (?, ?, ?);");
		addEntry.setString(1, class_id);
		addEntry.setString(2, teacher_id);
		addEntry.setString(3, hourly_salary);
		addEntry.executeUpdate();
	}
//	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
//		// TODO Auto-generated method stub
//		Teaches.addTeachesEntry("1", "1","56");
//
//	}

}
