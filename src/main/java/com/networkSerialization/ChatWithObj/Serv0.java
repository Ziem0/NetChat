package com.networkSerialization.ChatWithObj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Serv0 extends Chatter0{

	public Serv0(String name) {
		super(name);
	}

	public void start() throws IOException {
		ServerSocket serverSocket = new ServerSocket(9000);

		ExecutorService pool = Executors.newFixedThreadPool(3);

		while (true) {
			Socket client = serverSocket.accept();

			Runnable r = () -> {
				System.out.println("Connection established");
				System.out.println(Thread.currentThread().getName());
				try {
					chat(client);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			};

			pool.submit(r);
		}





//		try (ServerSocket server = new ServerSocket(9000);
//		     Socket client = server.accept()) {

//			System.out.println("Connection established");
//
//			chat(client);

//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}





}
