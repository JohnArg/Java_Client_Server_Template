/*
 * Echoes back the text that the client sent and closes the socket
 */
package mt_server.server_utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
	private Socket socket;
	
	public Echoer(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader input;
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("Client connected");
			while(true) {
				String echoText = input.readLine();
				if(echoText.equals("exit")) {
					System.out.println("Client disconnected ...");
					break;
				}
				output.println(echoText);
			}
		} catch (IOException e) {
			System.out.println("Server Error : " + e.getMessage());
		}finally {
			try {
				socket.close();
			}catch (IOException e) {
				System.out.println("Server Close Socket Error : " + e.getMessage());
			}
		}
		
		
	}
}
