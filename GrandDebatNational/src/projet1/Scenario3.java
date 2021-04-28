package projet1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* Scenario avec un savepoint */
public class Scenario3 {
	
	
	
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
			DatabaseMetaData dbmd=connection.getMetaData();
			
			
			if(dbmd.supportsSavepoints()) {
				System.out.println("Savepoint supported by the driver and database");
				
				// Mettre l'auto commit a false
				connection.setAutoCommit(false);
				
				
				//Test avec Savepoint 
				stat.executeUpdate("Update contribution set count_vote=1 where count_vote=0  ");
				
				stat.executeUpdate("Update contribution set count_vote=count_vote+1 where count_vote=1");
				
				
				Savepoint jalon1 = connection.setSavepoint();
				 
				stat.executeUpdate("Update users set age=18 where age=0  ");
				
				stat.executeUpdate("Update users set age=age+1 where age>18 ");
				connection.rollback(jalon1);
				
				
				Savepoint jalon2 = connection.setSavepoint();
				stat.executeUpdate("Update contribution set count_vote=1 where count_vote=0  ");
				
				stat.executeUpdate("Update contribution set count_vote=count_vote+1 where count_vote=1");
				
				
				// Rollback to savepoint
				System.out.println("\n  Annulation des requetes à partir du jalon1 .\n");
				
				
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
				
				
			}else {
				
				System.out.println("Savepoint is not supported by the driver and database");
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
