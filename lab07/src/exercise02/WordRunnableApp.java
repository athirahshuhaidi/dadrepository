package exercise02;

public class WordRunnableApp {
	
	public static void main(String[] args)
	{
		
		Runnable arr1 = new WordRunnable();	
		Thread wordThread = new Thread(arr1);
		wordThread.setName("text");
		
		Runnable statement = new RandomArray();
		Thread statementThread = new Thread(statement);
		statementThread.setName("word1/word2");
	
		
		// Execute thread
		statementThread.start();
		wordThread.start();
	
		
	}


}
