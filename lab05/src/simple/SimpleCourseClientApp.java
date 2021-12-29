package simple;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import course.Course;

public class SimpleCourseClientApp {
	
	public static void main (String args[]) 
	{
		System.out.println("Lauching SimpleCourseClientApp program");
		
		Course course = new Course();
		course.setCode("BITP3123");
		course.setEnName("Distributed Application Development");
		course.setMsName("Pembangunan Aplikasi Teragih");
	
		
		try 
		{
			Socket socket = new Socket(InetAddress.getLocalHost(),4227);
			
			ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream());
			oos.writeObject(course);
			
			System.out.println("Sending " + course.getCode() + ":  " + course.getEnName() + " to server-side application");
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Course processedCourse = (Course) ois.readObject();
			
			System.out.println("\nCourse Information for " + processedCourse.getCode());
			System.out.println("Name (En) : " + processedCourse.getEnName());
			System.out.println("Name (Ms) : " + processedCourse.getMsName());
			System.out.println("Credit Hour : " + processedCourse.getCreditHour());
			System.out.println("Graduate Code : " + processedCourse.getGraduateCode());
			System.out.println("Degree Code : " + processedCourse.getDegreeCode());
			
			ois.close();
			oos.close();
			socket.close();
		
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

}
