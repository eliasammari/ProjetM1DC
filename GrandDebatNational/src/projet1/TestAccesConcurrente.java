package projet1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class TestAccesConcurrente {
	
	
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
			//connection.setAutoCommit(false);
			
			//exemple 1: Lecture ecriture
			//Thread1
			stat.executeUpdate("Update users set age=age+1 where num_departement=31  ");
			
			//thread2
			stat.executeUpdate("select * from users where num_departement=31 FOR UPDATE ");
			
			
			
			
			//Exemple2: 2 lecture un qui pose un verrou exclusif
			//Thread1
			stat.executeUpdate("Update contributions set count_vote=count(*) where FK_theme_id=1  ");
			
			//Thread2
			stat.executeUpdate("Update contributions set count_vote_yes=count_vote-count_vote_no where FK_theme_id=1   ");
			
			
			
			/*boolean ok = askUserIfOkToSave();

			if (ok) {
				// store in database
				connection.commit();
				System.out.println("\n>> Transaction COMMITTED.\n");
			} else {
				// discard
				connection.rollback();
				System.out.println("\n>> Transaction ROLLED BACK.\n");
			}*/


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
