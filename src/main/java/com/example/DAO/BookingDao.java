package com.example.DAO;


import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entity.Booking;
import com.example.Excetions.HotelIsNotPresentInThatLocationException;
import com.example.Excetions.LogInAgainException;
import com.example.Excetions.NoBookingYetException;
import com.example.Excetions.RoomAlreadyCancelledException;
import com.example.Excetions.RoomsFullException;

import jakarta.servlet.http.HttpSession;

public interface BookingDao {
	void doBooking(HttpSession session,String hotelName,String location) throws HotelIsNotPresentInThatLocationException;
	int bookRoom(HttpSession session,int hotelId,String roomEle, int price,Date checkInDate,Date checkOutDate) throws RoomsFullException, LogInAgainException;
	ArrayList<Booking> seeBookingsOwner(HttpSession session) throws NoBookingYetException, LogInAgainException;
	ArrayList<Booking> seePreviousBookings(HttpSession session) throws NoBookingYetException, LogInAgainException;
	void cancelBookingUser(HttpSession session,String username,String hotelName,String location,Date checkinDate,Date checkoutDate,int index) throws RoomAlreadyCancelledException, LogInAgainException;
	void cancelBookingOwner(HttpSession session,String username,String hotelName,String location,Date checkinDate,Date checkoutDate,int index) throws RoomAlreadyCancelledException, LogInAgainException;
	void doPayment(HttpSession session,String cardNumber, String cardNameEle, int cvv,Model mv) throws LogInAgainException;
}
