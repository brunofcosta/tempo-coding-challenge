package com.tempo.challenge.service.exception;

/**
 * @author Bruno
 *
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7161620179110352808L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
