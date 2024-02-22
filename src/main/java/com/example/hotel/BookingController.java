package com.example.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entity.Booking;
import com.example.Entity.Payment;
import com.example.Excetions.HotelIsNotPresentInThatLocationException;
import com.example.Excetions.LogInAgainException;
import com.example.Excetions.NoBookingYetException;
import com.example.Excetions.RoomAlreadyCancelledException;
import com.example.Excetions.RoomsFullException;
import com.example.Services.BookingService;

import jakarta.servlet.http.HttpSession;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BookingController {
	@Autowired
	BookingService bookingServiceImpl;
	
	@PostMapping("/doBooking")
	public String  doBooking(HttpSession session,@ModelAttribute("Booking") Booking booking,Model mv) {
		try {
			bookingServiceImpl.doBooking(session, booking.getHotelName(),booking.getLocation());
			return "RoomBooking";
		} catch (HotelIsNotPresentInThatLocationException e) {
			mv.addAttribute("message","* Hotel is not present in the given location or Rooms are not present in the hotel");
			return "BookingInfo";
		}
		
	}
	@GetMapping("/bookDeluxe")
	public String bookDeluxe(HttpSession session,@ModelAttribute("Booking") Booking booking,Model mv) {
		try {
			int bookedRoom=bookingServiceImpl.bookRoom(session,booking.getHotelId(), booking.getRoomType(), booking.getPrice(), booking.getCheckInDate(), booking.getCheckOutDate());
			System.out.println(bookedRoom);
			if(bookedRoom==-1) {
				return "logOutPage";
			}else {
				mv.addAttribute("price",(Integer) session.getAttribute("roomPriceBooked"));
				return "PaymentDetails";
			}
		} catch (RoomsFullException e) {
			mv.addAttribute("message",e.getMessage());
			return "BookingUnsuccessful";
		}catch(LogInAgainException e) {
			return "logOutPage";
		}
	}
	@GetMapping("/bookNormal")
	public String bookNormal(HttpSession session,@ModelAttribute("Booking") Booking booking,Model mv) {
		try {
			int bookedRoom=bookingServiceImpl.bookRoom(session,booking.getHotelId(), booking.getRoomType(), booking.getPrice(), booking.getCheckInDate(), booking.getCheckOutDate());
			System.out.println(bookedRoom);
			if(bookedRoom==-1) {
				return "logOutPage";
			}else {
				mv.addAttribute("price",(Integer) session.getAttribute("roomPriceBooked"));
				return "PaymentDetails";
			}
		} catch (RoomsFullException e) {
			System.out.println(e.getMessage());
			mv.addAttribute("message",e.getMessage());
			return "BookingUnsuccessful";
		}catch(LogInAgainException e) {
			return "logOutPage";
		}

	}
	
	@GetMapping("/seeBookingsOwner")
	public String seeBookingsOwner(HttpSession session,Model mv) {
		try {
			ArrayList<Booking> data=bookingServiceImpl.seeBookingsOwner(session);
			mv.addAttribute("bookings",data);
			return "BookingsOwner";
		} catch (NoBookingYetException e) {
			return "NoReservationsYet";
		}catch(LogInAgainException e) {
			return "logOutPage";
		}
	}
	@GetMapping("/seePreviousBookings")
	public String seePreviousBookings(HttpSession session,Model mv) {
		try {
			ArrayList<Booking> data=bookingServiceImpl.seePreviousBookings(session);
			mv.addAttribute("bookings",data);
			return "UserPreviousBookings";
		} catch (NoBookingYetException e) {
			return "NoBookingsFound";
		}catch(LogInAgainException e) {
			return "logOutPage";
		}
	}
	@GetMapping("/cancelBooking")
	public String cancelBooking(HttpSession session,@ModelAttribute("Booking") Booking booking,@RequestParam("index") int index,Model mv) {
			try {
				bookingServiceImpl.cancelBookingUser(session, booking.getUserName(), booking.getHotelName(), booking.getLocation(), booking.getCheckInDate(), booking.getCheckOutDate(),index);
				mv.addAttribute("message","Room Cancelled Successfully");
				return "CancelSuccessful";
				
			}catch(RoomAlreadyCancelledException e) {
				return "BookingAlreadyCancelled";
			}catch(LogInAgainException e) {
				return "logOutPage";
			}
	}
	@GetMapping("/cancelBookingOwner")
	public String cancelBookingOwner(HttpSession session,@ModelAttribute("Booking") Booking booking,@RequestParam("index") int index,Model mv) {
			try {
				bookingServiceImpl.cancelBookingOwner(session, booking.getUserName(), booking.getHotelName(), booking.getLocation(), booking.getCheckInDate(), booking.getCheckOutDate(),index);
				mv.addAttribute("message","Room Cancelled Successfully");
				return "CancelSuccessful";
				
			}catch(RoomAlreadyCancelledException e) {
				return "BookingAlreadyCancelled";
			}catch(LogInAgainException e) {
				return "logOutPage";
			}
	}
	@PostMapping("/doPayment")
	public String doPayment(HttpSession session,@ModelAttribute("Payment") Payment payment,Model mv) {
		try {
			bookingServiceImpl.doPayment(session, payment.getCardNumber(), payment.getCardName(), payment.getCvv(), mv);
			int bookedRoom=(int) session.getAttribute("roomNumberBooked");
			mv.addAttribute("message",bookedRoom);
			return "BookingSuccessful";
		}catch(LogInAgainException e) {
			return "logOutPage";
		}
	}
}
