package projet1;

import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.io.InputStreamReader;
//import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.text.SimpleDateFormat;
//import java.util.Date;

//import com.opencsv.CSVReader;

public class MainGrandDebat {

	public MainGrandDebat() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Connection connection;
		PreparedStatement stat;
		String requete,query;
		String path = null;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



		try {
			/*Class.forName("com.mysql.jdbc.Driver");*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/granddebat?autoReconnect=true&useSSL=false", "root" , "");*/
					connection = DriverManager.getConnection("jdbc:mysql://localhost/granddebat?useSSL=false&serverTimezone=UTC","root","");



			//empty tables

			query ="delete from contribution where origine = ?";
			stat = connection.prepareStatement(query);
			stat.setObject(1, "Grand Débat", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
					
			/*query ="delete from question_contribution";
			stat = connection.prepareStatement(query);
			stat.execute();
			stat.close();
			query ="delete from users where origine = ?";
			stat = connection.prepareStatement(query);
			stat.setObject(1, "Grand Débat", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();*/
			/*PrintStream fileOut = new PrintStream("./outcontrib.txt");
			System.setOut(fileOut);*/


			int j = 0;
			int x ;
			int id_question_contrib = 0;
			for (int i = 1; i < 5; i++) {
				switch (i) {
				
					case 1:
						path = "C:/ut3/ue_projet/grandDebat/LA_TRANSITION_ECOLOGIQUE.csv";
					break;
					case 2:
						path = "C:/ut3/ue_projet/grandDebat/LA_FISCALITE_ET_LES_DEPENSES_PUBLIQUES.csv";
					break;
					case 3:
						path = "C:/ut3/ue_projet/grandDebat/DEMOCRATIE_ET_CITOYENNETE.csv";
					break;
					case 4:
						path = "C:/ut3/ue_projet/grandDebat/ORGANISATION_DE_LETAT_ET_DES_SERVICES_PUBLICS.csv";
					break;
				}
				j = 0;
				int k = 0;
				BufferedReader csvReader = new BufferedReader( new InputStreamReader(new FileInputStream(path),"UTF-8"));
				//CSVReader csvReader = new CSVReader(new BufferedReader( new InputStreamReader(new FileInputStream(path),"UTF-8")));
				
				String row;
				System.out.println(i);
				while ((row = csvReader.readLine()) != null) {

					k++;
					String[] data = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					//remplir les classes
					if(j == 0){
						switch (i) {
						case 1:
							for( x = 0; x<15; x++){
								requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								
								stat.setObject(1, id_question_contrib, Types.VARCHAR);
								
								stat.setObject(2, i, Types.INTEGER);
								if(data[x+11].length()>4000)
									stat.setObject(3, data[x+11].substring(0,3999));
								else
									stat.setObject(3, data[x+11], Types.VARCHAR);
								stat.setObject(4, "Grand Débat", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								id_question_contrib++;
							}
							break;
						case 2:
							for( x = 0; x<8; x++){
								requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, id_question_contrib, Types.VARCHAR);
								stat.setObject(2, i, Types.INTEGER);
								stat.setObject(3, data[x+11], Types.VARCHAR);
								stat.setObject(4, "Grand Débat", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								id_question_contrib++;
							}
							break;
						case 3:
							for( x = 0; x<37; x++){
								requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, id_question_contrib, Types.VARCHAR);
								stat.setObject(2, i, Types.INTEGER);
								stat.setObject(3, data[x+11], Types.VARCHAR);
								stat.setObject(4, "Grand Débat", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								id_question_contrib++;
							}
							break;
						case 4:
							for( x = 0; x<33; x++){
								requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, id_question_contrib, Types.VARCHAR);
								stat.setObject(2, i, Types.INTEGER);
								stat.setObject(3, data[x+11], Types.VARCHAR);
								stat.setObject(4, "Grand Débat", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								id_question_contrib++;
							}
							break;
						}
						j++;
					}
					else{
						/*if (data[0].length()>100) {
							System.out.println(data[0]);
							System.out.println(k);
							System.out.println();
						}*/
						/*String[] data = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);*/
						
						
						
						if (data.length > 10 && data[7].length() == 58 && data[0].contains("2-") && data[0].length()<10 && data[2].contains("20")){
							System.out.println(data[0]);
							System.out.println(data[2]);
							switch (i) {
								
							
							case 1:
								id_question_contrib = 0;
								
								requete = "INSERT IGNORE INTO granddebat.users (id_user, code_postal, commune, type_commune, num_departement, sexe, age, formation, profession, taille_oragnisme, position_gj, statut, pseudonyme, origine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, data[7], Types.VARCHAR);
								if (data[9].length() > 7)
									data[9] = data[9].substring(1, 6);
								stat.setObject(2, data[9].replace("\"", ""), Types.VARCHAR);
								stat.setObject(3, null, Types.VARCHAR);
								stat.setObject(4, null, Types.VARCHAR);
								stat.setObject(5, null, Types.INTEGER);
								stat.setObject(6, null, Types.VARCHAR);
								stat.setObject(7, null, Types.INTEGER);						
								stat.setObject(8, null, Types.VARCHAR);
								stat.setObject(9, null, Types.VARCHAR);
								stat.setObject(10, null, Types.VARCHAR);
								stat.setObject(11, null, Types.VARCHAR);						
								stat.setObject(12, data[8], Types.VARCHAR);
								stat.setObject(13, null, Types.VARCHAR);						
								stat.setObject(14, "Grand Débat Contribution", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								
								
								for(x = 0; x<1; x++){
									if(data[x+11].length()>2) {
										requete = "INSERT IGNORE INTO granddebat.contribution (id_contrib,FK_user_id,FK_theme_id,FK_question_contrib_id,contenu,titre,count_vote,count_vote_yes,count_vote_no,count_vote_mitige,origine,date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
										stat = connection.prepareStatement(requete);
										stat.setObject(1, id_question_contrib+"-"+data[0], Types.VARCHAR);
										stat.setObject(2, data[7], Types.VARCHAR);
										stat.setObject(3, i, Types.INTEGER);
										stat.setObject(4, id_question_contrib, Types.INTEGER);
										if(data[x+11].length()>4000)
											stat.setObject(5, data[x+11].substring(0,3999));
										else
											stat.setObject(5, data[x+11]);
										
										/*stat.setObject(5, data[x+11], Types.VARCHAR);*/
										stat.setObject(6, data[1], Types.VARCHAR);
										stat.setObject(7, null ,Types.INTEGER);
										stat.setObject(8, null,Types.INTEGER);
										stat.setObject(9, null,Types.INTEGER);
										stat.setObject(10, null,Types.INTEGER);
										stat.setObject(11, "Grand Débat", Types.VARCHAR);						
										stat.setObject(12,  (data[2].replace("\"", "")));
										stat.executeUpdate();
										stat.close();
									}
									id_question_contrib++;
								}
								break;
								
							case 2:
								id_question_contrib = 16;
								requete = "INSERT IGNORE INTO granddebat.users (id_user, code_postal, commune, type_commune, num_departement, sexe, age, formation, profession, taille_oragnisme, position_gj, statut, pseudonyme, origine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, data[7], Types.VARCHAR);
								if (data[9].length() > 7)
									data[9] = data[9].substring(1, 6);
								stat.setObject(2, data[9].replace("\"", ""), Types.VARCHAR);
								stat.setObject(3, null, Types.VARCHAR);
								stat.setObject(4, null, Types.VARCHAR);
								stat.setObject(5, null, Types.INTEGER);
								stat.setObject(6, null, Types.VARCHAR);
								stat.setObject(7, null, Types.INTEGER);						
								stat.setObject(8, null, Types.VARCHAR);
								stat.setObject(9, null, Types.VARCHAR);
								stat.setObject(10, null, Types.VARCHAR);
								stat.setObject(11, null, Types.VARCHAR);						
								stat.setObject(12, data[8], Types.VARCHAR);
								stat.setObject(13, null, Types.VARCHAR);						
								stat.setObject(14, "Grand Débat Contribution", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								
								for(x = 0; x<8; x++){
									if(data[x+11].length()>2){
										requete = "INSERT IGNORE INTO granddebat.contribution (id_contrib,FK_user_id,FK_theme_id,FK_question_contrib_id,contenu,titre,count_vote,count_vote_yes,count_vote_no,count_vote_mitige,origine,date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
										stat = connection.prepareStatement(requete);
										stat.setObject(1, id_question_contrib+"-"+data[0], Types.VARCHAR);
										stat.setObject(2, data[7], Types.VARCHAR);
										stat.setObject(3, i, Types.INTEGER);
										stat.setObject(4, id_question_contrib, Types.INTEGER);
										stat.setObject(5, data[x+11], Types.VARCHAR);
										stat.setObject(6, data[2], Types.VARCHAR);
										stat.setObject(7, null ,Types.INTEGER);
										stat.setObject(8, null,Types.INTEGER);
										stat.setObject(9, null,Types.INTEGER);
										stat.setObject(10, null,Types.INTEGER);
										stat.setObject(11, "Grand Débat", Types.VARCHAR);						
										stat.setObject(12, format.parse (data[2].replace("\"", "")), Types.TIMESTAMP);
										stat.executeUpdate();
										stat.close();
									}
									id_question_contrib++;
								}
								break;
							case 3:
								id_question_contrib = 24;
								requete = "INSERT IGNORE INTO granddebat.users (id_user, code_postal, commune, type_commune, num_departement, sexe, age, formation, profession, taille_oragnisme, position_gj, statut, pseudonyme, origine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, data[7], Types.VARCHAR);
								if (data[9].length() > 7)
									data[9] = data[9].substring(1, 6);
								stat.setObject(2, data[9].replace("\"", ""), Types.VARCHAR);
								stat.setObject(3, null, Types.VARCHAR);
								stat.setObject(4, null, Types.VARCHAR);
								stat.setObject(5, null, Types.INTEGER);
								stat.setObject(6, null, Types.VARCHAR);
								stat.setObject(7, null, Types.INTEGER);						
								stat.setObject(8, null, Types.VARCHAR);
								stat.setObject(9, null, Types.VARCHAR);
								stat.setObject(10, null, Types.VARCHAR);
								stat.setObject(11, null, Types.VARCHAR);						
								stat.setObject(12, data[8], Types.VARCHAR);
								stat.setObject(13, null, Types.VARCHAR);						
								stat.setObject(14, "Grand Débat Contribution", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								
								for(x = 0; x<37; x++){
									if(data[x+11].length()>2){
										requete = "INSERT IGNORE INTO granddebat.contribution (id_contrib,FK_user_id,FK_theme_id,FK_question_contrib_id,contenu,titre,count_vote,count_vote_yes,count_vote_no,count_vote_mitige,origine,date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
										stat = connection.prepareStatement(requete);
										stat.setObject(1, id_question_contrib+"-"+data[0], Types.VARCHAR);
										stat.setObject(2, data[7], Types.VARCHAR);
										stat.setObject(3, i, Types.INTEGER);
										stat.setObject(4, id_question_contrib, Types.INTEGER);
										stat.setObject(5, data[x+11], Types.VARCHAR);
										stat.setObject(6, data[2], Types.VARCHAR);
										stat.setObject(7, null ,Types.INTEGER);
										stat.setObject(8, null,Types.INTEGER);
										stat.setObject(9, null,Types.INTEGER);
										stat.setObject(10, null,Types.INTEGER);
										stat.setObject(11, "Grand Débat", Types.VARCHAR);						
										stat.setObject(12, format.parse (data[2].replace("\"", "")), Types.TIMESTAMP);
										stat.executeUpdate();
										stat.close();
									}
									id_question_contrib++;
								}
								break;
							case 4:
								id_question_contrib = 61;
								requete = "INSERT IGNORE INTO granddebat.users (id_user, code_postal, commune, type_commune, num_departement, sexe, age, formation, profession, taille_oragnisme, position_gj, statut, pseudonyme, origine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, data[7], Types.VARCHAR);
								if (data[9].length() > 7)
									data[9] = data[9].substring(1, 6);
								stat.setObject(2, data[9].replace("\"", ""), Types.VARCHAR);
								stat.setObject(3, null, Types.VARCHAR);
								stat.setObject(4, null, Types.VARCHAR);
								stat.setObject(5, null, Types.INTEGER);
								stat.setObject(6, null, Types.VARCHAR);
								stat.setObject(7, null, Types.INTEGER);						
								stat.setObject(8, null, Types.VARCHAR);
								stat.setObject(9, null, Types.VARCHAR);
								stat.setObject(10, null, Types.VARCHAR);
								stat.setObject(11, null, Types.VARCHAR);						
								stat.setObject(12, data[8], Types.VARCHAR);
								stat.setObject(13, null, Types.VARCHAR);						
								stat.setObject(14, "Grand Débat Contribution", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								
								for(x = 0; x<33; x++){
									if(data[x+11].length()>2){
										requete = "INSERT IGNORE INTO granddebat.contribution (id_contrib,FK_user_id,FK_theme_id,FK_question_contrib_id,contenu,titre,count_vote,count_vote_yes,count_vote_no,count_vote_mitige,origine,date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
										stat = connection.prepareStatement(requete);
										stat.setObject(1, id_question_contrib+"-"+data[0], Types.VARCHAR);
										stat.setObject(2, data[7], Types.VARCHAR);
										stat.setObject(3, i, Types.INTEGER);
										stat.setObject(4, id_question_contrib, Types.INTEGER);
										stat.setObject(5, data[x+11], Types.VARCHAR);
										stat.setObject(6, data[2], Types.VARCHAR);
										stat.setObject(7, null ,Types.INTEGER);
										stat.setObject(8, null,Types.INTEGER);
										stat.setObject(9, null,Types.INTEGER);
										stat.setObject(10, null,Types.INTEGER);
										stat.setObject(11, "Grand Débat", Types.VARCHAR);						
										stat.setObject(12, format.parse (data[2].replace("\"", "")), Types.TIMESTAMP);
										stat.executeUpdate();
										stat.close();
									}
									id_question_contrib++;
								}
								break;
							//insertion des Users GrandDebat
								
							
						   
							
							}
						
						}
					}
				}

				csvReader.close();
	
			}
			connection.close();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

