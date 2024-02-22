package com.example.DAO;


import com.example.Excetions.HotelNotFoundException;
import com.example.Excetions.RoomNotFoundException;
import com.example.Excetions.RoomOccupiedException;

import jakarta.servlet.http.HttpSession;

public interface RoomDao {
	String addRoom(HttpSession session,String hotelName,String roomType,float price, int roomNumber) throws HotelNotFoundException;
	String removeRoom(HttpSession session,String roomType,String hotelName,int roomNumber) throws RoomOccupiedException, RoomNotFoundException;
}
