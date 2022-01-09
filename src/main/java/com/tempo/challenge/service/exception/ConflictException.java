package com.tempo.challenge.service.exception;

/**
 * @author Bruno
 *
 */
public class ConflictException extends RuntimeException {

	private static final long serialVersionUID = 9108282193694334827L;

	public ConflictException(String msg) {
		super(msg);
	}

}
