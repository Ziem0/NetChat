package com.networkSerialization.MultiApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DemoC {
//	private Socket clientSocket;
//	private PrintWriter out;
//	private BufferedReader in;

	public String startConnection(String ip, int port, String msg) throws IOException {

		try (Socket clientSocket = new Socket(ip, port);
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

			System.out.println("connection established");

			out.println(msg);
			String resp = in.readLine();
			return resp;
		}

//		clientSocket = new Socket(ip, port);
//		out = new PrintWriter(clientSocket.getOutputStream(), true);
//		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

	}

//	public String sendMessage(String msg) throws IOException {
//		out.println(msg);
//		String resp = in.readLine();
//		return resp;
//	}

//	public void stopConnection() throws IOException {
//		in.close();
//		out.close();
//		clientSocket.close();
//	}

	public static void main(String[] args) throws IOException {
		DemoC client = new DemoC();
		System.out.println(client.startConnection("localhost", 6666, "hello server"));
//		System.out.println(client.sendMessage("hello server"));
//		client.stopConnection();
	}
}