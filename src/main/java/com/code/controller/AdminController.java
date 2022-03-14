package com.code.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.code.entities.User;
import com.code.services.UserService;

@Controller
@SessionAttributes("user")
@RequestMapping("user")
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String userForm(Model model) {
		model.addAttribute("users", userService.finAll());
		return "home";
	}

	@RequestMapping("/new")
	public String showAdd(Model model) {
		User user = new User();
//		List<Role> lisRoles = userService.finAllRoles();
//		model.addAttribute("listRoles", lisRoles);
		model.addAttribute("user", user);
		return "AddUser";
	}

	@PostMapping(value = "/insert")
	public String AddUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/user/list";
	}

	@GetMapping("edit/{id}")
	public String editForm(@PathVariable("id") int id, Model model) {
		User user = userService.findId(id);
		model.addAttribute("user", user);
		return "EditUser";
	}

	@PostMapping("update")
	public String updateStudent(@Valid User user, BindingResult result) {
		userService.update(user);
		return "redirect:/user/list";
	}

	@RequestMapping("/deletuser")
	public String deleteApplicant(Model model, @RequestParam("id") int id) {
		this.userService.delete(id);
		return "redirect:/user/list";
	}

	@SuppressWarnings("unused")
	@RequestMapping("logout")
	public String logOut(HttpSession httpSession, HttpServletRequest req) {
//		httpSession.removeAttribute("user");
//		httpSession.invalidate();
		httpSession = null;
		HttpSession session = req.getSession(true);
		if (httpSession == null) {
			return "redirect:/";
		}
		return "redirect:/user/list";
	}

}
