package projet1;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Scenario5 {
	

	public static void main(String[] args) throws Exception {
		
		ReentrantLock r = new ReentrantLock();
		final ThreadRunner runner2 = new ThreadRunner(r);
		
		Thread  t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					runner2.thirdthread("");
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
					runner2.secondthread("sf", true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		Thread  t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					runner2.thirdthread("");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		//runner2.finished();

	}

}
