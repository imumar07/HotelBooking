package com.example.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.example.Entity.User;
import com.example.Excetions.*;


@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public User getUserById(int userId) {
		String query="Select * from user where user_id="+userId+";";
		List<Map<String,Object>> rows=jdbcTemplate.queryForList(query);
		User userTest=new User();
		for(Map<String,Object> row:rows) {
			userTest.setUserId(((Integer) row.get("user_id")).intValue());
			userTest.setEmail((String) (row.get("email")));
			userTest.setPassword((String) row.get("password"));
			userTest.setUsername((String) row.get("username"));
			userTest.setUserType((String) row.get("user_type"));
		}
		return userTest;
		
	}
	@Override
	public User getUserByUserName(String userName) {
		String query="Select * from user where username='"+userName+"';";
		List<Map<String,Object>> rows=jdbcTemplate.queryForList(query);
		User userTest=new User();
		for(Map<String,Object> row:rows) {
			userTest.setUserId(((Integer) row.get("user_id")).intValue());
			userTest.setEmail((String) (row.get("email")));
			userTest.setPassword((String) row.get("password"));
			userTest.setUsername((String) row.get("username"));
			userTest.setUserType((String) row.get("user_type"));
			userTest.setPhoneNumber((String) row.get("phone_number"));
		}
		return userTest;
	}
	@Override
	public boolean validateUser(HttpSession session,User user)throws UserNotFoundException, PasswordWrongException {
		String hotelQuery="select DISTINCT  location,hotel_name from hotel;";
		List<Map<String,Object>> hotelsLocation=jdbcTemplate.queryForList(hotelQuery);
		ArrayList<String> locations=new ArrayList<>(),hotels=new ArrayList<>();
		for(Map<String,Object> location:hotelsLocation) {
			locations.add((String) location.get("location"));
			hotels.add((String) location.get("hotel_name"));
		}
		session.setAttribute("locations", locations);
		session.setAttribute("hotels", hotels);
		String query="select username,password,user_type,user_id from user where username='"+user.getUsername()+"';";
		List<Map<String,Object>> data=jdbcTemplate.queryForList(query);
		int dataSize=data.size();;
		if(dataSize==1) {
			if((data.get(0).get("password")).equals(user.getPassword())) {
				session.setAttribute("userId",data.get(0).get("user_id"));
				if((data.get(0)).get("user_type").equals("User")) {
					return true;
				}else {
					return false;
				}
			}
			else {
				throw new PasswordWrongException();
			}
		}
		else {
			throw new UserNotFoundException("User does not exist");
		}
	}
	@Override
	public boolean addNewUser(User user) throws UserAlreadyExistException {
		String query="select count(*) from user where username=?;";
		int count=jdbcTemplate.queryForObject(query,Integer.class,user.getUsername());
		if(count>0) {
			throw new UserAlreadyExistException();
		}else {
			String insertQuery="Insert into user(username,password,email,user_type,name,phone_number) values(?,?,?,?,?,?);";
			int result=jdbcTemplate.update(insertQuery,user.getUsername(),user.getPassword(),user.getEmail(),user.getUserType(),user.getName(),user.getPhoneNumber());
			if(result==1) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void logOut(HttpSession session) {
		session.invalidate();
		
		
	}
}
