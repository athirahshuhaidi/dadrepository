package exercise4;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadByteDailyRainfall {
	
	public static void main(String[] args) 
	{

		// 1. Declare output file 
		String fileSgDuyong = "byteDataSgDuyong.txt";
		String fileKlebangBesar ="byteDataKlebangBesar.txt";
		System.out.println("Reading data from " + fileSgDuyong +" and " + fileKlebangBesar + "\n");

		try 
		{

			// 2. Create stream to read data			
				System.out.println("6 Days Of Data Rainfall From Selected Station\n");
				
				DataInputStream dis = new DataInputStream(new FileInputStream(fileSgDuyong));
				DataInputStream dis2 = new DataInputStream(new FileInputStream(fileKlebangBesar));
				
				
				String station_id = "";
				double data = 0;
				double totaldata = 0;
				String station = "";
				
				//Display station ID 1
				station_id = dis.readUTF();
				System.out.println("Station ID : " + station_id + "\n");
				System.out.println("Day\t\t" + "Districts\t\t\t" + "Rainfall Data");
				System.out.println("_____________________________________________________");
				
				
				// 3. Process data until end-of-file
				while(dis.available() > 0)
				{
					for (int day = 1; day < 7; day++) 
					{
						// Read data
						station = dis.readUTF();
						data = dis.readDouble();
						System.out.println("Day " + day + "\t\t" + station + "\t" +data );
						
						// Calculate total data
						totaldata+=data;
						
					}
					
					double average = 0;
					int noOfDay = 6;
					average = totaldata/noOfDay;
					
					// Calculate average daily rainfall
					String formattedAverage = String.format("%.1f", average);
					System.out.println("\nAvarage of selected station is " + formattedAverage + "%\n" );
					
	
				}
				
				//Display station ID 2
				station_id = dis2.readUTF();
				System.out.println("\nStation ID : " + station_id + "\n");
				System.out.println("Day\t\t" + "Districts\t\t\t" + "Rainfall Data");
				System.out.println("_____________________________________________________");
				
				
				// 3. Process data until end-of-file
				while(dis2.available() > 0) {
					
					
					
					for(int i = 1; i < 7; i++) {
						// Read data
						station = dis2.readUTF();
						data = dis2.readDouble();
						System.out.println("Day " + i + "\t" + station + "\t" + data );
						
						// Calculate total data
						totaldata +=data;
					
					}
					
					double average2 = 0;
					int noOfDay = 6;
					average2 = totaldata/noOfDay;
					
					// Calculate average daily rainfall
					String formattedAverage = String.format("%.1f", average2);
					System.out.println("\nAvarage of selected station is " + formattedAverage + "%" );
				}
				
				// 4. Close stream
				dis.close();
				dis2.close();
			
		}catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");

	
	}

}
