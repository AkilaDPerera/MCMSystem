package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dbConnection.Family;
import dbConnection.Student;

public class AddStudentLogic {
	
	public static String [] addStudentNewFam(String first_name, String last_name, String phone, String alt_phone, String address, String email, String dob, String gender, String momName, String momContact, String dadName, String dadContact, String guardianName, String guardianContact) throws FileNotFoundException, SQLException, IOException{
		//Add new family entry
		String fam_id = Family.createNewFamily(momName, momContact, dadName, dadContact, guardianName, guardianContact);

		//Add student
		String std_id = Student.addStudent(first_name, last_name, phone, alt_phone, address, email, dob, gender, fam_id);
		
		return new String[]{std_id, fam_id, "Successful!"};
	}
	
	public static String [] addStudentExistingFam1(String family_id) throws FileNotFoundException, IOException, SQLException{
		String [] temp = Family.getFamilyDetails(family_id);
		if (temp==null){
			return new String[] {"-1", "No such family id found."};
		}else{
			return temp;
		}
	}
	
	public static String [] addStudentExistingFam2(String first_name, String last_name, String phone, String alt_phone, String address, String email, String dob, String gender, String family_id) throws FileNotFoundException, IOException, SQLException{
		String std_id = Student.addStudent(first_name, last_name, phone, alt_phone, address, email, dob, gender, family_id);
		return new String[] {std_id, family_id, "Successful!"};
	}
	

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		//addStudentNewFam("akila", "perera", "0716360198", "", "Drashana, Ekneligoda, Kuruwita", "akila@gmail.com", "1994-12-5", "male", "swaran", "0713338232", "padma", "0718688549", "suram", "0716363198");
	}

}
