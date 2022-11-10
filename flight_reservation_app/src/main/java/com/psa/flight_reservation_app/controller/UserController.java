package com.psa.flight_reservation_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.flight_reservation_app.entities.User;
import com.psa.flight_reservation_app.repository.UserRepository;



@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "login/login";
		
	}
	
	@RequestMapping("/userRegistration")
	public String userRegistration() {
		return "login/userRegistration";
	}

	@RequestMapping("/saveReg")
	public String saveRegistration(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/userLogin")
	public String login(@RequestParam("emailid") String emailid,@RequestParam("password") String password, ModelMap modelMap) {
		User user = userRepo.findByEmail(emailid);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}else {
			modelMap.addAttribute("msg", "Invalid username/password");
			return "login/login";
		}

	}
	
}

