import java.io.*;
import java.net.*;

public class TcpServer {
	public static void main(String[] argv) throws Exception  {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789); 
		while (true) {
			System.out.printf("listening at port %d\n", 6789);
			Socket connectionSocket = welcomeSocket.accept(); 
			BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
			clientSentence = inFromClient.readLine();
			System.out.printf("received message: %s\n", clientSentence);
			capitalizedSentence = clientSentence.toUpperCase()+'\n';
			outToClient.writeBytes(capitalizedSentence);
			System.out.printf("sent message: %s", capitalizedSentence);
		}
	}
}