package com.networkSerialization.MultiApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMulti extends ChatterM {

	public ServerMulti(String name) {
		super(name);
	}

	public void start() throws IOException {

		System.out.println("server is waiting...");

		try (ServerSocket server = new ServerSocket(9000);
		     Socket client = server.accept();
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
