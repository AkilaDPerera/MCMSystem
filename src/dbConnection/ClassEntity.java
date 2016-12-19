package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ClassEntity {
	
	public static String createClass(String subject, String class_type, String monthly_fee, String commence_date, String start_time, String end_time, String max_students, String location, String day) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add class
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`class` (`subject`, `class_type`, `monthly_fee`, `commence_date`, `start_time`, `end_time`, `max_students`, `location`, `day`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
		addEntry.setString(1, subject);
		addEntry.setString(2, class_type);
		addEntry.setString(3, monthly_fee);
		addEntry.setString(4, commence_date);
		addEntry.setString(5, start_time);
		addEntry.setString(6, end_time);
		addEntry.setString(7, max_students);
		addEntry.setString(8, location);
		addEntry.setString(9, day);
		addEntry.executeUpdate();
		
		//Return the id
		PreparedStatement getID = (PreparedStatement) conn.prepareStatement("SELECT id FROM `mcms`.`class` WHERE `subject`=? AND `class_type`=? AND `monthly_fee`=? AND `commence_date`=? AND `start_time`=? AND `end_time`=? AND `max_students`=? AND `location`=? AND `day`=?;");
		getID.setString(1, subject);
		getID.setString(2, class_type);
		getID.setString(3, monthly_fee);
		getID.setString(4, commence_date);
		getID.setString(5, start_time);
		getID.setString(6, end_time);
		getID.setString(7, max_students);
		getID.setString(8, location);
		getID.setString(9, day);
		ResultSet rs = getID.executeQuery();
		
		if (rs.next()){
			return rs.getString(1);
		}else{
			return null;
		}
	}
	
	public static ResultSet searchById(String id) throws FileNotFoundException, IOException, SQLException{
		String temp = ""+id+"%";
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT id AS ID, subject AS 'Subject', class_type AS 'Class Type', monthly_fee AS 'Monthly Fee', day AS 'Day', location AS 'Location', max_students AS 'MAX', commence_date AS 'Starting Date', start_time AS 'Start'  FROM `mcms`.`class` WHERE id LIKE ?;");
		getList.setString(1, temp);
		return getList.executeQuery();
	}
	
	public static ResultSet searchBySubject(String subject) throws FileNotFoundException, IOException, SQLException{
		String temp = ""+subject+"%";
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT id AS ID, subject AS 'Subject', class_type AS 'Class Type', monthly_fee AS 'Monthly Fee', day AS 'Day', location AS 'Location', max_students AS 'MAX', commence_date AS 'Starting Date', start_time AS 'Start'  FROM `mcms`.`class` WHERE subject LIKE ?;");
		getList.setString(1, temp);
		return getList.executeQuery();
	}
	
	public static ResultSet searchByLocation(String location) throws FileNotFoundException, IOException, SQLException{
		String temp = ""+location+"%";
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT id AS ID, subject AS 'Subject', class_type AS 'Class Type', monthly_fee AS 'Monthly Fee', day AS 'Day', location AS 'Location', max_students AS 'MAX', commence_date AS 'Starting Date', start_time AS 'Start'  FROM `mcms`.`class` WHERE location LIKE ?;");
		getList.setString(1, temp);
		return getList.executeQuery();
	}
	
	public static ResultSet searchByDay(String day) throws FileNotFoundException, IOException, SQLException{
		String temp = ""+day+"%";
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT id AS ID, subject AS 'Subject', class_type AS 'Class Type', monthly_fee AS 'Monthly Fee', day AS 'Day', location AS 'Location', max_students AS 'MAX', commence_date AS 'Starting Date', start_time AS 'Start'  FROM `mcms`.`class` WHERE day LIKE ?;");
		getList.setString(1, temp);
		return getList.executeQuery();
	}
	
	public static ResultSet getAll() throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT id AS ID, subject AS 'Subject', class_type AS 'Class Type', monthly_fee AS 'Monthly Fee', day AS 'Day', location AS 'Location', max_students AS 'MAX', commence_date AS 'Starting Date', start_time AS 'Start'  FROM `mcms`.`class`");
		return getList.executeQuery();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
