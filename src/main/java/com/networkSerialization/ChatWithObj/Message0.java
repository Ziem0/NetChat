package com.networkSerialization.ChatWithObj;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message0 implements Serializable {

	String name;
	LocalDateTime dateTime;
	String content;

	public Message0(String name, String content) {
		this.name = name;
		this.dateTime = LocalDateTime.now();
		this.content = content;
	}


	@Override
	public String toString() {
		return String.format("[%s %s] writes: %s", dateTime, name, content);
	}
}
