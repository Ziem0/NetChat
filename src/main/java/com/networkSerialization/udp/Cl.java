package com.networkSerialization.udp;

import java.io.IOException;
import java.net.*;

public class Cl {

	private DatagramSocket socket;
	private InetAddress address;

	public Cl() throws SocketException, UnknownHostException {
		socket = new DatagramSocket();   // --> generate random port number!
		address = InetAddress.getByName("localhost");
	}

	public String sendEcho(String msg) throws IOException {
		//convert String to bytes
		byte[] buf = msg.getBytes();
		//create packet ready to send
		DatagramPacket packet
				= new DatagramPacket(buf, buf.length, address, 4445);
		socket.send(packet);

		//create new packet ready to get new info
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		String received = new String(packet.getData(), 0, packet.getLength());

		return received;
	}

	//because sendEcho method return value, so can't close socket beforehand
	public void close() {
		socket.close();
	}


	public static void main(String[] args) throws IOException {
		Cl client = new Cl();
		System.out.println(client.sendEcho("tu info od clienta!"));
		client.close();
	}
}
