package com.networkSerialization;

import java.io.*;
import java.time.LocalDateTime;

public class Message implements Serializable {

	private String content;
	private String name;
	private LocalDateTime dateTime;

	public Message(String content, String name) {
		this.content = content;
		this.name = name;
		this.dateTime = LocalDateTime.now();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return String.format("[name:%s date:%s]: %5s", name, dateTime, content);
	}



}
