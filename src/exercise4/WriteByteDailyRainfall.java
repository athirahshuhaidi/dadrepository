package exercise4;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteByteDailyRainfall {
	
public static void main(String[] args) {
		
		String targetStorage1 = "byteDataSgDuyong.txt";
		String targetStorage2 = "byteDataKlebangBesar.txt";
		
		// 1. Declaration
		String station_id1 = "2223023";
		String station_id2 = "2222003";
		String district = "Melaka Tengah";
		double data1[] = {11.0, 27.0, 11.0, 26.0, 41.0, 0.0};
		double data2[] = {9.0, 0.0, 31.0, 1.0, 25.0, 0.0};


		try {

			// 2. Create stream to read data between this program and the target storage
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(targetStorage1));
			DataOutputStream dos2 = new DataOutputStream(new FileOutputStream(targetStorage2));
			
			dos.writeUTF(station_id1);
			dos2.writeUTF(station_id2);
			
			// Process data1
			for (int index = 0; index < data1.length; index++) {
							
				// 3. Write data into data stream
				dos.writeUTF(district + " (Sg Duyong) ");
				dos.writeDouble(data1[index]);
			
			}
			
			// Process data
			for (int index = 0; index < data2.length; index++) {
										
			// 3. Write data into data stream
			dos.writeUTF(district + " (Klebang Besar) ");
			dos.writeDouble(data2[index]);
						
			}
						
				// 4. Flush for each writing
				dos.flush();		
				// 5. Close stream
				dos.close();
						
		} catch (Exception ex) {
						
				ex.printStackTrace();
		}
					
		// Indicate end of program - Could be successful
		System.out.println(" End of program. Check out " + targetStorage1 + " and " + targetStorage2); 
		}


}
