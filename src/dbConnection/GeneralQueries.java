package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GeneralQueries {
	
	public static ResultSet getMainList() throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
<<<<<<< HEAD
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT class.id AS 'Class-ID', subject AS 'Subject', first_name AS 'Teacher Name', day AS 'Day', start_time AS 'On' FROM class, teaches, teacher WHERE class.id=teaches.class_id AND teacher.id=teaches.teacher_id;");
		LogWriter.writeQueryToLog(getList);
=======
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT class.id AS 'Class-ID', subject AS 'Subject', first_name AS 'Teacher Name', class_type AS 'Class Type', day AS 'Day', start_time AS 'At' FROM class, teaches, teacher WHERE class.id=teaches.class_id AND teacher.id=teaches.teacher_id;");
>>>>>>> master
		return getList.executeQuery();
	}
	
	public static String[] getTeacherByClassId(String id) throws FileNotFoundException, IOException, SQLException{
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT first_name, last_name, phone, teacher.id  FROM teacher JOIN teaches WHERE teacher.id=teaches.teacher_id AND class_id=?;");
		getList.setString(1, id);
		ResultSet rs = getList.executeQuery();
		
		if (rs.next()){
			return new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
		}else{
			return null;
		}
	}
	public static ResultSet getStudentsByClassId(String class_id) throws FileNotFoundException, IOException, SQLException {
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement getList = (PreparedStatement) conn.prepareStatement("SELECT student_id, first_name, last_name FROM takes, student WHERE takes.student_id=student.id AND takes.class_id=?;");
		getList.setString(1, class_id);
		return getList.executeQuery();
	}
	
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
