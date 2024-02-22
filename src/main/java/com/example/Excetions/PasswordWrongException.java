package com.example.Excetions;

public class PasswordWrongException extends Exception{
	public PasswordWrongException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public PasswordWrongException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public PasswordWrongException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public PasswordWrongException(){
		super();
	}
	public PasswordWrongException(String message){
		super(message);
	}
}