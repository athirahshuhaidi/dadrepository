package exercise03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomArray implements Runnable {
	
	String[] word = {"It", "is", "recommended", "to", "use", "calendar", "class"};

	public void randomArray()
	{		
			//get the size of array
			int dataSize = word.length;
			
			// new size for new array
			int newSize = dataSize*10;
			
			//new array to store the element
			String[] result = new String[newSize];
			
			String text = "";
			for(int i=0; i< 10; i ++) {
				result[i] = word[i%dataSize];
				text = text + " "+ result[i];
				System.out.println(text);
			}
		

	}
	
	public void randomData(String currentThread) {
		try {
			
			String[] data = {"It", "is", "recommended", "to", "use", "calendar", "class"};
			
			List<String> list = Arrays.asList(data);
			Collections.shuffle(list);
			list.toArray(data);
			for(String element:data) {
							
			System.out.println(currentThread + "->"+element);
			
			//Suspend the current thread for 5 milliseconds
			Thread.sleep(5000);
							
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void run() {
		//Get current thread
		Thread currentThread = Thread.currentThread();
		
		//Execute task
		randomArray();
		randomData(currentThread.getName());
		
	}

}
