package com.networkSerialization.ChatWithObj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serv0 extends Chatter0{

	public Serv0(String name) {
		super(name);
	}

	public void start() throws IOException {

		try (ServerSocket server = new ServerSocket(9000);
		     Socket client = server.accept()) {

			System.out.println("Connection established");

			chat(client);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
