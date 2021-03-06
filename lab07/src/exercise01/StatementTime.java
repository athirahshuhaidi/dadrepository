package exercise01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StatementTime extends Thread {
	
	
	public void printTime (String currentThread) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			Date date = new Date();
			
			String currentDate = formatter.format(date);
			
			for (int counter = 0; counter < 10; counter++) {
				System.out.println(currentThread +" \t ["+counter+ "]: " + currentDate);
	;
			}
		}
	
	public void run()
	{
		
		// Get current thread
		Thread currentThread = Thread.currentThread();
				
		//Execute task
		printTime(currentThread.getName());

	}

}
