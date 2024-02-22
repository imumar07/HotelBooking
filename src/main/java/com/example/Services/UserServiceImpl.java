package com.example.Services;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.UserDao;
import com.example.Entity.User;
import com.example.Excetions.PasswordWrongException;
import com.example.Excetions.UserAlreadyExistException;
import com.example.Excetions.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDAO;

	@Override
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	public User getUserByUserName(String userName) {
		return userDAO.getUserByUserName(userName);
	}

	@Override
	public boolean validateUser(HttpSession session,User user)throws UserNotFoundException, PasswordWrongException {
			return userDAO.validateUser( session, user);
	}
	@Override
	public boolean addNewUser(User user) throws UserAlreadyExistException{
		return userDAO.addNewUser(user);
	}
	
	@Override
	public void logOut(HttpSession session) {
		userDAO.logOut(session);
	}
}
