package com.code.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.entities.User;
import com.code.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/")
    public String showLoginForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
        return "login";
    }
	
	@PostMapping("/access")
	public String checkLogin(@Valid User user, BindingResult result, HttpSession httpSession) {
		String email = user.getEmail();
		String password = user.getPassword();
		
		if (userService.login(email, password)) {
			httpSession.setAttribute("user", user);
			//System.out.println(httpSession.getAttribute("user"));
			return "redirect:/user/list";
		}
		return "redirect:/error";
	}
	
	@RequestMapping("/error")
	public String showLoginFail() {
		return "error";
	}

}
