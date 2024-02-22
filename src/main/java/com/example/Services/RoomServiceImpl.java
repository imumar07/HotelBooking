package com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.RoomDao;
import com.example.Excetions.HotelNotFoundException;
import com.example.Excetions.RoomNotFoundException;
import com.example.Excetions.RoomOccupiedException;

import jakarta.servlet.http.HttpSession;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomDao roomDaoImpl;
	public RoomServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addRoom(HttpSession session, String hotelName, String roomType, float price, int roomNumber)
			throws HotelNotFoundException {
		return roomDaoImpl.addRoom(session,hotelName,roomType,price,roomNumber);
	}

	@Override
	public String removeRoom(HttpSession session, String roomType, String hotelName, int roomNumber)
			throws RoomOccupiedException, RoomNotFoundException {
		return roomDaoImpl.removeRoom(session, roomType, hotelName, roomNumber);
	}

}
