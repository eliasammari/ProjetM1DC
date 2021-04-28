package projet1;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Scenario1 {

	
public static void main(String[] args) throws Exception {
		

		ReentrantLock r1 = new ReentrantLock();
		final ThreadRunner runner = new ThreadRunner(r1);
		
		Thread  t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					runner.firstThread("LT");
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
					runner.secondthread("LTSS", true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		runner.finished();

	}

}
