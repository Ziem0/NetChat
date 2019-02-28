package com.networkSerialization;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server extends Chatter {

	public Server(String name) {
		super(name);
	}

	public void start(int port) {

		while (true) {

			System.out.println("Server is waiting...");

			try (ServerSocket serverSocket = new ServerSocket(port);
			     Socket client = serverSocket.accept()){
				chat(client);
			} catch (Exception e) {
				if (e.getClass().equals(SocketException.class)) {
					System.err.println("Client disconnected");
				} else if (e.getClass().equals(ClassNotFoundException.class)) {
					System.err.println("Message unreadable");
				} else {
					System.err.println(e.getClass().getSimpleName() + " : " + e.getMessage());
					System.exit(1);
				}
			}
		}

//		System.out.println("Connection established");

//		InputStreamReader isr = new InputStreamReader(client.getInputStream());
//		BufferedReader br = new BufferedReader(isr);
//		String input = br.readLine();
//		System.out.println("server says: "+ input);

	}

}
