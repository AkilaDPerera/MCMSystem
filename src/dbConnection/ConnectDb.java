package dbConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectDb {
	private static Connection connection = null;
	private static Statement statement = null;
	
	private static void getConnected() throws FileNotFoundException, IOException, SQLException{
		if (ConnectDb.connection==null){
			Properties props = new Properties();
			props.load(new FileInputStream("demo.properties"));
			
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String dburl = props.getProperty("dburl");
			
			ConnectDb.connection = DriverManager.getConnection(dburl, user, password);
			ConnectDb.statement = ConnectDb.connection.createStatement();
		}
	}
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException{
		ConnectDb.getConnected();
		return ConnectDb.connection;
	}
	
	public static Statement getStatement() throws FileNotFoundException, IOException, SQLException{
		ConnectDb.getConnected();
		return ConnectDb.statement;
	}
	
	public static void closeConnections() throws SQLException{
		ConnectDb.connection.close();
		ConnectDb.statement.close();
	}
	
	
	
	//This for initializing purposes
	public static void initializeDB() throws FileNotFoundException, IOException{
		try{
			//Create a DB called mcms
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			Statement statement = conn.createStatement();
			String create_db = "CREATE DATABASE IF NOT EXISTS MCMS";
			statement.executeUpdate(create_db);
			statement.close();
			conn.close();
			
			Statement stat = (Statement) ConnectDb.getStatement();
			
			//Table creations
			String [] table_creation = new String [] {
					"CREATE TABLE IF NOT EXISTS `mcms`.`user` (`iduser` INT NOT NULL,`role` ENUM('teacher', 'staff', 'admin') NOT NULL,`username` CHAR(50) NOT NULL,`password` CHAR(50) NOT NULL,PRIMARY KEY (`iduser`),UNIQUE INDEX `username_UNIQUE` (`username` ASC));",
					"CREATE TABLE IF NOT EXISTS `mcms`.`teacher` (`idteacher` INT NOT NULL AUTO_INCREMENT, `first_name` CHAR(50) NOT NULL, `last_name` CHAR(50) NOT NULL, `phone` CHAR(14) NOT NULL, `alt_phone` CHAR(14) NULL, `address` VARCHAR(255) NOT NULL, `email` VARCHAR(45) NOT NULL, PRIMARY KEY (`idteacher`), UNIQUE INDEX `email_UNIQUE` (`email` ASC));"
					};
			for (String sql: table_creation){
				stat.executeUpdate(sql);
			}
			
			//Data inserting
			String [] insert = new String [] {
					"INSERT INTO `mcms`.`user` (`iduser`, `role`, `username`, `password`) VALUES ('1', 'admin', 'demo', 'demo');",
					"INSERT INTO `mcms`.`user` (`iduser`, `role`, `username`, `password`) VALUES ('2', 'teacher', 'demot', 'demot');"
					};
			
			for (String sql: insert){
				stat.executeUpdate(sql);
			}
			
		}catch(Exception e){
			
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		ConnectDb.initializeDB();
		System.out.println("This is running from ConnectDb class due to easy development");
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
