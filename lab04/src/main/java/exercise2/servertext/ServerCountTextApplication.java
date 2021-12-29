package exercise2.servertext;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCountTextApplication {
	
public static void main(String[] args) 
	
	{
			
		// Launch the server frame
		ServerCountTextFrame serverFrame = new ServerCountTextFrame();
		serverFrame.setVisible(true);
		
		try {
			
			// Bind ServerSocket to a port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);

			TextGenerator dateGenerator = new TextGenerator();

			// Counter to keep track the number of requested connection
			int totalRequest = 0;

			// Server need to be alive forever
			while (true) {

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();

				// Get current name
				int name = dateGenerator.countWordsUsingSplit();


				// Create stream to write data on the network
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

				// Send current date back to the client
				String text = Integer.toString(name);
				outputStream.writeBytes(text);

				// Close the socket
				clientSocket.close();


				// Update the request status
				serverFrame.updateRequestStatus("Data sent to the client: " + name);
				serverFrame.updateRequestStatus("Accepted connection from the client. " + "Total request =" + ++totalRequest);
			}
			
		} catch (Exception exception) {

			System.out.println("Durian Tunggal, we got problem.");
			exception.printStackTrace();

		}
	}

}
