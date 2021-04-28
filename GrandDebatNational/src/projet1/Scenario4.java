package projet1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Scenario4 {
	
public static void main(String[] args) throws Exception {
		
	
		Connection C1=DriverManager.getConnection("jdbc:mysql://localhost/granddebat?useSSL=false&serverTimezone=UTC","root","");
		C1.setAutoCommit(false);
		int x;
		ReentrantLock r2 = new ReentrantLock();
		ThreadRunner runner3 = new ThreadRunner(r2,C1);
		
		Thread  t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					runner3.forththread();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		Thread  t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					runner3.fivththread();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		if(runner3.commit_rollback()==0) {
			C1.rollback();
			System.out.println(" rollback");
		}else
		{
			C1.commit();
			System.out.println(" commit");
		}
		C1.close();
		
		/***
		 * 
		 * METTRE ICI LE COMMIT FINAL OU LE ROLLEBACK FINAL
		 */

	}
	

}
