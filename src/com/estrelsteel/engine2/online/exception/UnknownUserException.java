package com.estrelsteel.engine2.online.exception;

@SuppressWarnings("serial")
public class UnknownUserException extends OnlineException {

	public UnknownUserException(String packet) {
		super(packet);
	}

}
