package com.cms.model;

import java.sql.Timestamp;

public class Image {
	
	private long id;
	private String name;
	private Timestamp timestamp;
	
	public Image() {
	}
	public Image(String name, Timestamp timestamp) {
		this.name=name;
		this.timestamp=timestamp;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", timestamp=" + timestamp + "]";
	}

}
