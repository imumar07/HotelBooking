package com.example.DAO;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Excetions.HotelNotFoundException;
import com.example.Excetions.RoomNotFoundException;
import com.example.Excetions.RoomOccupiedException;

import jakarta.servlet.http.HttpSession;

@Repository
public class RoomDaoImpl implements RoomDao {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public String addRoom(HttpSession session,String hotelName, String roomType, float price, int roomNumber) throws HotelNotFoundException {
		Integer userId=(Integer)session.getAttribute("userId");
		String hotelIdQuery="select hotel_id from hotel where owner_id=? AND hotel_name LIKE ?;";
		List<Map<String,Object>> data=jdbcTemplate.queryForList(hotelIdQuery,userId,hotelName);
		if(data.size()!=0) {
			Integer hotelId=(Integer) data.get(0).get("hotel_id");
			String roomInsertQuery="Insert into room(hotel_id,room_type,price,room_number,availability) Values(?,?,?,?,?);";
			int i=jdbcTemplate.update(roomInsertQuery,hotelId,roomType,price,roomNumber,true);
			if(i>=1) {
				return "Room Added Successfully";
			}
		}else {
			throw new HotelNotFoundException("Hotel Not Found Please Check Hotel Name");
		}
		return "error";
		
	}
	@Override
	public String removeRoom(HttpSession session, String roomType, String hotelName, int roomNumber) throws RoomOccupiedException, RoomNotFoundException {
		Integer userId=(Integer)session.getAttribute("userId");
		String roomIdQuery="SELECT room.room_id,room.room_number,HOTEL.hotel_name,HOTEL.owner_id, room.room_type, room.availability FROM room JOIN hotel ON room.Hotel_ID = hotel.Hotel_ID WHERE room.room_type LIKE '"+roomType+"' AND hotel.owner_id="+userId+" AND hotel.hotel_name LIKE '"+hotelName+"' AND room.room_number="+roomNumber+";";
		List<Map<String,Object>> data=jdbcTemplate.queryForList(roomIdQuery);
		if(data.size()==1) {
			Map<String,Object> room=data.get(0);
			if((boolean)room.get("availability")) {
				String removeRoomQuery="DELETE from room where room_id=?;";
				int i=jdbcTemplate.update(removeRoomQuery,room.get("room_id"));
				if(i>=0) {
					return "Room removed Successfully";
				}
			}else {
				throw new RoomOccupiedException("Room is Booked Can't remove room");
			}
		}else {
			throw new RoomNotFoundException("Room Not Found Please Check the details");
		}
		return "hello";
	}


}
