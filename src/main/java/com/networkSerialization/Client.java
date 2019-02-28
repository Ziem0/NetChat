package com.networkSerialization;

import java.net.Socket;
import java.net.SocketException;

public class Client extends Chatter {

	public Client(String name) {
		super(name);
	}

	public void start(String host, int port) {

		while (true) {

			try (Socket client = new Socket(host, port)){
				chat(client);
			} catch (Exception e) {
				if (e.getClass().equals(SocketException.class)) {
					System.err.println("Server disconnected");
					System.exit(0);
				} else if (e.getClass().equals(ClassNotFoundException.class)) {
					System.err.println("Message unreadable");
				} else {
					System.err.println(e.getClass().getSimpleName() + " : " + e.getMessage());
					System.exit(1);
				}
			}
		}

//		System.out.println("Connection established");

//		OutputStreamWriter osr = new OutputStreamWriter(client.getOutputStream());
//		osr.write("hello!");
//		osr.close();

	}

}
