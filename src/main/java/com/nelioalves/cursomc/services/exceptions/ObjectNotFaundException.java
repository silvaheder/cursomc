package com.nelioalves.cursomc.services.exceptions;

public class ObjectNotFaundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFaundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFaundException(String msg , Throwable cause) {
		super(msg);
	}
}
