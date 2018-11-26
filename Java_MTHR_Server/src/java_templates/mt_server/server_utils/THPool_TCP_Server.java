package java_templates.mt_server.server_utils;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class THPool_TCP_Server extends TCPServer {
	private ExecutorService threadPool;

	public THPool_TCP_Server(int port, int pool_size) {
		super(port);
		this.threadPool = Executors.newFixedThreadPool(pool_size);
	}

	@Override
	void handleRequest(Socket clientSock) {
		this.threadPool.execute(new Echoer(clientSock));
	}

}
