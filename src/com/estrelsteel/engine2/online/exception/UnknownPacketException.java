package com.estrelsteel.engine2.online.exception;

@SuppressWarnings("serial")
public class UnknownPacketException extends OnlineException {
	public UnknownPacketException(String packet) {
		super(packet);
	}
}
