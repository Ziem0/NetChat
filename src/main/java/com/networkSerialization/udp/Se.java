package com.networkSerialization.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Se extends Thread {

	private DatagramSocket socket;
	private byte[] buf = new byte[256];

	public Se() throws SocketException {
		//gives info about port as it's a server
		this.socket = new DatagramSocket(4445);
	}

	@Override
	public void run() {
		boolean isRunning = true;

		while (isRunning) {
			//packet is meant to receive and send a message
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				System.err.println("cant receive a packet");
			}
			//print received data
			String received = new String(packet.getData(), 0, packet.getLength());
			System.out.println("received from client: " + received);

			//get info about sender (address and port)
			//create new packet which is ready to send
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			System.out.println(port);
			packet = new DatagramPacket(buf, buf.length, address, port);

			if (received.equals("end")) {
				isRunning = false;
				continue;
			} else {

			}

			try {
				socket.send(packet);
			} catch (IOException e) {
				System.err.println("can't send a packet");
			}
		}
		socket.close();
	}


	public static void main(String[] args) throws SocketException {
		Se server = new Se();
		server.run();
	}
}
