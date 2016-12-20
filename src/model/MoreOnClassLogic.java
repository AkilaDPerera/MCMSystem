package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import dbConnection.ClassEntity;
import dbConnection.GeneralQueries;
import dbConnection.Takes;

public class MoreOnClassLogic {
	
	public static String[] getInitialData(String class_id) throws FileNotFoundException, IOException, SQLException{
		String[] class_details = ClassEntity.getClassById(class_id); // subject, max_students, start_time, end_time, day
		String[] teacher_details = GeneralQueries.getTeacherByClassId(class_id); // first_name, last_name, phone
		String count = Takes.getStdCountByclassId(class_id);
		return new String [] {class_details[0], teacher_details[0]+" "+teacher_details[1], count, class_details[4], class_details[2], class_details[3]};
		
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
