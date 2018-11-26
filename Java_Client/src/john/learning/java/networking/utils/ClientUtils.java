package john.learning.java.networking.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientUtils {
	private int port;
	private String ip;
	
	public ClientUtils(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public void startClient() {
		try(Socket clientSocket = new Socket(ip, port)){
			clientSocket.setSoTimeout(5000);
			BufferedReader response = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter message = new PrintWriter(clientSocket.getOutputStream(), true);
			
			System.out.println("Start typing your text here. Press ENTER to send");
			String sendText;
			Scanner keyboard = new Scanner(System.in);
			while(true) {
				sendText = keyboard.nextLine();
				message.println(sendText);
				if(sendText.equals("exit")) {
					System.out.println("Client Shutdown ...");
					break;
				}
				System.out.println("Echo : " + response.readLine());
			}
			keyboard.close();
		}catch(SocketTimeoutException e) {
			System.out.println("Client Error - Socket timeout : " + e.getMessage());
		}catch (UnknownHostException e) {
			System.out.println("Client Error - Unknown host : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Client Error : " + e.getMessage());
		}
	}
}
