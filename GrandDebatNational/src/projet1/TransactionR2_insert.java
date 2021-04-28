package projet1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TransactionR2_insert {
	
	
	public static void main(String[] args) {
		
		
		
		Connection connection;
		PreparedStatement stat;
		String requete,query;
		ResultSet result;
		String path = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/granddebat?useSSL=false&serverTimezone=UTC","root","");
			
			
			// Mettre l'auto commit a false
			connection.setAutoCommit(false);
			
			
			
			//Test avec une Transaction de 2 inserts
			
			requete = "INSERT IGNORE INTO granddebat.users (id_user, code_postal, commune, type_commune, num_departement, sexe, age, formation, profession, taille_oragnisme, position_gj, statut, pseudonyme, origine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, "user1", Types.VARCHAR);
			stat.setObject(2, null, Types.INTEGER);
			stat.setObject(3, null, Types.VARCHAR);
			stat.setObject(4, null, Types.VARCHAR);
			stat.setObject(5, null, Types.INTEGER);
			stat.setObject(6, null, Types.VARCHAR);
			stat.setObject(7, null, Types.INTEGER);						
			stat.setObject(8, null, Types.VARCHAR);
			stat.setObject(9, null, Types.VARCHAR);
			stat.setObject(10, null, Types.VARCHAR);
			stat.setObject(11, null, Types.VARCHAR);						
			stat.setObject(12, null, Types.VARCHAR);
			stat.setObject(13, null, Types.VARCHAR);						
			stat.setObject(14, "Vrai Débat", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			
			requete = "INSERT IGNORE INTO granddebat.contribution (id_contrib,FK_user_id,FK_theme_id,FK_question_contrib_id,contenu,titre,count_vote,count_vote_yes,count_vote_no,count_vote_mitige,origine,date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, "contrib1", Types.VARCHAR);
			stat.setObject(2, "user1", Types.VARCHAR);
			stat.setObject(3,13, Types.INTEGER);
			stat.setObject(4, 79, Types.INTEGER);
			stat.setObject(5, "santé mentale", Types.VARCHAR);
			stat.setObject(6, "covid", Types.VARCHAR);
			stat.setObject(7, 20,Types.INTEGER);
			stat.setObject(8, "30",Types.INTEGER);
			stat.setObject(9, 10,Types.INTEGER);
			stat.setObject(10, 20,Types.INTEGER);
			stat.setObject(11, "Vrai Débat", Types.VARCHAR);						
			stat.setObject(12, "12-03-2021", Types.TIMESTAMP);
			stat.executeUpdate();
			stat.close(); 
			
			
			
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
