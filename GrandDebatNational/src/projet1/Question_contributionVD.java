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

public class Question_contributionVD {
	

		public static void main(String[] args) {
			Connection connection;
			PreparedStatement stat;
			String requete,query;
			String path = null;

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				connection = DriverManager.getConnection("jdbc:mysql://localhost/granddebat?useSSL=false&serverTimezone=UTC","root","");



				//empty tables

				query ="delete from question_contribution where origine = ?";
				stat = connection.prepareStatement(query);
				stat.setObject(1, "Vrai Débat", Types.VARCHAR);
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
				int id_question_contrib = 79;
				for (int i = 0; i < 9; i++) {
					switch (i) {
					case 0:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-04_democratie-institutions-referendum-dinitiative-citoyenne_consultation.csv";
						break;
					case 1:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-04_economie-finances-travail-compte-public_consultation-6.csv";
						break;
					case 2:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-04_education-jeunesse-enseignement-superieur-recherche-et-innovation_consultation-7.csv";
						break;
					case 3:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-04_europe-affaires-etrangeres-outre-mer_consultation-4.csv";
						break;
					case 4:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-04_justice-police-armee_consultation-3.csv";
						break;
					case 5:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-04_sante-solidarite-handicap_consultation-5.csv";
						break;
					case 6:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-04_sport-culture_consultation-8.csv";
						break;
					case 7:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-06_transition-ecologique-solidaire-agriculture-alimentation_consultation-2.csv";
						break;
					case 8:
						path = "C:/ut3/ue_projet/vraiDebat/2019-03-06_expression-libre_consultation-9.csv";
						break;
					}
					
					
					
					switch (i) {
					case 0:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i+5, Types.INTEGER);
							stat.setObject(3, "Democratie ,Institutions", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
							
						
						break;
					case 1:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i+5, Types.INTEGER);
							stat.setObject(3, "Economie ,Finances,Travail,Compte public", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
							
						
						break;
					case 2:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i+5, Types.INTEGER);
							stat.setObject(3, "Education,Jeunesse,Enseignement Superieur", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
							
						
						break;
					case 3:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i, Types.INTEGER);
							stat.setObject(3, "Europe Affaire etrangers outre-mer ", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
							
						
						break;
					case 4:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i+5, Types.INTEGER);
							stat.setObject(3, "Justice, Police,armée", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
						
						break;
					case 5:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i+5, Types.INTEGER);
							stat.setObject(3, "Sante solidaire handicap", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
						
						break;
					case 6:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i+5, Types.INTEGER);
							stat.setObject(3, "Sport Culture", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
						
						break;
					case 7:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i+5, Types.INTEGER);
							stat.setObject(3, "transition ecologique solidaire,agriculture alimentation", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
						
						break;
					case 8:
						
							requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, id_question_contrib +i, Types.VARCHAR);
							stat.setObject(2, i+5, Types.INTEGER);
							stat.setObject(3, "expression libre", Types.VARCHAR);
							stat.setObject(4, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
						
						break;
					}
					
					
					
					
					
					/*j = 0;
					int k = 0;
					BufferedReader csvReader = new BufferedReader( new InputStreamReader(new FileInputStream(path),"UTF-8"));
					//CSVReader csvReader = new CSVReader(new BufferedReader( new InputStreamReader(new FileInputStream(path),"UTF-8")));
					
					String row;
					System.out.println(i);
					while ((row = csvReader.readLine()) != null) {

						k++;
						String[] data = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
						//remplir les classes
						if (data[0].compareTo("opinion") == 0){
							
							switch (i) {
							case 5:
								
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									if(data[3].length()>4000)
										stat.setObject(3, data[3], Types.VARCHAR);
									else
										stat.setObject(3, data[3], Types.VARCHAR);
									
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								
								break;
							case 6:
								for( x = 0; x<8; x++){
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									stat.setObject(3, data[3], Types.VARCHAR);
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								}
								break;
							case 7:
								for( x = 0; x<37; x++){
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									stat.setObject(3, data[3], Types.VARCHAR);
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								}
								break;
							case 8:
								for( x = 0; x<33; x++){
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									stat.setObject(3, data[3], Types.VARCHAR);
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								}
								break;
							case 9:
								for( x = 0; x<33; x++){
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									stat.setObject(3, data[3], Types.VARCHAR);
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								}
								break;
							case 10:
								for( x = 0; x<33; x++){
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									stat.setObject(3, data[3], Types.VARCHAR);
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								}
								break;
							case 11:
								for( x = 0; x<33; x++){
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									stat.setObject(3, data[3], Types.VARCHAR);
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								}
								break;
							case 12:
								for( x = 0; x<33; x++){
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									stat.setObject(3, data[3], Types.VARCHAR);
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								}
								break;
							case 13:
								for( x = 0; x<33; x++){
									requete = "INSERT IGNORE INTO granddebat.question_contribution(id_question_contribution,FK_theme_id,nom_question_contribution,origine) VALUES (?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, id_question_contrib, Types.VARCHAR);
									stat.setObject(2, i, Types.INTEGER);
									stat.setObject(3, data[3], Types.VARCHAR);
									stat.setObject(4, "Vrai Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_contrib++;
								}
								break;
							}
							
					}
						
					}

					csvReader.close();*/
		
				}
				connection.close();


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}


	
	
	


