package com.networkSerialization.udp;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageUdp implements Serializable {

	String content;
	LocalDateTime localDateTime;

	public MessageUdp(String content) {
		this.content = content;
		this.localDateTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return String.format("[data : %s] message: %s ", localDateTime, content);
	}
}
