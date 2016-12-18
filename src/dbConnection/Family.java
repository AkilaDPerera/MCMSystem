package dbConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Family {

	public static String [] getFamilyDetails(String familyID) throws FileNotFoundException, IOException, SQLException{
		
		Connection conn = (Connection) ConnectDb.getConnection();
		PreparedStatement familyFromId = (PreparedStatement) conn.prepareStatement("SELECT mother_name, mother_phone, father_name, father_phone, guardian_name, guardian_phone FROM family WHERE id=?");
		familyFromId.setString(1, familyID);
		ResultSet rs = familyFromId.executeQuery();
		
		if (rs.next()){
			return new String [] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
		}else{
			return null;
		}
	}
	
	public static String createNewFamily(String motherName, String motherPhone, String dadName, String dadPhone, String guardianName, String guardianPhone) throws SQLException, FileNotFoundException, IOException{
		Connection conn = (Connection) ConnectDb.getConnection();
		//Add family
		PreparedStatement addEntry = (PreparedStatement) conn.prepareStatement("INSERT INTO `mcms`.`family`(`mother_name`, `mother_phone`, `father_name`, `father_phone`, `guardian_name`, `guardian_phone`) VALUES (?, ?, ?, ?, ?, ?);");
		addEntry.setString(1, motherName);
		addEntry.setString(2, motherPhone);
		addEntry.setString(3, dadName);
		addEntry.setString(4, dadPhone);
		addEntry.setString(5, guardianName);
		addEntry.setString(6, guardianPhone);
		addEntry.executeUpdate();
		
		//Return the id
		PreparedStatement getID = (PreparedStatement) conn.prepareStatement("SELECT id FROM `mcms`.`family` WHERE `mother_name`=? AND `mother_phone`=? AND `father_name`=? AND `father_phone`=? AND `guardian_name`=? AND `guardian_phone`=?;");
		getID.setString(1, motherName);
		getID.setString(2, motherPhone);
		getID.setString(3, dadName);
		getID.setString(4, dadPhone);
		getID.setString(5, guardianName);
		getID.setString(6, guardianPhone);
		ResultSet rs = getID.executeQuery();
		
		if (rs.next()){
			return rs.getString(1);
		}else{
			return null;
		}
	}

//	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
//		System.out.println(createNewFamily("abc1", "071", "cde", "045", "asd", "564"));
//		System.out.println("Done");
//	}

}
