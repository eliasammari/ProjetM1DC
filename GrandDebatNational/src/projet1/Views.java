package projet1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Views {
	

	
	
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
			
			// View1 :nb_vote_contribution Chaque contribution et son nombre de vote
			/*query="CREATE VIEW nb_vote_contribution AS SELECT titre ,count_vote from contribution ";
			//Execution de view
			stat.execute(query);
			
			
			// affichage de la vue
			result =stat.executeQuery("Select * from nb_vote_contribution ");
			while(result.next()) {
				System.out.println("Titre   :"+result.getString("titre") + " ---nombre de vote  : "+result.getString("count_vote")   );
			}*/
			
			long lStartTime = System.nanoTime();

			//View2 : nb_vote_question_contribution Chaque question_contribution et le nombre total de vote
			query="CREATE OR REPLACE VIEW nb_vote_question_contribution AS SELECT FK_question_contrib_id,nom_question_contribution ,SUM(count_vote) AS nb_vote_total,SUM(count_vote_yes) AS nb_vote_yes,SUM(count_vote_no) AS nb_vote_no from question_contribution q,contribution c where q.id_question_contribution = c.FK_question_contrib_id GROUP BY(FK_question_contrib_id) ";
			//Execution de view
			stat.execute(query);
			
			System.out.println("FK_question_contrib_id   ----   nom_question_contribution ----   nb_vote_total  ----  nb_vote_yes   ---- nb_vote_no  "  );
			result =stat.executeQuery("Select * from nb_vote_question_contribution ");
			while(result.next()) {
				System.out.println(result.getString("FK_question_contrib_id") + " ---- "+result.getString("nom_question_contribution")+ " ---- "+result.getString("nb_vote_total")+ " ---- "+result.getString("nb_vote_yes")+ " ---- "+result.getString("nb_vote_no")   );
			}
			
	
	        //end
	        long lEndTime = System.nanoTime();

	        //time elapsed
	        long output = lEndTime - lStartTime;

	        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	


	
	

}
