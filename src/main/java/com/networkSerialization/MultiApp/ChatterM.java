package com.networkSerialization.MultiApp;

import java.io.*;
import java.net.Socket;

public abstract class ChatterM {

	String name;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public ChatterM(String name) {
		this.name = name;
	}

	public void chat(Socket client) throws IOException {



	}
}
