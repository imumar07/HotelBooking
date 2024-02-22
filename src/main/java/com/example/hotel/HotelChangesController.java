package com.example.hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Entity.Hotel;
import com.example.Excetions.HotelAlreadyExistException;
import com.example.Excetions.NullHotelLocationException;
import com.example.Excetions.NullHotelNameException;
import com.example.Excetions.UserIdNeededException;
import com.example.Services.HotelService;

import jakarta.servlet.http.HttpSession;


@Controller
public class HotelChangesController {
	@Autowired
	private HotelService hotelServiceImpl;
	
	@PostMapping("/addHotelToUser")
	public String addHotelToUser(HttpSession session,@ModelAttribute("Hotel") Hotel hotel,Model mv){
		System.out.println("Hello");
		try {
			System.out.println(hotel);
			String result=hotelServiceImpl.addHotelToUser(session, hotel.getHotelName(),hotel.getLocation());
			mv.addAttribute("message",result);
			return "HotelOwnerOptions";
		}catch(NullHotelNameException e) {
			mv.addAttribute("message",e.getMessage()+" Please try again");
			return "HotelOwnerOptions";
		}catch(NullHotelLocationException e) {
			mv.addAttribute("message",e.getMessage()+" Please try again");
			return "HotelOwnerOptions";
		}catch(HotelAlreadyExistException e) {
			mv.addAttribute("message",e.getMessage()+" Please try again");
			return "HotelOwnerOptions";
		}catch(UserIdNeededException e) {
			mv.addAttribute("message",e.getMessage());
			return "HotelOwnerOptions";
		}catch(Exception e) {
			System.out.println(e);
			return "HotelOwnerOptions";
		}
		
	}
}
