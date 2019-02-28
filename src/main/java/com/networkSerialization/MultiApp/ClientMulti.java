package com.networkSerialization.MultiApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMulti extends ChatterM{

	public ClientMulti(String name) {
		super(name);
	}

	public void start() throws IOException {

		try (Socket client = new Socket("localhost", 9000);
		     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		     PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		     BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			System.out.println("Connection established");

			while (true) {
				if (in.ready()) {
					String msg = in.readLine();
					System.out.println(msg);
				}
				if (br.ready()) {
					out.println(br.readLine());
				}
			}

		}
	}
}
