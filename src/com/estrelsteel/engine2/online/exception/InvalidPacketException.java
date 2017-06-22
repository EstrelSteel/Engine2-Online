package com.estrelsteel.engine2.online.exception;

@SuppressWarnings("serial")
public class InvalidPacketException extends OnlineException {
	public InvalidPacketException(String packet) {
		super(packet);
	}
}
