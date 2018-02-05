package com.electroproshop.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ElectroProShopBacked.dao.UserDetailsDAO;
import com.ElectroProShopBacked.model.UserDetails;

@Controller
public class UserDetailsController {
	@Autowired
	UserDetails userDetails;
	@Autowired
	UserDetailsDAO userDetailsDAO;
	@RequestMapping("/login")
	public String login(@RequestParam(value="id",required=false) String id,Model m) {
		if(id!=null){
		if(id.equals("1"))
			m.addAttribute("msg","Invalid Username or Password");
		else if(id.equals("2"))
			m.addAttribute("msg","You've been logged out");
		else if(id.equals("3"))
			m.addAttribute("msg","Registered Successfully...");
		}
		return "login";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	@RequestMapping("/addUser")
	public String addUser(@RequestParam Map<String,String> user,Model m) {
		userDetails.setFull_name(user.get("full_name"));
		userDetails.setEmail(user.get("email"));
		userDetails.setMobile(Long.parseLong(user.get("mobile")));
		userDetails.setAddress(user.get("address"));
		userDetails.setUsername(user.get("username"));
		userDetails.setPassword(user.get("password"));
		userDetails.setEnabled(true);
		userDetails.setRole("ROLE_USER");
		if(userDetailsDAO.addUserDetails(userDetails))
			return "redirect:login?id=3";
		return "register";
	}
	@RequestMapping("/login_success")
	public String perform_login(@RequestParam Map<String,String> user,Model m,HttpSession httpSession) {
			httpSession.setAttribute("loggedIn", true);
			return "redirect:/";
	}
	
}
