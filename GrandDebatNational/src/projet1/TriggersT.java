package projet1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class TriggersT {
	
	
	
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

			
			
			/*stat.execute(" CREATE OR REPLACE TRIGGER \"USER_NUM_DEP\" BEFORE INSERT OR UPDATE ON USERS FOR EACH ROW  set \"new.num_departement\"=ROUND(\"new.code_postal\"/1000) ; ");*/
			
			//Trigger qui prend les 2 premieres valeur du code_postal com num departement dès l'insertion
			stat.execute(" CREATE TRIGGER USER_NUM_DEP \n"
					+ "BEFORE INSERT ON USERS \n"
					+ "FOR EACH ROW \n"
					+ " set new.num_departement=ROUND(new.code_postal/1000);\n");
			
			
			//Trigger qui 

			
			
			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
