package simple;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import course.Course;
import course.CourseManager;

public class SimpleCourseServerApp {
	
	public static void main(String[] args) 
	{
		CourseManager courseManager = new CourseManager();
		
		System.out.println("Starting SimpleCourseServerApp");
		
		try 
		{
			int portNo = 4227;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			while(true) 
			{
				Socket clientSocket = serverSocket.accept();
				
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				Course course = (Course)ois.readObject();
				System.out.println("Processing object from client " + course.getCode());
				course = courseManager.createCourse(course);
				
				ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
				oos.writeObject(course);
				
				ois.close();
				oos.close();
			}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		
		}
	}

}
