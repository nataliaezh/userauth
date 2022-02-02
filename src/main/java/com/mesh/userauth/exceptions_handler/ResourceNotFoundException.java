package com.mesh.userauth.exceptions_handler;

public class ResourceNotFoundException  extends RuntimeException{
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
