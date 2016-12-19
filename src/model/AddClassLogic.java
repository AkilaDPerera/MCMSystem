package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import dbConnection.ClassEntity;
import dbConnection.Takes;
import dbConnection.Teaches;

public class AddClassLogic {
	
	public static String [] initializeGroupClass(String teacher_id, String hourly_pay, String subject, String monthly_fee, String commence_date, String start_time, String end_time, String max_student, String location) throws FileNotFoundException, IOException, SQLException{
		String class_type = "group";
		
		//Create entry for class
		String class_id = ClassEntity.createClass(subject, class_type, monthly_fee, commence_date, start_time, end_time, max_student, location);
		
		//Create entry for teaches
		Teaches.addTeachesEntry(class_id, teacher_id, hourly_pay);
		return new String [] {"Group class initialization successful!\n Class Id: "+class_id};
		
	}
	
	public static String [] initializeInduvidualClass(String teacher_id, String std_id, String hourly_pay, String subject, String monthly_fee, String commence_date, String start_time, String end_time, String location) throws FileNotFoundException, IOException, SQLException{
		String class_type = "individual";
		String max_student = "1";
		
		//Create entry for class
		String class_id = ClassEntity.createClass(subject, class_type, monthly_fee, commence_date, start_time, end_time, max_student, location);
		
		//Create entry for teaches
		Teaches.addTeachesEntry(class_id, teacher_id, hourly_pay);
		
		//Create a entry in takes
		Takes.addEnrolment(class_id, std_id);
		
		return new String [] {"Individual class initialization successful!\n Class Id: "+class_id};
		
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
