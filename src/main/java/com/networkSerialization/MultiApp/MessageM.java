package com.networkSerialization.MultiApp;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageM implements Serializable {

	private String content;
	private String name;
	private LocalDateTime dateTime;

	public MessageM(String content, String name) {
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

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return String.format("[%s %s] says: %5s", dateTime, name, content);
	}

}




