package com.estrelsteel.engine2.online;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.estrelsteel.engine2.online.exception.OnlineException;
import com.estrelsteel.engine2.online.users.Users;

public class Server {
	private Users users;
	private DatagramSocket socket;
	private int port;
	private String msg;
	private OnlineInfo info;
	@SuppressWarnings("rawtypes")
	private ArrayList request;
	private boolean running;
	
	@SuppressWarnings("rawtypes")
	public Server(int port) {
		this.port = port;
		this.info = new OnlineInfo();
		this.users = new Users(info);
		this.request = new ArrayList();
		try {
			this.socket = new DatagramSocket(port);
		} 
		catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public int getPort() {
		return port;
	}
	
	public OnlineInfo getOnlineInfo() {
		return info;
	}
	
	public Users getUsers() {
		return users;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getRequest() {
		return request;
	}
	
	public synchronized void run() {
		running = true;
		while(running) {
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try {
				socket.receive(packet);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			msg = new String(packet.getData());
			try {
				info.getPacket(msg).execute(this, packet);
			}
			catch(OnlineException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendToAll(byte[] data) {
		for(int i = 0; i < users.size(); i++) {
			try {
				sendData(data, InetAddress.getByName(users.get(i).getIP()), Integer.parseInt(users.get(i).getPort()));
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
			catch(UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendData(byte[] data, InetAddress ipAddress, int port) {
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
		try {
			socket.send(packet);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setOnlineInfo(OnlineInfo info) {
		this.info = info;
	}
	
	@SuppressWarnings("rawtypes")
	public void setRequest(ArrayList request) {
		this.request = request;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
}
