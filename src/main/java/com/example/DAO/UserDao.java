package com.example.DAO;


import jakarta.servlet.http.HttpSession;

import com.example.Entity.User;
import com.example.Excetions.PasswordWrongException;
import com.example.Excetions.UserAlreadyExistException;
import com.example.Excetions.UserNotFoundException;


public interface UserDao {
	User getUserById(int userId);
	User getUserByUserName(String userName);
	boolean validateUser(HttpSession session,User user) throws UserNotFoundException, PasswordWrongException;
	boolean addNewUser(User user) throws UserAlreadyExistException;
	void logOut(HttpSession session);
}
