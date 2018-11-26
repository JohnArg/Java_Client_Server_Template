/*
 * Used to run a TCP server with a Worker Per Request model. The task
 * is simply to echo what the client sent back to them.
 */
package java_templates.mt_server.server_utils;

import java.net.Socket;

public class WPR_TCP_Server extends TCPServer{

	public WPR_TCP_Server(int port) {
		super(port);
	}

	@Override
	void handleRequest(Socket clientSock) {
		Echoer echoer = new Echoer(clientSock);
		echoer.start();
	}

}
