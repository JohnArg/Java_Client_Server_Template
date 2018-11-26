/*
 * This class starts a TCP server listening to the given port
 * Request handling is left abstract for the developer to chose
 * whether to use multithreading or not and how what to do after the connection.
 */
package mt_server.server_utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class TCPServer {
	private int port;
	
	public TCPServer(int port) {
		this.port = port;
	}
	
	public void startServer() {
		try(ServerSocket serverSock = new ServerSocket(port)){
			System.out.println("Server started at port : "+port);
			while(true) {
				Socket clientSock = serverSock.accept();
				handleRequest(clientSock);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	abstract void handleRequest(Socket clientSock);
	
}
