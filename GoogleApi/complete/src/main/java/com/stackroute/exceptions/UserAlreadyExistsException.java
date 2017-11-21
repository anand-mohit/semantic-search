package com.stackroute.exceptions;

//Custom Exception
public class UserAlreadyExistsException extends Exception{
	
	public UserAlreadyExistsException(String message) {
        super(message);
    }
}
