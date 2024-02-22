package com.example.Services;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.example.Entity.User;
import com.example.Excetions.PasswordWrongException;
import com.example.Excetions.UserAlreadyExistException;
import com.example.Excetions.UserNotFoundException;

@Repository
public interface UserService {
	User getUserById(int userId);
	
	User getUserByUserName(String userName);
	
	boolean validateUser(HttpSession session,User user) throws UserNotFoundException, PasswordWrongException;
	
	boolean addNewUser(User user) throws UserAlreadyExistException;

	void logOut(HttpSession session);
}
