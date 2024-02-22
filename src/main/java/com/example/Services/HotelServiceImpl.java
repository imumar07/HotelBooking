package com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.HotelDao;
import com.example.Entity.Hotel;
import com.example.Excetions.HotelAlreadyExistException;
import com.example.Excetions.NullHotelLocationException;
import com.example.Excetions.NullHotelNameException;
import com.example.Excetions.UserIdNeededException;

import jakarta.servlet.http.HttpSession;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDao hotelDaoImpl;
	
	@Override
	public Hotel getHotelById(int hotelId) {
		return hotelDaoImpl.getHotelById(hotelId); 
	} 

	@Override
	public Hotel getHotelByName(String hotelName) {
		return hotelDaoImpl.getHotelByName(hotelName); 
	}

	@Override
	public String addHotelToUser(HttpSession session, String hotelName, String location)throws NullHotelNameException, NullHotelLocationException, HotelAlreadyExistException, UserIdNeededException {
		return hotelDaoImpl.addHotelToUser(session, hotelName, location);
	}


}
