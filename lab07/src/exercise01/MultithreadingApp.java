package exercise01;

public class MultithreadingApp {
	
	public static void main(String[] args)
	{
		// Thread object equal to class StatementTime
		
		Thread objThread1 = new StatementTime();
		Thread objThread2 = new StatementTime();
		
		//create objects of thread with name
		Thread printerThread1 = new Thread(objThread1, "Thread-1");
		Thread printerThread2 = new Thread(objThread2);
		
		// Execute two objects of Thread
		printerThread1.start();
		printerThread2.start();
	}

}
