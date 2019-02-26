package com.networkSerialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) throws IOException {

		switch (args[0]) {
			case "server":
				new Server(getName()).start(9000);
				break;
			case "client":
				new Client(getName()).start("localhost", 9000);
				break;
		}
	}

	private static String getName() throws IOException {
		System.out.println("Please type your name:");
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

}
