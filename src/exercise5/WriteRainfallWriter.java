package exercise5;

import java.io.FileWriter;
import java.io.Writer;

public class WriteRainfallWriter {
	
public static void main(String[] args) {
		
	// 1. Declaration 
		String note = "dataDailyRainfall.txt";
		String district = "Melaka Tengah";
		String station_id1 = "Sg Duyong";
		String station_id2 = "Klebang besar";
		double data1[] = {11.0, 27.0, 11.0, 26.0, 41.0, 0.0};
		double data2[] = {9.0, 0.0, 31.0, 1.0, 25.0, 0.0};
		double totaldata1 = 0;
		double totaldata2 = 0;
		
		try {
			// 2. Create file writer to read data between this program and the target storage
			Writer w = new FileWriter(note);
			
			// Process data1
			w.write("\nStation id:\t" + 2223023 + "\n");
			w.write("Districts:\t" + district + "\n");
			w.write("Station Name:\t" + station_id1 + "\n");
			
			for(int i = 0; i < data1.length; i++) {
				
				// 3. Write data into data writer
				w.write("Day " + (i+1) + "\t" + data1[i] + "\n");
				totaldata1 += data1[i];
			
			}
			double average = 0;
			average = totaldata1 / 6;
			String formattedAverage = String.format("%.1f", average);
			w.write("\nAverage for selected startion is " + formattedAverage + "%" );
			
			// Process data2
			w.write("\nStation id:\t" + 2222003 + "\n");
			w.write("Districts:\t" + district + "\n");
			w.write("Station Name:\t" + station_id2 + "\n");
			
			for(int i = 0; i < data2.length; i++) {
				
				// 3. Write data into data writer
				w.write("Day " + (i+1) + "\t" + data2[i] +"\n");
				totaldata2 += data2[i];
			}
			double average2;
			average2 = totaldata2 / 6;
			String formattedAverage2 = String.format("%.1f", average2);
			w.write("\nAverage for selected startion is " + formattedAverage2 + "%" );
			
			
			// 4. Flush and close for each writing
			w.flush();
			w.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("The data has been succesfully created ! Checkout " + note);
	}

}
