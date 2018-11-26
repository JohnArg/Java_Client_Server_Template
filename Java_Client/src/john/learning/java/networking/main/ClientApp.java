package john.learning.java.networking.main;

import john.learning.java.networking.utils.ClientUtils;

public class ClientApp {

	public static void main(String[] args) {
		ClientUtils client = new ClientUtils("localhost", 3000);
		client.startClient();
	}

}
