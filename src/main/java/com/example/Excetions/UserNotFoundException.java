package com.example.Excetions;

public class UserNotFoundException extends Exception{
	UserNotFoundException(){
		super();
	}
	public UserNotFoundException(String message){
		super(message);
	}
}