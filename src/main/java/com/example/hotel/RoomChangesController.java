package com.example.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entity.Room;
import com.example.Excetions.HotelNotFoundException;
import com.example.Excetions.RoomNotFoundException;
import com.example.Excetions.RoomOccupiedException;
import com.example.Services.RoomService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RoomChangesController {
	@Autowired
	private RoomService roomServiceImpl;
	
	@GetMapping("/checkRoom")
	public String checkRoom(HttpSession session,@ModelAttribute("Room") Room room,Model mv) {
		try {
			String result=roomServiceImpl.addRoom(session, room.getHotelName(), room.getRoomType(), room.getPrice(), room.getRoomNumber());
			mv.addAttribute("message",result);
			return "HotelOwnerOptions";
		}catch(HotelNotFoundException e) {
			mv.addAttribute("message",e.getMessage());
			return "HotelOwnerOptions";
		}
	}
	
	@GetMapping("/removeRoom")
	public String removeRoom(HttpSession session,@ModelAttribute("Room") Room room,Model mv) {
		try {
			String result=roomServiceImpl.removeRoom(session, room.getRoomType(), room.getHotelName(), room.getRoomNumber());
			mv.addAttribute("message",result);
			return "HotelOwnerOptions";
		} catch (RoomOccupiedException e) {
			mv.addAttribute("message",e.getMessage());
			return "HotelOwnerOptions";
		}catch(RoomNotFoundException e) {
			mv.addAttribute("message",e.getMessage());
			return "HotelOwnerOptions";
		}
		
	}
}
