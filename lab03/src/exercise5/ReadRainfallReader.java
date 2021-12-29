package exercise5;

import java.io.FileReader;
import java.io.Reader;

public class ReadRainfallReader {
	
	public static void main (String []args) 
	{ 
	
		String file = "dataDailyRainfall.txt";
		char[]array = new char[500];
		
		try {
			Reader r = new FileReader(file);
			System.out.println("Reading from file " + file + "\n");
			
			r.read(array);
			System.out.println(array);
			
			
			r.close();
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
	}

}
