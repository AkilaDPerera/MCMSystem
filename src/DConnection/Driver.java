package DConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//I have already put the mysql-connector to the project. so no need to worry about it.

		//Below is a standard way of getting Database url, user and password... Actually the place where store the info is in the root folder in the file called demo.properties
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		//Loading the user, password and url is done now.
		
		try{
			//Get a connection to database
			Connection myConn = DriverManager.getConnection(dburl, user, password);
			
			//Create a statement
			Statement myStmt = myConn.createStatement();
			
			//Insert record
			String sqlCommand = "INSERT INTO demotable (id, name) VALUES ('15', 'Suram')";
			myStmt.executeUpdate(sqlCommand);
			
			//Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demotable");
			
			//Proccess the result set
			while(myRs.next()){
				System.out.println(myRs.getString("name") + " | " + myRs.getString("id"));
			}
			
			
			/*Below is working code snippet... U may use it if you need
			 
			 
			//--------------------------------------------------
			//Get a connection to database
			Connection myConn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mcms", "root", "");
			
			//Start transaction
			myConn2.setAutoCommit(false);
			
			//perform multiple sql statements
			 * like,
				Statement myStmt = myConn.createStatement();
				String sqlCommand = "INSERT INTO demotable (id, name) VALUES ('15', 'Suram')";
				myStmt.executeUpdate(sqlCommand);
			//...
			
			boolean ok; //= askingUseristhatoktosave();
			
			if (ok){
				//store in database
				myConn2.commit();
			}else{
				//discard
				myConn2.rollback();
			}
			
			//----------------------------------------------
			*/
			
			
			
		}catch(Exception exc){
			System.out.println("Database Error");
		}

	}

}
