package dbConnection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import view.Main;

public class LogWriter {

	public static void writeQueryToLog(PreparedStatement query) {
		File log = new File("log.txt");

		try {
			if (!log.exists()) {
				System.out.println("We had to make a new file.");
				log.createNewFile();
			}

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();

			FileWriter fileWriter = new FileWriter(log, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String separator = System.getProperty("line.separator");
			String string = "Username:-  " + Main.getUsername() + " ( " + Main.getRole() + " ) " + separator + "Time:- "
					+ dateFormat.format(date) + separator + "Executed query:- " + query.toString() + separator
					+ separator;

			bufferedWriter.write(string);
			bufferedWriter.close();

			// System.out.println("Done");
		} catch (IOException e) {
			System.out.println("COULD NOT LOG!!");
		}

	}

}
