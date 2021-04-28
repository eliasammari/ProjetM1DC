package projet1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadRunner {
	

	private ReentrantLock lock ;
	private Connection connection;
	Statement stat;
	
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int count = 0;
    
    public ThreadRunner (ReentrantLock l,Connection C) throws SQLException {
    	this.lock = l;
    	this.connection = C;
    			
    }
	
    public ThreadRunner (ReentrantLock l) throws SQLException {
    	this.lock = l;
    			
    }
	

	/***
	 * REQUETE SCENARIO 1
	 */
	
	private void requete1(String s) {
		for (int i = 0; i < 2; i++) {
			count++;
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection;
			PreparedStatement stat;
			String query;
			
            connection = DriverManager.getConnection("jdbc:mysql://localhost/gd2?useSSL=false&serverTimezone=UTC","root","");
           
            connection.setAutoCommit(true);
            
            query ="update theme set nom_theme=? where id_theme=1";
            
            
			stat = connection.prepareStatement(query);
			stat.setObject(1, s, Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM theme");
			while(resultat.next()) {
                System.out.println(resultat.getString("id_theme")
                		   + " " + resultat.getString("nom_theme"));
			}
			resultat.close();
			statement.close();
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void requete2(String s, boolean b) {
		for (int i = 0; i < 2; i++) {
			count++;
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection;
			PreparedStatement stat;
			String query;
			
            connection = DriverManager.getConnection("jdbc:mysql://localhost/gd2?useSSL=false&serverTimezone=UTC","root","");
           
            connection.setAutoCommit(true);
            
            query ="update theme set nom_theme=? where id_theme=1";
            
            
			stat = connection.prepareStatement(query);
			stat.setObject(1, s, Types.VARCHAR);
			stat.executeUpdate();
			stat.close();
			
			if (b== true) {
				Statement statement = connection.createStatement();
				ResultSet resultat = statement.executeQuery("SELECT * FROM theme");
				while(resultat.next()) {
	                System.out.println(resultat.getString("id_theme")
	                		   + " " + resultat.getString("nom_theme"));
				}
				resultat.close();
				statement.close();
			}
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/***
	 * REQUETE SCENARIO 5
	 */
	
	private void requete3(String s) {
		for (int i = 0; i < 2; i++) {
			count++;
		}
		
		try {
			Connection connection;
			String query;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/gd2?useSSL=false&serverTimezone=UTC","root","");
            
           
			Statement statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM theme");
			while(resultat.next()) {
                System.out.println(resultat.getString("id_theme")
                		   + " " + resultat.getString("nom_theme"));
			}
			resultat.close();
			statement.close();
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/***
	 * REQUETE SCENARIO 4
	 */
	private int requete5() {
		for (int i = 0; i < 2; i++) {
			count++;
		}
		
		int q=0;
		try {
			
			/***
			 * METTRE REQUETE ICI
			 */
			
				stat = this.connection.createStatement();
				
				//La requete du 1er thread du scenario 4
				q=	stat.executeUpdate("Update contribution set count_vote_no=4 where count_vote_no!=0  ");
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return q;
	}
	
	private int requete6() {
		for (int i = 0; i < 2; i++) {
			count++;
		}
		int q=0;
		
		try {
			
			/***
			 * METTRE REQUETE ICI
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			stat = this.connection.createStatement();
			
			//La requete du 2e thread du scenario 4
			q= stat.executeUpdate("Update contribution set count_vote_yes=3 where count_vote_yes!=0  ");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return q;
	}
	
	public void firstThread(String s) throws InterruptedException {
		this.lock.lock();
		System.out.println("Début thread 1");
		try {
			requete1(s);
		}finally {
			this.lock.unlock();
		}
		System.out.println("fin thread 1");
	}
	
	public void secondthread(String s, boolean b) throws InterruptedException {
		//Thread.sleep(3);
		lock.lock();
		System.out.println("Début thread 2");
		try {
			requete2(s, false);
		}finally {
			lock.unlock();
		}
		System.out.println("fin thread 2");
	}
	
	public void thirdthread(String s) throws InterruptedException {
		//Thread.sleep(3);
		this.lock.lock();
		System.out.println("Début thread 3");
		try {
			requete3(s);
		}finally {
			this.lock.unlock();
		}
		System.out.println("fin thread 3");
	}
	
	public void forththread() throws InterruptedException {
		this.lock.lock();
		System.out.println("Début thread 4");
		try {
			 requete5();
		}finally {
			this.lock.unlock();
			System.out.println("fin thread 4");
		}
		
		
	}
	
	public void fivththread() throws InterruptedException {
		this.lock.lock();
		System.out.println("Début thread 5");
		try {
			 requete6();
		}finally {
			this.lock.unlock();
			System.out.println("fin thread 5");
		}
		
	}
	
	public int commit_rollback() {
		System.out.println("retour req5 "+requete5());
		System.out.println("retour req6 "+requete6());
		if(requete5()==0 || requete6()==0) {
			return 0;
			
		}else {
			return 1;
		}
	}
	
	
	public void finished() {
		System.out.println("Le thread t"+count/2+" a fini .");
	}

}
