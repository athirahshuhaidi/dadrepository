package lab06;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

public class TemperatureClientRMIApp {
	
public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorAyerKeroh 
				= (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorAyerKeroh.getTemperature();
			
			System.out.println("Current temperature in Ayer Keroh is " 
					+ currentTemperature + " Celcius");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
