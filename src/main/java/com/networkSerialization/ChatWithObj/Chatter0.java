package com.networkSerialization.ChatWithObj;

import java.io.*;
import java.net.Socket;

public abstract class Chatter0 {

	String name;
	BufferedReader br;

	public Chatter0(String name) {
		this.name = name;
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void chat(Socket client) throws IOException, ClassNotFoundException {

		try (
		     ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			 ObjectInputStream in = new ObjectInputStream(client.getInputStream())) {

			while (true) {
				if (in.available() > 0) {
					if (in.read() == 2) {
						Message0 msg = (Message0) in.readObject();
						System.out.println(msg);
					}
				}

				if (br.ready()) {
					out.reset();
					out.write(2);
					out.writeObject(new Message0(name, br.readLine()));
				} else {
					out.write(1);
				}
			}

		}


	}
}
