package com.example.hotel;
import org.springframework.web.servlet.ModelAndView;
import com.example.Excetions.PasswordWrongException;
import com.example.Excetions.UserAlreadyExistException;
import com.example.Excetions.UserNotFoundException;
import com.example.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Entity.*;


@Controller
public class SimpleControl {
	@Autowired
	private UserService userServiceImpl;
	
	String userId="";

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("message", "");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/newUser")
	public ModelAndView newUserLogin() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("NewLogin");
		return mv;
	}
	@PostMapping("/loginUser")
	public String loginUser(HttpSession session,@ModelAttribute("User") User user,Model mv) {
		
	    try {
	    	System.out.println(user);
	    	boolean result=userServiceImpl.validateUser( session, user);
	    	if(result==true) {
	    		session.setAttribute("username", user.getUsername());
	    		return "BookingInfo";

	    	}else {
	    		return "HotelOwnerOptions";

	    	}
	    	
	    }catch(PasswordWrongException e) {
	    	mv.addAttribute("message","Password Incorrect");
	    	return "home";
	    }catch (UserNotFoundException e) {
	    	return "loginFail";

	        
	    }
	}
	@RequestMapping("/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mv=new ModelAndView("NewLogin");
		return mv;
	}
	@PostMapping(value = "/loginNew")
	public String loginNew(Model mv,@ModelAttribute("User") User user) {
	    try {
	    	boolean result=userServiceImpl.addNewUser(user);
	    	System.out.println(user);
	    	mv.addAttribute("message","User added sucessfully");
		    return "NewLogin";
	    }catch(UserAlreadyExistException e) {
	    	mv.addAttribute("message","User Already Exists");
	    	return "NewLogin";
	    }
	    
	}
	@GetMapping("/logOut")
	public String logOut(HttpSession session,Model mv) {
		userServiceImpl.logOut(session);
		return "redirect:/";
		
	}

}
