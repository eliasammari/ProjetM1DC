/**
 * 
 */
package projet1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.text.SimpleDateFormat;

/**
 * @author tomhu
 *
 */
public class MainQCM {

	/**
	 * @param args
	 */
	
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

			/*query ="delete from question_qcm";
			stat = connection.prepareStatement(query);
			stat.execute();
			stat.close();
			query ="delete from reponses_qcm";
			stat = connection.prepareStatement(query);
			stat.execute();
			stat.close();
			query ="delete from users where origine = ?";
			stat = connection.prepareStatement(query);
			stat.setObject(1, "Grand Débat qcm", Types.VARCHAR);
			stat.execute();
			stat.close();*/
			

			int x1;
			int j = 0;
			int id_question_qcm = 0;
			int k;
			for (int i = 1; i < 5; i++) {
				switch (i) {
				case 1:
					path = "C:/ut3/ue_projet/grandDebat/QUESTIONNAIRE_LA_TRANSITION_ECOLOGIQUE.csv";
					break;
				case 2:
					path = "C:/ut3/ue_projet/grandDebat/QUESTIONNAIRE_LA_FISCALITE_ET_LES_DEPENSES_PUBLIQUES.csv";
					break;
				case 3:
					path = "C:/ut3/ue_projet/grandDebat/QUESTIONNAIRE_DEMOCRATIE_ET_CITOYENNETE.csv";
					break;
				case 4:
					path = "C:/ut3/ue_projet/grandDebat/QUESTIONNAIRE_ORGANISATION_DE_LETAT_ET_DES_SERVICES_PUBLICS.csv";
					break;
				}
				j = 0;
				k = 0;
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
							for(x1 = 0; x1<7; x1++){
								requete = "INSERT IGNORE INTO granddebat.question_qcm(id_question_qcm,FK_theme_id,nom_question_qcm,origine) VALUES (?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, id_question_qcm, Types.VARCHAR);
								stat.setObject(2, i, Types.INTEGER);
								stat.setObject(3, data[x1+7], Types.VARCHAR);
								stat.setObject(4, "Grand Débat", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								id_question_qcm++;
							}
							break;
						case 2:
							for(x1 = 0; x1<4; x1++){
								requete = "INSERT IGNORE INTO granddebat.question_qcm(id_question_qcm,FK_theme_id,nom_question_qcm,origine) VALUES (?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, id_question_qcm, Types.VARCHAR);
								stat.setObject(2, i, Types.INTEGER);
								stat.setObject(3, data[x1+7], Types.VARCHAR);
								stat.setObject(4, "Grand Débat", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								id_question_qcm++;
							}
							break;
						case 3:
							for(x1 = 0; x1<7; x1++){
								requete = "INSERT IGNORE INTO granddebat.question_qcm(id_question_qcm,FK_theme_id,nom_question_qcm,origine) VALUES (?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, id_question_qcm, Types.VARCHAR);
								stat.setObject(2, i, Types.INTEGER);
								stat.setObject(3, data[x1+7], Types.VARCHAR);
								stat.setObject(4, "Grand Débat", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								id_question_qcm++;
							}
							break;
						case 4:
							for(x1 = 0; x1<12; x1++){
								requete = "INSERT IGNORE INTO granddebat.question_qcm(id_question_qcm,FK_theme_id,nom_question_qcm,origine) VALUES (?, ?, ?, ?)";
								stat = connection.prepareStatement(requete);
								stat.setObject(1, id_question_qcm, Types.VARCHAR);
								stat.setObject(2, i, Types.INTEGER);
								stat.setObject(3, data[x1+7], Types.VARCHAR);
								stat.setObject(4, "Grand Débat", Types.VARCHAR);
								stat.executeUpdate();
								stat.close();
								id_question_qcm++;
							}
							break;
						}
						j++;
					}
					else{
						if (data[0].length()>300) {
							System.out.println(data[0]);
							System.out.println(k);
							System.out.println();
						}
						
						if (data.length > 6){
							requete = "INSERT IGNORE INTO granddebat.users (id_user, code_postal, commune, type_commune, num_departement, sexe, age, formation, profession, taille_oragnisme, position_gj, statut, pseudonyme, origine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							stat = connection.prepareStatement(requete);
							stat.setObject(1, data[4], Types.VARCHAR);
							if (data[6].length() > 7)
								data[6] = data[6].substring(1, 6);
							stat.setObject(2, data[6].replace("\"", ""), Types.VARCHAR);
							stat.setObject(3, null, Types.VARCHAR);
							stat.setObject(4, null, Types.VARCHAR);
							stat.setObject(5, null, Types.INTEGER);
							stat.setObject(6, null, Types.VARCHAR);
							stat.setObject(7, null, Types.INTEGER);						
							stat.setObject(8, null, Types.VARCHAR);
							stat.setObject(9, null, Types.VARCHAR);
							stat.setObject(10, null, Types.VARCHAR);
							stat.setObject(11, null, Types.VARCHAR);						
							stat.setObject(12, data[5], Types.VARCHAR);
							stat.setObject(13, null, Types.VARCHAR);						
							stat.setObject(14, "Grand Débat qcm", Types.VARCHAR);
							stat.executeUpdate();
							stat.close();
						}
						if (data.length > 6){
							id_question_qcm =0;
							switch (i) {
							case 1:
								id_question_qcm =0;
								for(x1 = 0; x1<7; x1++){
									requete = "INSERT IGNORE INTO granddebat.reponses_qcm(id_reponse,FK_user_id,reponse,FK_id_question_qcm,date,origine) VALUES (?, ?, ?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, data[0], Types.VARCHAR);
									stat.setObject(2, data[4], Types.VARCHAR);
									stat.setObject(3, data[x1+7], Types.VARCHAR);
									stat.setObject(4, id_question_qcm, Types.VARCHAR);
									stat.setObject(5,format.parse (data[2].replace("\"", "")), Types.TIMESTAMP);
									stat.setObject(6, "Grand Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_qcm++;
								}
								break;
								
							case 2:
								id_question_qcm =7;
								for(x1 = 0; x1<4; x1++){
									requete = "INSERT IGNORE INTO granddebat.reponses_qcm(id_reponse,FK_user_id,reponse,FK_id_question_qcm,date,origine) VALUES (?, ?, ?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, data[0], Types.VARCHAR);
									stat.setObject(2, data[4], Types.VARCHAR);
									stat.setObject(3, data[x1+7], Types.VARCHAR);
									stat.setObject(4, id_question_qcm, Types.VARCHAR);
									stat.setObject(5,format.parse (data[2].replace("\"", "")), Types.TIMESTAMP);
									stat.setObject(6, "Grand Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_qcm++;
								}
								break;
							case 3:
								id_question_qcm = 11;
								for(x1 = 0; x1<7; x1++){
									requete = "INSERT IGNORE INTO granddebat.reponses_qcm(id_reponse,FK_user_id,reponse,FK_id_question_qcm,date,origine) VALUES (?, ?, ?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, data[0], Types.VARCHAR);
									stat.setObject(2, data[4], Types.VARCHAR);
									stat.setObject(3, data[x1+7], Types.VARCHAR);
									stat.setObject(4, id_question_qcm, Types.VARCHAR);
									stat.setObject(5,format.parse (data[2].replace("\"", "")), Types.TIMESTAMP);
									stat.setObject(6, "Grand Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_qcm++;
								}
								break;
							case 4:
								id_question_qcm =18;
								for(x1 = 0; x1<12; x1++){
									requete = "INSERT IGNORE INTO granddebat.reponses_qcm(id_reponse,FK_user_id,reponse,FK_id_question_qcm,date,origine) VALUES (?, ?, ?, ?, ?, ?)";
									stat = connection.prepareStatement(requete);
									stat.setObject(1, data[0], Types.VARCHAR);
									stat.setObject(2, data[4], Types.VARCHAR);
									stat.setObject(3, data[x1+7], Types.VARCHAR);
									stat.setObject(4, id_question_qcm, Types.VARCHAR);
									stat.setObject(5,format.parse (data[2].replace("\"", "")), Types.TIMESTAMP);
									stat.setObject(6, "Grand Débat", Types.VARCHAR);
									stat.executeUpdate();
									stat.close();
									id_question_qcm++;
								}
								break;
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
