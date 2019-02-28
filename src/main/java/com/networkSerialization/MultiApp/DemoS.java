package com.networkSerialization.MultiApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoS {
//	private ServerSocket serverSocket;
//	private Socket clientSocket;
//	private PrintWriter out;
//	private BufferedReader in;

	public void start(int port) throws IOException {

		try (ServerSocket serverSocket = new ServerSocket(port);
		     Socket clientSocket = serverSocket.accept();
		     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

			System.out.println("connection established");
			String greeting = in.readLine();
			if ("hello server".equals(greeting)) {
				out.println("hello client");
			} else {
				out.println("unrecognised greeting");
			}
		}

//		ServerSocket serverSocket = new ServerSocket(port);
//		Socket clientSocket = serverSocket.accept();
//		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

//		System.out.println("connection established");
//		String greeting = in.readLine();
//		if ("hello server".equals(greeting)) {
//			out.println("hello client");
//		} else {
//			out.println("unrecognised greeting");
//		}
	}

//	public void stop() throws IOException {
//		in.close();
//		out.close();
//		clientSocket.close();
//		serverSocket.close();
//	}
	public static void main(String[] args) throws IOException {
		DemoS server=new DemoS();
		server.start(6666);
//		server.stop();
	}
}