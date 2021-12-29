package paymentApp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.Timestamp;
import java.util.Date;

import parcel.Parcel;
import payment.Payment;
import staff.Staff;

public class ClientPaymentApp {
	
	public static void main(String args[]) 
	{
		System.out.println("Lauching CliantPaymentApp program");
		
		Parcel parcel = new Parcel();
		parcel.setWeight(0.05);
		
		Payment payment = new Payment();
		payment.setPaymentID(1001);
		
		Date date = new Date();

		payment.setTransactionDate(date);
		
		String name ="Athirah Shuhaidi";
		payment.setRecordedBy(name);
		
		
		
		try 
		{
			Socket socket = new Socket(InetAddress.getLocalHost(), 4223);
			
			ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream());
			oos.writeObject(parcel);
			oos.writeObject(payment);
			
			System.out.println("Sending "+ payment.getPaymentID() + " to server-side application");
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Parcel processedParcel = (Parcel)ois.readObject();
			Payment processedPayment = (Payment) ois.readObject();
			
			 System.out.println("Payment Id: "+ processedPayment.getPaymentID());
			 System.out.println("Weight of Parcel: "+processedParcel.getWeight());
			 System.out.println("Recorded By:  " + processedPayment.getRecordedBy());
			 System.out.println("Transaction Date: "+processedPayment.getTransactionDate());
			
			ois.close();
			oos.close();
			socket.close();
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
	}

}
