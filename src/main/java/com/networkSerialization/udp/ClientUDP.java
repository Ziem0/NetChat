package com.networkSerialization.udp;

import java.io.IOException;
import java.net.*;

//is meant to send/receive Object
public class ClientUDP {

	DatagramSocket socket;
	InetAddress address;

	public ClientUDP() throws SocketException, UnknownHostException {
		this.socket = new DatagramSocket();
		this.address = InetAddress.getByName("localhost");
	}

	public void start() throws IOException {
		//send section
		String message = "hello, this is client!";
		byte[] buf = message.getBytes();

//		MessageUdp messageUdp = new MessageUdp("hey! this is message object!");
//		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//		objectOutputStream.writeObject(messageUdp);

		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		socket.send(packet);

		//receive section
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);

		String receivedM = new String(packet.getData(), 0, packet.getLength());
		System.out.println(receivedM);

		socket.close();
	}


	public static void main(String[] args) throws IOException {
		ClientUDP clientUDP = new ClientUDP();
		clientUDP.start();
	}
}
