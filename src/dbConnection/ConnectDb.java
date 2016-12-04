package dbConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectDb {
	
	public static void initializeDB() throws FileNotFoundException, IOException{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		try{
			//Create a DB called mcms
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", user, password);
			Statement statement = conn.createStatement();
			String create_db = "CREATE DATABASE IF NOT EXISTS MCMS";
			statement.executeUpdate(create_db);
			statement.close();
			conn.close();
			
			//Table creations
			Connection conn1 = DriverManager.getConnection(dburl, user, password);
			Statement statement1 = conn1.createStatement();

			String table_creation = "CREATE TABLE IF NOT EXISTS `mcms`.`user` (`iduser` INT NOT NULL,`role` ENUM('teacher', 'staff', 'admin') NOT NULL,`username` CHAR(50) NOT NULL,`password` CHAR(50) NOT NULL,PRIMARY KEY (`iduser`),UNIQUE INDEX `username_UNIQUE` (`username` ASC));" + 
			"";
			
			statement1.executeUpdate(table_creation);
			statement1.close();
			conn1.close();
			
		}catch(Exception e){
			
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		ConnectDb.initializeDB();
	}

//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		//I have already put the mysql-connector to the project. so no need to worry about it.
//
//		//Below is a standard way of getting Database url, user and password... Actually the place where store the info is in the root folder in the file called demo.properties
//		Properties props = new Properties();
//		props.load(new FileInputStream("demo.properties"));
//		
//		String user = props.getProperty("user");
//		String password = props.getProperty("password");
//		String dburl = props.getProperty("dburl");
//		//Loading the user, password and url is done now.
//		
//		try{
//			//Get a connection to database
//			Connection myConn = DriverManager.getConnection(dburl, user, password);
//			
//			//Create a statement
//			Statement myStmt = myConn.createStatement();
//			
//			//Insert record
//			String sqlCommand = "INSERT INTO demotable (id, name) VALUES ('15', 'Suram')";
//			myStmt.executeUpdate(sqlCommand);
//			
//			//Execute SQL query
//			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demotable");
//			
//			//Proccess the result set
//			while(myRs.next()){
//				System.out.println(myRs.getString("name") + " | " + myRs.getString("id"));
//			}
//			
//			
//			/*Below is working code snippet... U may use it if you need
//			 
//			 
//			//--------------------------------------------------
//			//Get a connection to database
//			Connection myConn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mcms", "root", "");
//			
//			//Start transaction
//			myConn2.setAutoCommit(false);
//			
//			//perform multiple sql statements
//			 * like,
//				Statement myStmt = myConn.createStatement();
//				String sqlCommand = "INSERT INTO demotable (id, name) VALUES ('15', 'Suram')";
//				myStmt.executeUpdate(sqlCommand);
//			//...
//			
//			boolean ok; //= askingUseristhatoktosave();
//			
//			if (ok){
//				//store in database
//				myConn2.commit();
//			}else{
//				//discard
//				myConn2.rollback();
//			}
//			
//			//----------------------------------------------
//			*/
//			
//			
//			
//		}catch(Exception exc){
//			System.out.println("Database Error");
//		}
//
//	}

}
