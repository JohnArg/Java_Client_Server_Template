package java_templates.networking.client.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import java_templates.networking.client.utils.ClientUtils;

public class ClientApp {

	public static void main(String[] args) {
		int server_port;
		String server_ip;
		
		try(FileInputStream config = new FileInputStream("resources/connection.properties")){
			Properties props = new Properties();
			props.load(config);
			server_port = Integer.parseInt(props.getProperty("server_port"));
			server_ip = props.getProperty("server_ip");
			ClientUtils client = new ClientUtils(server_ip, server_port);
			client.startClient();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
