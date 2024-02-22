package com.example.DAO;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Entity.Hotel;
import com.example.Excetions.HotelAlreadyExistException;
import com.example.Excetions.NullHotelLocationException;
import com.example.Excetions.NullHotelNameException;
import com.example.Excetions.UserIdNeededException;

import jakarta.servlet.http.HttpSession;

@Repository
public class HotelDaoImpl implements HotelDao{
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Hotel getHotelById(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getHotelByName(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String addHotelToUser(HttpSession session, String hotelName, String location) throws NullHotelNameException, NullHotelLocationException, HotelAlreadyExistException, UserIdNeededException {
		Integer userId=(Integer) session.getAttribute("userId");
		System.out.println(hotelName+" "+location);
		if(userId==null) {
			throw new UserIdNeededException("Please Login Again");
		}
		if(hotelName.equals("")) {
			throw new NullHotelNameException("Hotel Name Can't be null/empty");
		}else if(location.equals("")) {
			throw new NullHotelLocationException("Hotel Location can't be null/empty");
		}else {
			String hotelExistQuery="select hotel_id,hotel_name,owner_id from hotel where hotel_name LIKE '%"+hotelName+"%' ;";
			List<Map<String,Object>> data=jdbcTemplate.queryForList(hotelExistQuery);
			for(Map<String,Object> hotel:data) {
				if((hotel.get("hotel_name")).equals(hotelName)&& userId==(hotel.get("owner_id"))) {
					throw new HotelAlreadyExistException("Hotel Already Exist with this name as yours");
				}
			}
			String query="Insert into hotel(owner_id,hotel_name,location) Values(?,?,?);";
			int i=jdbcTemplate.update(query,userId,hotelName,location);
			if(i>=0) {
				return "Hotel Added successfully";
			}
			return "error";
		}
		
	}



}
