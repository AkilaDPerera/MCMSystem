package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Takes {
	
	public static void addEnrolment(String class_id, String std_id) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add Teaches entry
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`takes` (`class_id`, `student_id`, `enabled`) VALUES (?, ?, 1);");
		addEntry.setString(1, class_id);
		addEntry.setString(2, std_id);
		LogWriter.writeQueryToLog(addEntry);
		addEntry.executeUpdate();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
