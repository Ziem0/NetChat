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

		//streamy powinny byc w try()
		//write to client
		ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
		// read from client
		ObjectInputStream in = new ObjectInputStream(client.getInputStream());

		System.out.println("Connection established");

		while (true) {
			if (in.available() > 0) {
				if (in.read() == 2) {
					Message input = (Message) in.readObject();
					System.out.println(input);
				}
			}

			if (stdin.ready()) {
				output.reset();
				output.write(2);
				Message message = new Message(stdin.readLine(), name);
				output.writeObject(message);
			} else {
				output.write(1);
			}
		}

	}


}
