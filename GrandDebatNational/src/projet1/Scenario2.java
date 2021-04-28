package projet1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Scenario2 {
	
	
	public static void main(String[] args) {
		
		
		
		Connection connection;
		Statement stat;
		String requete,query;
		ResultSet result;
		String path = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/granddebat?useSSL=false&serverTimezone=UTC","root","");
			stat = connection.createStatement();
			
			// Mettre l'auto commit a false
			connection.setAutoCommit(false);
			
			
			//Test avec une Transaction
			stat.executeUpdate("Update users set age=30 where age=0  ");
			
			
			
			boolean ok = askUserIfOkToSave();

			if (ok) {
				// store in database
				connection.commit();
				System.out.println("\n>> Transaction COMMITTED.\n");
			} else {
				// discard
				connection.rollback();
				System.out.println("\n>> Transaction ROLLED BACK.\n");
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	private static boolean askUserIfOkToSave() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Is it okay to save?  yes/no: ");
		String input = scanner.nextLine();

		scanner.close();

		return input.equalsIgnoreCase("yes");
	}

}
