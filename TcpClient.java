import java.net.Socket;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class TcpClient {
	public static void main(String argv[]) throws Exception {
		String sentence; 
		String modifiedSentence; 
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
		Socket clientSocket = new Socket("localhost", 6789); 
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());	
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		System.out.print("message: ");
		sentence = inFromUser.readLine(); 
		outToServer.writeBytes(sentence + '\n'); 
		modifiedSentence = inFromServer.readLine(); 
		System.out.println("from server: " + modifiedSentence); 
		clientSocket.close();
	} 
} 