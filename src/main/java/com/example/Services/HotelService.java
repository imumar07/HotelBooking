package com.example.Services;

import com.example.Entity.Hotel;
import com.example.Excetions.HotelAlreadyExistException;
import com.example.Excetions.NullHotelLocationException;
import com.example.Excetions.NullHotelNameException;
import com.example.Excetions.UserIdNeededException;

import jakarta.servlet.http.HttpSession;

public interface HotelService{
	
	Hotel getHotelById(int hotelId);
	
	Hotel getHotelByName(String hotelName);
	
	String addHotelToUser(HttpSession session,String hotelName,String location)throws NullHotelNameException, NullHotelLocationException, HotelAlreadyExistException, UserIdNeededException;

}