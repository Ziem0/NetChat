package com.networkSerialization;

import java.io.*;
import java.net.Socket;

public abstract class Chatter {

	String name;
	BufferedReader stdin;

	public Chatter(String name) {
		this.name = name;
		this.stdin = new BufferedReader(new InputStreamReader(System.in));
	}

	void chat(Socket client) throws IOException, ClassNotFoundException {

		//write to client
		ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
		// read from client
		ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

		System.out.println("Connection established");

		while (true) {
			if (ois.available() > 0) {
				if (ois.read() == 2) {
					Message input = (Message) ois.readObject();
					System.out.println(input);
				}
			}

			if (stdin.ready()) {
				oos.reset();
				oos.write(2);
				Message message = new Message(stdin.readLine(), name);
				oos.writeObject(message);
			} else {
				oos.write(1);
			}
		}

	}


}
