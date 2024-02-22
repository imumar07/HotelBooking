package com.example.Services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.DAO.BookingDao;
import com.example.Entity.Booking;
import com.example.Excetions.HotelIsNotPresentInThatLocationException;
import com.example.Excetions.LogInAgainException;
import com.example.Excetions.NoBookingYetException;
import com.example.Excetions.RoomAlreadyCancelledException;
import com.example.Excetions.RoomsFullException;

import jakarta.servlet.http.HttpSession;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao bookingDaoImpl;
	
	public BookingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBooking(HttpSession session, String hotelName, String location)
			throws HotelIsNotPresentInThatLocationException {
		bookingDaoImpl.doBooking(session, hotelName, location);

	}

	@Override
	public int bookRoom(HttpSession session, int hotelId, String roomEle, int price, Date checkInDate,
			Date checkOutDate) throws RoomsFullException, LogInAgainException {
		return bookingDaoImpl.bookRoom(session, hotelId, roomEle, price, checkInDate, checkOutDate);
	}

	@Override
	public ArrayList<Booking> seeBookingsOwner(HttpSession session) throws NoBookingYetException, LogInAgainException {
		return bookingDaoImpl.seeBookingsOwner(session);
	}

	@Override
	public ArrayList<Booking> seePreviousBookings(HttpSession session) throws NoBookingYetException, LogInAgainException {
		return bookingDaoImpl.seePreviousBookings(session);
	}

	@Override
	public void cancelBookingUser(HttpSession session, String username, String hotelName, String location,
			Date checkinDate, Date checkoutDate,int index) throws RoomAlreadyCancelledException, LogInAgainException {
		bookingDaoImpl.cancelBookingUser(session, username, hotelName, location, checkinDate, checkoutDate,index);
		
	}

	@Override
	public void cancelBookingOwner(HttpSession session, String username, String hotelName, String location,
			Date checkinDate, Date checkoutDate, int index) throws RoomAlreadyCancelledException, LogInAgainException {
		bookingDaoImpl.cancelBookingOwner(session, username, hotelName, location, checkinDate, checkoutDate,index);
		
	}

	@Override
	public void doPayment(HttpSession session, String cardNumber, String cardNameEle, int cvv, Model mv) throws LogInAgainException {
		bookingDaoImpl.doPayment(session, cardNumber, cardNameEle, cvv, mv);
		
	}

}
