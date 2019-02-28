package com.networkSerialization.MultiApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiApka {

	public static void main(String[] args) throws IOException {

		switch (getInput()) {
			case "s":
				new ServerMulti("ziemo").start();
				break;
			case "c":
				new ClientMulti("ania").start();
				break;
		}
	}

	private static String getInput() throws IOException {
		System.out.println("Type your name: ");
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}
}
