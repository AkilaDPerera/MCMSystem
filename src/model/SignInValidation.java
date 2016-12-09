package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import dbConnection.User;

public class SignInValidation {
	
	public static String [] getValidatedSignIn(String username, String password) throws FileNotFoundException, IOException, SQLException{
		String [] data = User.getPsswrdRole(username);
		
		if (data==null){
			return new String [] {"-1", "Wrong username"}; 
		}else if(data[0].equals(password)){
			return new String [] {data[1], data[2]};//role, iduser
		}else{
			return new String [] {"-1", "Wrong password"};
		}
	}
}
