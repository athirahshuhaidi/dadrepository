package exercise02;

import java.util.Arrays;
import java.util.Random;

public class WordRunnable implements Runnable {
	
	String[] word= {"It", "is", "recommended", "to", "use", "Calendar", "class"};
	
		public void printWord(String currentThread) {
			
		//number of repetition
		int repeat= 10;
		
		//get the size of array
		int dataSize = word.length;
		
		// new size for new array
		int newSize = dataSize*repeat;
		
		//new array to store the element
		String[] result = new String[newSize];
		
			String text = "";
			for(int i=0; i<repeat; i ++) {
				result[i] = word[i%dataSize];
				text = text + " "+ result[i];
				System.out.println(currentThread + "->"+ text);
				
			}
			
		}


	
	// Is the override method from interface Runnable
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		//Get current thread
		Thread currentThread = Thread.currentThread();
				
		//Execute task
		printWord(currentThread.getName());
	 
		
	}

}
