package com.networkSerialization.ChatWithObj;

import java.io.IOException;
import java.net.Socket;

public class Cli0 extends Chatter0 {

	public Cli0(String name) {
		super(name);
	}

	public void start() throws IOException {

		try (Socket client = new Socket("localhost", 9000)) {

			System.out.println("Connection established");

			chat(client);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
