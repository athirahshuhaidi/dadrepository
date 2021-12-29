package exercise3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class WriteDailyRainfall {
	
public static void main(String[] args) {
		
		
		// 1. Declare output file 
		String outFile = "dataMelakaTengahDailyRainfall.txt";
		
		// Data station declaration
		String station = "Cheng (Taman Merdeka)";
		int data[] = {7, 1, 70, 44, 10, 0};
		String date[] = {"20/11/2021", "21/11/2021", "22/11/2021", "23/11/2021", "24/11/2021", "25/11/2021"};
		
		try {
			
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			
			// Process data
			for (int index = 0; index < data.length; index++) {
				
		 		// 3. Write data into data stream
				dos.writeUTF(station);
				dos.writeInt(data[index]);
				dos.writeUTF(date[index]);
				
				// 4. Flush for each writing
				dos.flush();
			}
			
			// 5. Close stream
			dos.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println(" End of program. Check out " + outFile); 
	}

}
