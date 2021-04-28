package projet1;

//import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
//import java.util.Date;
public class Requetes {

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
			
			long lStartTime = System.nanoTime();
			

			// Simple Select sur les differentes tables contribution
			
			//result =stat.executeQuery("Select * from Users");
			//result =stat.executeQuery("Select * from Reponses_qcm");
			
			/*result =stat.executeQuery("Select * from Contribution");
			while(result.next()) {
				System.out.println("Titre   :"+result.getString("titre") + " ---Origine  : "+result.getString("origine")   + "   ---  La date  : "+ result.getDate("date") );
			}*/
			
			
			
			//Requete avec jointure Optimisé :Selection des contributions dont l'origine est le vrai débat
			/*result =stat.executeQuery("Select * from Contribution C, question_contribution Q  where C.origine='vrai débat' and C.FK_question_contrib_id=Q.id_question_contribution ");
			while(result.next()) {
				System.out.println("Titre   :"+result.getString("titre") + " ---Origine  : "+result.getString("origine")   + "   ---  La date  : "+ result.getDate("date") );
			}*/
			
			
			
			
			//Requete avec Group By/Having : Les questions contributions qui ont plus de 100 Contributions( de reponses)
			result =stat.executeQuery("Select Q.nom_question_contribution,count(C.id_contrib) AS nb_contrib from contribution C, question_contribution Q  where C.FK_question_contrib_id=Q.id_question_contribution GROUP BY Q.nom_question_contribution HAVING count(C.id_contrib)>100 ");
			while(result.next()) {
				System.out.println("Question Contribution   :"+result.getString("Q.nom_question_contribution") + "   ---- Nombre de contributions  : "+result.getString("nb_contrib")  );
			}
			
			
			
			//Requete avec Group By: Les contributions regroupés par theme
			/*result =stat.executeQuery("Select nom_theme,contenu from theme T,contribution C  where C.FK_theme_id=T.id_Theme GROUP BY T.nom_theme ");
			while(result.next()) {
				System.out.println("Thème   :"+result.getString("nom_theme") + "   ---- La contrinbution  : "+result.getString("contenu")  );
			}*/
			
			//requete avec Order by
			/*result =stat.executeQuery("Select * from users  where origine in ('Grand Débat qcm') ORDER BY code_postal ");
			while(result.next()) {
				System.out.println("Statut User   :"+result.getString("statut") + "   ---- Le Département  : "+result.getString("code_postal")  );
			}*/
			
			
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
