package com.estrelsteel.engine2.online.users;

import java.net.DatagramPacket;

import com.estrelsteel.engine2.online.OnlineInfo;

public class UserData {
	private String ip;
	private String port;
	private String username;
	
	public UserData(DatagramPacket packet) {
		String[] args = OnlineInfo.seperatePacket(new String(packet.getData()));
		this.username = args[1].trim();
		this.ip = args[2].trim();
		this.port = args[3].trim();
	}
	
	public UserData(String ip, String port, String username) {
		this.ip = ip;
		this.port = port;
		this.username = username;
	}
	
	public String getIP() {
		return ip;
	}
	
	public String getPort() {
		return port;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setIP(String ip) {
		this.ip = ip;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
