package projet1;

import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.text.SimpleDateFormat;
//import java.util.Date;

public class MainArgument {

	public MainArgument() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Connection connection;
		PreparedStatement stat;
		String requete,query;
		String path = null;
		//int nbVotes =0;
		//String id_contrib = "";
		//String id_arg = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//String dateString = format.format( new Date()   );

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/granddebat?useSSL=false&serverTimezone=UTC","root","");



			//empty tables
			query ="delete from argument";
			stat = connection.prepareStatement(query);
			stat.execute();
			/*query ="delete from vote_contribution";
			stat = connection.prepareStatement(query);
			stat.execute();
			query ="delete from contribution";
			stat = connection.prepareStatement(query);
			stat.execute();
			query = "delete from users";
			stat = connection.prepareStatement(query);
			stat.execute();
			query ="delete from theme";
			stat = connection.prepareStatement(query);
			stat.execute();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 1, Types.INTEGER);
			stat.setObject(2, "Transition écologique", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 2, Types.INTEGER);
			stat.setObject(2, "Impôts et dépenses publiques", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 3, Types.INTEGER);
			stat.setObject(2, "Démocratie et citoyenneté", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 4, Types.INTEGER);
			stat.setObject(2, "Organisation de l'Etat", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 5, Types.INTEGER);
			stat.setObject(2, "democratie-institutions-referendum-dinitiative-citoyenne_consultation", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 6, Types.INTEGER);
			stat.setObject(2, "economie-finances-travail-compte-public_consultation", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 7, Types.INTEGER);
			stat.setObject(2, "education-jeunesse-enseignement-superieur-recherche-et-innovation_consultation", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 8, Types.INTEGER);
			stat.setObject(2, "europe-affaires-etrangeres-outre-mer_consultation", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 9, Types.INTEGER);
			stat.setObject(2, "justice-police-armee_consultation", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 10, Types.INTEGER);
			stat.setObject(2, "sante-solidarite-handicap_consultation", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 11, Types.INTEGER);
			stat.setObject(2, "sport-culture_consultation", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 12, Types.INTEGER);
			stat.setObject(2, "transition-ecologique-solidaire-agriculture-alimentation_consultation", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			requete = "INSERT INTO granddebattest.theme (id_Theme,nom_Theme) VALUES (?, ?)";
			stat = connection.prepareStatement(requete);
			stat.setObject(1, 13, Types.INTEGER);
			stat.setObject(2, "Libre", Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			*/
			//int j = 0;
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
				BufferedReader csvReader = new BufferedReader( new InputStreamReader(new FileInputStream(path),"UTF-8"));
				String row;
				System.out.println(i);
				while ((row = csvReader.readLine()) != null) {
					String[] data = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
					//remplir les classes vote argument est vide
					/*if(nbVotes > 0){
						//mettre les bonnes valeurs de data
						requete = "INSERT IGNORE INTO granddebattest.vote_argument (id_vote_arg, id_argument, type, date) VALUES (?, ?, ?, ?)";
						stat = connection.prepareStatement(requete);
						stat.setObject(1, data[38], Types.VARCHAR);
						stat.setObject(2, id_arg, Types.VARCHAR);
						stat.setObject(3, data[40], Types.VARCHAR);
						if (data[41].compareTo("") == 0)
							stat.setObject(4, null, Types.TIMESTAMP);
						else
							stat.setObject(4, format.parse (data[41].replace("\"", "")), Types.TIMESTAMP);
						stat.executeUpdate();
						stat.close();
						nbVotes--;
					}*/
					if(!data[0].isEmpty()) {
						
						if (data[0].compareTo("argument") == 0){
							requete = "INSERT IGNORE INTO granddebat.users (id_user, code_postal, commune, type_commune, num_departement, sexe, age, formation, profession, taille_oragnisme, position_gj, statut, pseudonyme, origine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, data[26], Types.VARCHAR);
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
							
							
							/*requete = "INSERT IGNORE INTO granddebat.contribution (id_contrib,FK_user_id,FK_theme_id,FK_question_contrib_id,contenu,titre,count_vote,count_vote_yes,count_vote_no,count_vote_mitige,origine,date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, data[1], Types.VARCHAR);
							stat.setObject(2, data[2], Types.VARCHAR);
							stat.setObject(3, i+5, Types.INTEGER);
							stat.setObject(4, id_question_contrib+i, Types.INTEGER);
							stat.setObject(5, data[5], Types.VARCHAR);
							stat.setObject(6, data[4], Types.VARCHAR);
							stat.setObject(7, null,Types.INTEGER);
							stat.setObject(8,null,Types.INTEGER);
							stat.setObject(9, null,Types.INTEGER);
							stat.setObject(10, null,Types.INTEGER);
							
							stat.setObject(11, "Vrai Débat", Types.VARCHAR);
							stat.setObject(12, format.parse (data[6].replace("\"", "")), Types.TIMESTAMP);
							stat.executeUpdate();
							stat.close();*/
							

							requete = "INSERT IGNORE INTO granddebat.argument (id_argument, FK_id_contrib, FK_id_user, contenu, type, date, origine) VALUES (?, ?, ?, ?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, data[25], Types.VARCHAR);
							stat.setObject(2, data[23], Types.VARCHAR);
							stat.setObject(3, data[26], Types.VARCHAR);
							stat.setObject(4, data[28], Types.VARCHAR);
							stat.setObject(5, data[27], Types.VARCHAR);
							stat.setObject(6, format.parse (data[29].replace("\"", "")), Types.TIMESTAMP);
							stat.setObject(7, "Vrai Débat", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();

							/*if(Integer.parseInt(data[37]) > 0){
							nbVotes = Integer.parseInt(data[37]);
							id_arg = data[1].replace("\"", "");
						}*/
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

