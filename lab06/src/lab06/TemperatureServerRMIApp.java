package lab06;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;
import ftmk.rmi.sensor.manager.TemperatureSensorManager;

public class TemperatureServerRMIApp {
	
public static void main(String[] args) {
		
		
		try {
			
			// Create interface object
			TemperatureSensor sensorAyerKeroh = new TemperatureSensorManager();
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Register interface object as remote object
			rmiRegistry.rebind("SensorAyerKeroh", sensorAyerKeroh);
			
			System.out.println("SensorAyerKeroh is successfully registered");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
