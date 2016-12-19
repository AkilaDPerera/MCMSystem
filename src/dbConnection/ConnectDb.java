package dbConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectDb {
	private static Connection connection = null;
	private static Statement statement = null;

	private static void getConnected() throws FileNotFoundException, IOException, SQLException {
		if (ConnectDb.connection == null) {
			Properties props = new Properties();
			props.load(new FileInputStream("demo.properties"));

			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String dburl = props.getProperty("dburl");

			ConnectDb.connection = DriverManager.getConnection(dburl, user, password);
			ConnectDb.statement = ConnectDb.connection.createStatement();
		}
	}

	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		ConnectDb.getConnected();
		return ConnectDb.connection;
	}

	public static Statement getStatement() throws FileNotFoundException, IOException, SQLException {
		ConnectDb.getConnected();
		return ConnectDb.statement;
	}

	public static void closeConnections() throws SQLException {
		ConnectDb.connection.close();
		ConnectDb.statement.close();
	}

	// This for initializing purposes
	public static void initializeDB() throws FileNotFoundException, IOException {
		try {
			// Create a DB called mcms
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			Statement statement = conn.createStatement();
			String create_db = "CREATE DATABASE IF NOT EXISTS mcms";
			statement.executeUpdate(create_db);
			statement.close();
			conn.close();

			Statement stat = (Statement) ConnectDb.getStatement();

			// Table creations
			String[] table_creation = new String[] {
					"CREATE TABLE IF NOT EXISTS mcms.family (id INT NOT NULL AUTO_INCREMENT,  mother_name VARCHAR(255) NULL, mother_phone VARCHAR(15) NULL,  father_name VARCHAR(255) NULL,  father_phone VARCHAR(15) NULL, guardian_name VARCHAR(255) NULL,  guardian_phone VARCHAR(15) NULL,  PRIMARY KEY (id));",
					"CREATE TABLE IF NOT EXISTS `mcms`.`student` (  `id` INT NOT NULL AUTO_INCREMENT,  `first_name` VARCHAR(50) NOT NULL,  `last_name` VARCHAR(50) NOT NULL,  `phone` VARCHAR(15) NOT NULL,  `alt_phone` VARCHAR(15) NULL,  `address` VARCHAR(255) NOT NULL,  `email` VARCHAR(255) NULL,  `dob` DATE NOT NULL,  `gender` ENUM('male', 'female') NOT NULL,  `family_id` INT NOT NULL,  PRIMARY KEY (`id`, `family_id`),  CONSTRAINT `student_family_id`    FOREIGN KEY (`family_id`)    REFERENCES `mcms`.`family` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION);",
					"CREATE TABLE IF NOT EXISTS `mcms`.`user` (  `id` INT NOT NULL,  `privileges` ENUM('admin', 'teacher', 'guest') NOT NULL,  `username` VARCHAR(45) NOT NULL,  `password` VARCHAR(100) NOT NULL,  `email` VARCHAR(45) NULL,  PRIMARY KEY (`id`));",
					"CREATE TABLE IF NOT EXISTS `mcms`.`teacher` (  `id` INT NOT NULL AUTO_INCREMENT,  `first_name` VARCHAR(50) NOT NULL,  `last_name` VARCHAR(50) NOT NULL,  `phone` VARCHAR(20) NOT NULL,  `alt_phone` VARCHAR(20) NULL,  `address` VARCHAR(255) NULL,  `email` VARCHAR(45) NULL,  `user_id` INT,  PRIMARY KEY (`id`));",
					"CREATE TABLE IF NOT EXISTS `mcms`.`class` (  `id` INT NOT NULL AUTO_INCREMENT,  `subject` VARCHAR(100) NOT NULL, `class_type` ENUM('individual', 'group') NOT NULL, `monthly_fee` DECIMAL NOT NULL,  `commence_date` DATE NOT NULL,`start_time` TIME NOT NULL,  `end_time` TIME NOT NULL,  `max_students` INT NOT NULL,  `location` VARCHAR(255) NOT NULL, `day` ENUM('Sunday', 'Monday', 'Tuesday', 'Wednesay', 'Thursday', 'Friday', 'Saturday') NOT NULL,  PRIMARY KEY (`id`));",
					"CREATE TABLE IF NOT EXISTS `mcms`.`takes` (  `class_student_id` INT NOT NULL AUTO_INCREMENT,  `class_id` INT NOT NULL,  `student_id` INT NOT NULL,  `enabled` TINYINT(1) NOT NULL DEFAULT 1 COMMENT 'Whether the student is still studying (has not abandoned) the class. ',  PRIMARY KEY (`class_student_id`),  CONSTRAINT `takes_class`    FOREIGN KEY (`class_id`)    REFERENCES `mcms`.`class` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,  CONSTRAINT `takes_student`    FOREIGN KEY (`student_id`)    REFERENCES `mcms`.`student` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION);",
					"CREATE TABLE IF NOT EXISTS `mcms`.`payment` (  `class_student_id` INT NOT NULL,  `date` DATETIME NOT NULL,  `amount` DECIMAL NOT NULL,  PRIMARY KEY (`class_student_id`),  CONSTRAINT `class_student_payment`    FOREIGN KEY (`class_student_id`)    REFERENCES `mcms`.`takes` (`class_student_id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION);",
					"CREATE TABLE IF NOT EXISTS `mcms`.`progress` (  `class_student_id` INT NOT NULL,  `task_type` VARCHAR(45) NOT NULL,  `task_date` DATETIME NOT NULL,  `status` ENUM('notyet', 'ongoing', 'completed', 'marked') NOT NULL,  `marks` INT NULL,  PRIMARY KEY (`class_student_id`),  CONSTRAINT `class_student_progress`    FOREIGN KEY (`class_student_id`)    REFERENCES `mcms`.`takes` (`class_student_id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION);",
					"CREATE TABLE IF NOT EXISTS `mcms`.`teaches` (  `class_teacher_id` INT NOT NULL AUTO_INCREMENT,  `class_id` INT NOT NULL,  `teacher_id` INT NOT NULL,  `hourly_salary` DECIMAL NOT NULL COMMENT 'The amount to be paid for teacher for the class.',  PRIMARY KEY (`class_teacher_id`),  CONSTRAINT `teaches_class`    FOREIGN KEY (`class_id`)    REFERENCES `mcms`.`class` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,  CONSTRAINT `teaches_teacher`    FOREIGN KEY (`teacher_id`)    REFERENCES `mcms`.`teacher` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION) COMMENT = 'This table enables teachers to be specified per each class. This makes substitute teachers option possible. Also this enables, multiple teachers to be used throughtout the course. * User interface must provide a mechanism to select the previous teacher again for next session. ';",
					"CREATE TABLE IF NOT EXISTS `mcms`.`teacher_payment` (  `class_teacher_id` INT NOT NULL,  `date` DATETIME NOT NULL,  `amount` DECIMAL NOT NULL,  PRIMARY KEY (`class_teacher_id`),  CONSTRAINT `teacher_payment`    FOREIGN KEY (`class_teacher_id`)    REFERENCES `mcms`.`teaches` (`class_teacher_id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION);",
					"CREATE TABLE IF NOT EXISTS `mcms`.`session` (  `id` INT NOT NULL,  `class_id` INT NOT NULL,  `class_held` TINYINT(1) NOT NULL,  `teacher_id` INT NOT NULL,  `substitute_teacher` TINYINT(1) NOT NULL,  `date` DATE NOT NULL,  `start_time` TIME NOT NULL,  `end_time` TIME NOT NULL,  PRIMARY KEY (`id`),  CONSTRAINT `session_class_id`    FOREIGN KEY (`class_id`)    REFERENCES `mcms`.`class` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,  CONSTRAINT `session_teacher_id`    FOREIGN KEY (`teacher_id`)    REFERENCES `mcms`.`teacher` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION);",
					"CREATE TABLE IF NOT EXISTS `mcms`.`attendance` (  `session_id` INT NOT NULL,  `student_id` INT NOT NULL,  CONSTRAINT `session_student`    FOREIGN KEY (`student_id`)    REFERENCES `mcms`.`student` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,  CONSTRAINT `session_id`    FOREIGN KEY (`session_id`)    REFERENCES `mcms`.`session` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION);",
					"CREATE TABLE IF NOT EXISTS `mcms`.`teacher_attendance` (  `session_id` INT NOT NULL,  `teacher_id` INT NOT NULL,  CONSTRAINT `session_teacher`    FOREIGN KEY (`teacher_id`)    REFERENCES `mcms`.`teacher` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION,  CONSTRAINT `session_teachers_id`    FOREIGN KEY (`session_id`)    REFERENCES `mcms`.`session` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION);"					
			};
			System.out.println("queries running!!!");
			for (String sql : table_creation) {
				stat.executeUpdate(sql);
			}

			// Data inserting
			String[] insert = new String[] {
					"insert into `mcms`.`user` values ('1', 'admin', 'demo','demo',' ');",
					"insert into `mcms`.`user` values ('2', 'teacher', 'demot','demot',' ');"

					//"INSERT INTO `mcms`.`user` (`iduser`, `role`, `username`, `password`,'email') VALUES ('1', 'admin', 'demo', 'demo','');",
					//"INSERT INTO `mcms`.`user` (`iduser`, `role`, `username`, `password`,'email') VALUES ('2', 'teacher', 'demot', 'demot','');" 
					};
			System.out.println("inserting!!!");
			for (String sql : insert) {
				stat.executeUpdate(sql);
			}

		} catch (Exception e) {

		}

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ConnectDb.initializeDB();
		System.out.println("This is running from ConnectDb class due to easy development");
	}

	// public static void main(String[] args) throws FileNotFoundException,
	// IOException {
	// //I have already put the mysql-connector to the project. so no need to
	// worry about it.
	//
	// //Below is a standard way of getting Database url, user and password...
	// Actually the place where store the info is in the root folder in the file
	// called demo.properties
	// Properties props = new Properties();
	// props.load(new FileInputStream("demo.properties"));
	//
	// String user = props.getProperty("user");
	// String password = props.getProperty("password");
	// String dburl = props.getProperty("dburl");
	// //Loading the user, password and url is done now.
	//
	// try{
	// //Get a connection to database
	// Connection myConn = DriverManager.getConnection(dburl, user, password);
	//
	// //Create a statement
	// Statement myStmt = myConn.createStatement();
	//
	// //Insert record
	// String sqlCommand = "INSERT INTO demotable (id, name) VALUES ('15',
	// 'Suram')";
	// myStmt.executeUpdate(sqlCommand);
	//
	// //Execute SQL query
	// ResultSet myRs = myStmt.executeQuery("SELECT * FROM demotable");
	//
	// //Proccess the result set
	// while(myRs.next()){
	// System.out.println(myRs.getString("name") + " | " +
	// myRs.getString("id"));
	// }
	//
	//
	// /*Below is working code snippet... U may use it if you need
	//
	//
	// //--------------------------------------------------
	// //Get a connection to database
	// Connection myConn2 =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/mcms", "root",
	// "");
	//
	// //Start transaction
	// myConn2.setAutoCommit(false);
	//
	// //perform multiple sql statements
	// * like,
	// Statement myStmt = myConn.createStatement();
	// String sqlCommand = "INSERT INTO demotable (id, name) VALUES ('15',
	// 'Suram')";
	// myStmt.executeUpdate(sqlCommand);
	// //...
	//
	// boolean ok; //= askingUseristhatoktosave();
	//
	// if (ok){
	// //store in database
	// myConn2.commit();
	// }else{
	// //discard
	// myConn2.rollback();
	// }
	//
	// //----------------------------------------------
	// */
	//
	//
	//
	// }catch(Exception exc){
	// System.out.println("Database Error");
	// }
	//
	// }

}
