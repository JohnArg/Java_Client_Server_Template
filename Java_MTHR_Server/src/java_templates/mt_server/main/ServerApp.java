package java_templates.mt_server.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import java_templates.mt_server.server_utils.*;

public class ServerApp {

	public static void main(String[] args) {
		int server_port;
		int pool_size;

		try(FileInputStream config = new FileInputStream("resources/connection.properties")){
			Properties props = new Properties();
			props.load(config);
			server_port = Integer.parseInt(props.getProperty("server_port"));
			pool_size = Integer.parseInt(props.getProperty("pool_size"));
			//TCPServer server = new WPR_TCP_Server(server_port);
			TCPServer server = new THPool_TCP_Server(server_port, pool_size);
			server.startServer();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
