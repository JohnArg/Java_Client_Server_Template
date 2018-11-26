package mt_server.main;

import mt_server.server_utils.TCPServer;
import mt_server.server_utils.WPR_TCP_Server;

public class ServerApp {

	public static void main(String[] args) {
		int port = 3000;
		TCPServer server = new WPR_TCP_Server(port);
		server.startServer();
	}

}
