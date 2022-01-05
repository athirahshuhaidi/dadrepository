package exercise02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomArray implements Runnable {

	String[] word= {"It", "is", "recommended", "to", "use", "Calendar", "class"};
	
	public void randomArray(String currentThread)
	{
		 	List<String> list = Arrays.asList(word);
			Collections.shuffle(list);
			list.toArray(word);
			
			for(String element:word) {
				
				System.out.println(currentThread + "->"+element);
				
			}

	}
	
	// Is the override method from interface Runnable
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		//Get Thread
		Thread currentThread = Thread.currentThread();
		//Execute task
		randomArray(currentThread.getName());
		
	}
	
}
