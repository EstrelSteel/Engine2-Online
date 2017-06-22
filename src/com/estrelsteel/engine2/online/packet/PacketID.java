package com.estrelsteel.engine2.online.packet;

public class PacketID {
	private String id;
	private String name;
	
	public PacketID(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
