package exercise03;

import exercise03.RandomArray;

public class WordRunnableApp {
	
public static void main(String[] args) {
		
		// create objects of runnable
		Runnable statement = new RandomArray();
		Thread statementThread = new Thread(statement);
		statementThread.setName("Thread-1");
		
		// Execute thread
		statementThread.start();


	}

}
