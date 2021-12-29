package exercise3;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadDailyRainfall {
	
	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "dataMelakaTengahDailyRainfall.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			int data = 0;
			String date = "";
			int totalData = 0;
			int noOfRecords = 6;
			String station = "";
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				System.out.println( "Data Daily Rainfall for selected station");
				System.out.println("----------------------------");
				System.out.println( "Date " + "\t\t" + " Station " + "\t\t" + " Rainfall Data ");
				
				for(int i =0 ; i < 6; i++) {
				
				// Read data
				station = dis.readUTF();
				data = dis.readInt();
				date = dis.readUTF();
				System.out.println( date + "\t" + station + "\t\t" + data);
				
				// Calculate total data
				totalData += data;
				
				}
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate average daily rainfall
			double averageDailyRainfall = totalData / noOfRecords;
			String formattedAverage = String.format("%.1f", averageDailyRainfall);
			System.out.print("\nAverage daily rainfall for " + noOfRecords 
					+ " for Cheng (Taman Merdeka) : " + formattedAverage + "%");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}


}
