package com.estrelsteel.engine2.online.packet;

import java.net.DatagramPacket;

import com.estrelsteel.engine2.online.Client;
import com.estrelsteel.engine2.online.Server;
import com.estrelsteel.engine2.online.exception.OnlineException;

public interface Packet {
	public PacketID getID();
	public Server execute(Server server, DatagramPacket packet) throws OnlineException;
	public Client execute(Client client, DatagramPacket packet) throws OnlineException;
}
