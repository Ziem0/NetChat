package com.networkSerialization.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//is meant to send/receive Object
public class ServerUDP {

	DatagramSocket socket;

	public ServerUDP() throws SocketException {
		this.socket = new DatagramSocket(4445);
	}

	public void start() throws IOException {
		byte[] buf = new byte[256];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);

		String message = new String(packet.getData(), 0, packet.getLength());
		System.out.println(message);

		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		packet = new DatagramPacket(buf, buf.length, address, port);
		socket.send(packet);

		socket.close();
	}

	public static void main(String[] args) throws IOException {
		ServerUDP serverUDP = new ServerUDP();
		serverUDP.start();
	}
}
