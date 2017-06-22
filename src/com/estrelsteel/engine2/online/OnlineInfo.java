package com.estrelsteel.engine2.online;

import java.util.ArrayList;

import com.estrelsteel.engine2.online.exception.UnknownPacketException;
import com.estrelsteel.engine2.online.packet.Packet;

public class OnlineInfo {
	private ArrayList<Packet> packets;
	private String split;
	
	public OnlineInfo() {
		packets = new ArrayList<Packet>();
		this.split = "~";
	}
	
	public String getSplit() {
		return split;
	}
	
	public ArrayList<Packet> getPackets() {
		return packets;
	}
	
	public static String getPacketID(String packet) {
		return seperatePacket(packet)[0];
	}
	
	public Packet getPacket(String packet) throws UnknownPacketException {
		for(Packet p : packets) {
			if(p != null && p.getID().getID().equals(getPacketID(packet))) {
				return p;
			}
		}
		throw new UnknownPacketException(packet);
	}
	
	public static String[] seperatePacket(String packet) {
		String[] args = packet.split("~");
		for(int i = 0; i < args.length; i++) {
			args[i] = args[i].trim();
		}
		return args;
	}
	
	public void setPackets(ArrayList<Packet> packets) {
		this.packets = packets;
	}
	
	public void setSplit(String split) {
		this.split = split;
	}
}
