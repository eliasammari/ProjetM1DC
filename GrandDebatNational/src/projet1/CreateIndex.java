package projet1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class CreateIndex {
	
	

	
	
	public static void main(String[] args) {
		
		Connection connection;
		Statement stat;
		String requete,query;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/granddebat?useSSL=false&serverTimezone=UTC","root","");
			stat = connection.createStatement();

			
			stat.execute("CREATE INDEX id_contrib_index on Contribution (id_contrib)");
		    System.out.println("Index id_contrib_index inserted");
		    System.out.println(" ");
		      //listing all the indexes
		    System.out.println("Listing all the columns with indexes");
		      //Dropping indexes
		    //stat.execute("Drop INDEX id_contrib_index ");
			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	



}
