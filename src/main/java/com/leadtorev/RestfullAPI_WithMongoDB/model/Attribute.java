package com.leadtorev.RestfullAPI_WithMongoDB.model;

public class Attribute {

	 private String key;
	 private String value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Attribute(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Attribute() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Attribute [key=" + key + ", value=" + value + "]";
	}
	 
	 
}
