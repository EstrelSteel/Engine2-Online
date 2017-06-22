package com.estrelsteel.engine2.online.exception;

@SuppressWarnings("serial")
public class OnlineException extends Exception {
	public OnlineException(String packet) {
		super(packet);
	}
}
