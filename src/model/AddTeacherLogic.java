package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import dbConnection.Teacher;

public class AddTeacherLogic {
	
	public static String[] addTeacher(String first_name, String last_name, String phone, String alt_phone, String address, String email, String user_id) throws FileNotFoundException, IOException, SQLException{
		String id = Teacher.addTeacher(first_name, last_name, phone, alt_phone, address, email, user_id);
		return new String[] {id, "Sucessful!"};
	}	

//	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
//	}

}
