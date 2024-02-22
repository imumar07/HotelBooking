package com.example.DAO;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Date;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.example.Entity.Booking;
import com.example.Excetions.HotelIsNotPresentInThatLocationException;
import com.example.Excetions.LogInAgainException;
import com.example.Excetions.NoBookingYetException;
import com.example.Excetions.RoomAlreadyCancelledException;
import com.example.Excetions.RoomsFullException;

import jakarta.servlet.http.HttpSession;

@Repository
public class BookingDaoImpl implements BookingDao {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public BookingDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBooking(HttpSession session, String hotelName, String location) throws HotelIsNotPresentInThatLocationException {
		String getRoomTypeQuery="select distinct room.room_type,room.price,hotel.hotel_id,hotel.location from room join hotel on room.hotel_id=hotel.hotel_id where hotel.hotel_name=? AND hotel.location=?;";
		List<Map<String,Object>> data=jdbcTemplate.queryForList(getRoomTypeQuery, hotelName,location);
		
		if(data.size()==0) {
			throw new HotelIsNotPresentInThatLocationException("Hotel is not present in that location");
		}else {
			session.setAttribute("roomType",data);
		}

	}
	@Override
	public int bookRoom(HttpSession session,int hotelId, String roomEle, int price, Date checkInDate,Date checkOutDate) throws RoomsFullException, LogInAgainException {
		String sql = "SELECT R.room_number, R.room_id " +
	             "FROM room R " +
	             "WHERE R.Hotel_ID = ? " +
	             "AND R.Room_Type = ? " +
	             "AND R.Availability = 1 " +
	             "AND NOT EXISTS (" +
	             "    SELECT B.room_id " +
	             "    FROM booking B " +
	             "    WHERE B.Room_ID = R.Room_ID " +
	             "    AND B.Status != 'cancelled' " +
	             "    AND NOT (" +
	             "        B.Checkout_Date <= ? " +
	             "        OR B.Checkin_Date >= ? " +
	             "    )" +
	             ")" +
	             "LIMIT 1;";

		try {
			Map<String,Object> data=jdbcTemplate.queryForMap(sql, hotelId, roomEle,checkInDate, checkOutDate);
				int roomNumberBooked=(int) data.get("room_number");
				int roomIdBooked=(int) data.get("room_id");
				try {
					int userId= (int) session.getAttribute("userId");
					String roomBookingQuery="INSERT INTO Booking (User_ID, Checkin_Date, Checkout_Date, Hotel_ID, Room_ID, Status, Price) VALUES (?, ?, ?, ?, ?, ?, ?)";
					jdbcTemplate.update(roomBookingQuery,userId,checkInDate,checkOutDate,hotelId,roomIdBooked,"booked",price);
					session.setAttribute("roomIdBooked", roomIdBooked);
					session.setAttribute("roomNumberBooked", roomNumberBooked);
					session.setAttribute("roomPriceBooked",price);
					return roomNumberBooked;
				}catch(Exception e) {
					throw new LogInAgainException();
				}
				
		}catch(EmptyResultDataAccessException e) {
			throw new RoomsFullException("Rooms are full");
		}
	}
	@Override
	public ArrayList<Booking> seeBookingsOwner(HttpSession session) throws NoBookingYetException, LogInAgainException {
	
			int userId=(int) session.getAttribute("userId");
			String query="select user.username,hotel.hotel_name,booking.checkin_date,booking.checkout_date,booking.price,booking.status,room.room_number from hotel join booking on hotel.hotel_id=booking.hotel_id join user on booking.user_id=user.user_id join room on room.room_id=booking.room_id \r\n"
					+ "where hotel.owner_id="+userId+";";
			List<Map<String,Object>> data=jdbcTemplate.queryForList(query);
			ArrayList<Booking> resultData=new ArrayList<>();
			if(data.size()>=1) {
				for(Map<String,Object> temp:data) {
					Booking tempBooking=new Booking();
					
					tempBooking.setUserName((String) temp.get("username"));
					tempBooking.setCheckInDate((Date) temp.get("checkin_date"));
					tempBooking.setCheckOutDate((Date) temp.get("checkout_date"));
					tempBooking.setHotelName((String) temp.get("hotel_name"));
					tempBooking.setLocation((String) temp.get("location"));
					tempBooking.setPrice((int) temp.get("price"));
					tempBooking.setStatus((String) temp.get("status"));
					tempBooking.setRoomNumber((int)temp.get("room_number"));
					resultData.add(tempBooking);
					
				}
				return resultData;
			}else {
				throw new NoBookingYetException("No Booking Found");
			}
		
		
		
	}
	@Override
	public ArrayList<Booking> seePreviousBookings(HttpSession session) throws NoBookingYetException, LogInAgainException {
	
			int userId=(int) session.getAttribute("userId");
			String query="select user.username,booking.checkin_date,booking.checkout_date,hotel.hotel_name,hotel.location,booking.price,booking.status,room.room_number from booking join user on booking.user_id=user.user_id join hotel on hotel.hotel_id=booking.hotel_id join room on room.ROOM_ID=booking.ROOM_id where user.user_id="+userId+";";
			List<Map<String,Object>> data=jdbcTemplate.queryForList(query);
			ArrayList<Booking> resultData=new ArrayList<>();
			if(data.size()>=1) {
				for(Map<String,Object> temp:data) {
					Booking tempBooking=new Booking();
					
					tempBooking.setUserName((String) temp.get("username"));
					tempBooking.setCheckInDate((Date) temp.get("checkin_date"));
					tempBooking.setCheckOutDate((Date) temp.get("checkout_date"));
					tempBooking.setHotelName((String) temp.get("hotel_name"));
					tempBooking.setLocation((String) temp.get("location"));
					tempBooking.setPrice((int) temp.get("price"));
					tempBooking.setStatus((String) temp.get("status"));
					tempBooking.setRoomNumber((int)temp.get("room_number"));
					resultData.add(tempBooking);
					
				}
				return resultData;
			}else {
				throw new NoBookingYetException("No Have No Previous Bookings Found");
			}
		
		
	}
	@Override
	public void cancelBookingUser(HttpSession session, String username, String hotelName, String location,Date checkinDate, Date checkoutDate,int index) throws RoomAlreadyCancelledException, LogInAgainException {
	
			int userId=(int) session.getAttribute("userId");
			String query="select booking.booking_id,user.username,booking.checkin_date,booking.checkout_date,hotel.hotel_name,hotel.location,booking.price,room.room_id,booking.status from booking join user on booking.user_id=user.user_id join hotel on hotel.hotel_id=booking.hotel_id join room on booking.room_id=room.room_id where booking.user_id="+userId+";";
			List<Map<String,Object>> data=jdbcTemplate.queryForList(query);
			String status=(String) data.get(index).get("status");
			if((status).equals("booked")) {
				int bookingId=(int) data.get(index).get("booking_id");
				String cancelQuery="Update booking set status='cancelled' where booking_id="+bookingId+";";
				jdbcTemplate.update(cancelQuery);
				
				
			}else {
				throw new RoomAlreadyCancelledException("Room Already Cancelled");
			}
		
		
	}
	@Override
	public void cancelBookingOwner(HttpSession session, String username, String hotelName, String location,
			Date checkinDate, Date checkoutDate, int index) throws RoomAlreadyCancelledException, LogInAgainException {
		int userId=(int) session.getAttribute("userId");
		
			String query="select user.username,hotel.hotel_name,booking.checkin_date,booking.checkout_date,booking.price,booking.status,booking.booking_id from hotel join booking on hotel.hotel_id=booking.hotel_id join user on booking.user_id=user.user_id where hotel.owner_id="+userId+";";
			List<Map<String,Object>> data=jdbcTemplate.queryForList(query);
			String status=(String) data.get(index).get("status");
			
			if((status).equals("booked")) {
				int bookingId=(int) data.get(index).get("booking_id");
				String cancelQuery="Update booking set status='cancelled' where booking_id="+bookingId+";";
				System.out.println("Hello");
				jdbcTemplate.update(cancelQuery);
				
				
			}else {
				throw new RoomAlreadyCancelledException("Room Already Cancelled");
			}
		
		
		
	}
	@Override
	public void doPayment(HttpSession session, String cardNumber, String cardNameEle, int cvv, Model mv) throws LogInAgainException {
			try {
				int roomIdBooked=(int) session.getAttribute("roomIdBooked");
				int userId=(int) session.getAttribute("userId");
				try {
					String query="UPDATE booking set card_number=?,name_on_card=?,cvv=? where user_id=? AND room_id=?;";
					jdbcTemplate.update(query,cardNumber,cardNameEle,cvv,userId,roomIdBooked);
				}catch(Exception e) {
					String query="Delete from booking where room_id=?;";
					jdbcTemplate.update(query,roomIdBooked);
					
				}
			}catch(Exception e) {
				throw new LogInAgainException();
			}
			
	}
	
		
}
