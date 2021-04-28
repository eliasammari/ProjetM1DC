package projet1;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
public class ProcedureStockee {
	
	
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

			
			// 1ere procedure : liste et nombre des utilisateurs d'un département
			
			/*stat.executeUpdate("DROP PROCEDURE IF EXISTS get_user_for_departement"); 
			stat.executeUpdate(
					"CREATE PROCEDURE get_user_for_departement(IN numDep INT) \n"
					+ "BEGIN\n"
					+ "SELECT * from Users where code_postal=numDep;\n"
					+ "SELECT count(*) from Users where code_postal=numDep;\n"
					+ " END\n ");
			
			
			String sql = "{call get_user_for_departement(?)}"; 
			CallableStatement call = connection.prepareCall(sql);
			
			call.setInt (1,57000);
			
			
			if(call.execute()){ 
			    //récupération des ResultSet 
			    ResultSet resultat1 = call.getResultSet(); 
			    call.getMoreResults(Statement.KEEP_CURRENT_RESULT); 
			    ResultSet resultat2 = call.getResultSet(); 
			    //traitement des informations 
			    while(resultat1.next()){ 
			        for(int i=0;i<resultat1.getMetaData().getColumnCount();i++){ 
			            System.out.print(resultat1.getObject(i+1)+", "); 
			        } 
			        System.out.println(""); 
			    } 
			    resultat2.next(); 
			    System.out.println("Nombre de lignes = "+resultat2.getObject(1)); 
			    resultat1.close(); 
			    resultat2.close(); 
			}*/
			
			
			
			
			//2eme procédure: Affiche les contributions par theme
			stat.executeUpdate("DROP PROCEDURE IF EXISTS get_contrib_par_theme"); 
			stat.executeUpdate(
					"CREATE PROCEDURE get_contrib_par_theme(IN theme VARCHAR(100)) \n"
					+ "BEGIN\n"
					+ "SELECT c.contenu from contribution c,theme t where c.FK_theme_id=t.id_theme and t.nom_theme=theme;\n"
					+ "SELECT count(*) from contribution c,theme t where c.FK_theme_id=t.id_theme and t.nom_theme=theme;\n"
					+ " END\n ");
			String sql = "{call get_contrib_par_theme(?)}"; 
			CallableStatement call = connection.prepareCall(sql);
			
			call.setString(1, "Transition écologique");
			
			
			if(call.execute()){ 
			    //récupération des ResultSet 
			    ResultSet resultat1 = call.getResultSet(); 
			    call.getMoreResults(Statement.KEEP_CURRENT_RESULT); 
			    ResultSet resultat2 = call.getResultSet(); 
			    //traitement des informations 
			    while(resultat1.next()){ 
			        for(int i=0;i<resultat1.getMetaData().getColumnCount();i++){ 
			            System.out.print(resultat1.getObject(i+1)+", "); 
			        } 
			        System.out.println(""); 
			    } 
			    resultat2.next(); 
			    System.out.println("Nombre de contributions pour ce theme = "+resultat2.getObject(1)); 
			    resultat1.close(); 
			    resultat2.close();
			
			
			
			
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
 }

}
