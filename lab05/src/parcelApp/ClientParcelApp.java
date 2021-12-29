package parcelApp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import parcel.Parcel;

public class ClientParcelApp {
	
	public static void main(String args[]) 
	{
		System.out.println("Lauching CliantParcelApp program");
		
		Parcel parcel = new Parcel();
		parcel.setWeight(0.05);
		
		
		try 
		{
			Socket socket = new Socket(InetAddress.getLocalHost(), 4221);
			
			ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream());
			oos.writeObject(parcel);
			
			System.out.println("Sending " + parcel.getWeight() + " kg" );
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Parcel processedParcel = (Parcel)ois.readObject();
			
			System.out.println("Weight : " + processedParcel.getWeight() + "kg");
			System.out.print("Price : RM " );
			System.out.printf("%.2f", processedParcel.getPrice());
			
			ois.close();
			oos.close();
			socket.close();
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
	}

}
