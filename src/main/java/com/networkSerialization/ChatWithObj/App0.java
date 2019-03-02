package com.networkSerialization.ChatWithObj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App0 {

	public static void main(String[] args) throws IOException {
		switch (getMode()) {
			case "s":
				new Serv0(getMode()).start();
				break;
			case "c":
				new Cli0(getMode()).start();
				break;
		}
	}


	private static String getMode() throws IOException {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}
}
