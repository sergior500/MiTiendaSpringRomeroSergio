package com.jacaranda.primerSpring.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.primerSpring.model.Users;
import com.jacaranda.primerSpring.service.UserLoginService;
import com.jacaranda.primerSpring.service.UsersService;


import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	private static final String REDIRECT_USER = "redirect:/usuario/list";

	
	@Autowired
	 private UsersService service;
	
	@Autowired
	private UserLoginService serviceUser;
	
	@GetMapping("/login")
    public String login() {

        return "login";

    }
	
	@GetMapping("/logout")
    public String logout() {

        return "logout";

    }
	
	
	@GetMapping("/usuario/add")
	public String addUser(Model model) {
		Users user = new Users();
		
		model.addAttribute("user", user);
		
		return "AddUsers";
	}
	
	@PostMapping("usuario/add/submit")
	public String addUserSubmit(@ModelAttribute Users user) {
		
		service.addUser(user);
		
		return REDIRECT_USER;
	}
	
	@GetMapping("usuario/delete")
	public String deleteUser(@RequestParam("username") String username, Model model) {
		
		Users user = service.getUser(username);
		model.addAttribute("user", user);
		
		return "deleteUser";
	}
	
	@PostMapping("usuario/delete/submit")
	public String deleteUserSubmit(@ModelAttribute Users user) {
		
		service.deleteUser(user.getUsername());
		
		return REDIRECT_USER;
	}
	
	@GetMapping("usuario/update")
	public String updateUser(@RequestParam("username") String id, Model model) {
		String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
		if (nombre.equals(id)) {
			Users user = service.getUser(id);
			model.addAttribute("user", user);
			return "updateUser";
		}else {
			return "errorArticle";
		}
		
		
		
	}
	
	@PostMapping("usuario/update/submit")
	public String updateUserSubmit(@ModelAttribute Users user,
	@RequestParam("file") MultipartFile File) {
		String url = service.uploadFile(File);
		user.setImage(url);
		service.updateUser(user);
		
		return "redirect:/categoria/list";
	}
	
	@GetMapping("usuario/admin")
	public String updateUserAdmin(@RequestParam("username") String id, Model model) {
		
		Users user = service.getUser(id);
		model.addAttribute("user", user);
		
		return "updateAdmin";
	}
	
	@PostMapping("usuario/admin/submit")
	public String updateUserAdminSubmit(@ModelAttribute Users user) {
		
		service.updateAdmin(user);
		
		return REDIRECT_USER;
	}
	
	@GetMapping("usuario/list")
	public String getUsers(Model model) {
		
		List<Users> users = service.getUsers();
		model.addAttribute("users", users);
		
		return "usersList";
	}
	
	@GetMapping("/sing_up")
	public String singUp(Model model) {		
		model.addAttribute("user", new Users());
		return "singUp";
	}
	
	
	@GetMapping("/sing_up/submit")
	public String singUpSubmit(@ModelAttribute("user")Users user,
			HttpServletRequest request) throws MessagingException {
		String siteURL = request.getRequestURL().toString();
		siteURL = siteURL.replace(request.getServletPath(), "");
		user.setRole("USER");
		if(serviceUser.checkExist(user)) {
			try {
				serviceUser.add(user, siteURL);
			}catch(UnsupportedEncodingException e) {
				return "error";
			}catch(MessagingException e) {
				return "error";
			}
			return "register_success";
		}else {
			return "error";
		}
	}
	
	@GetMapping("/verify")
	public String verification(@RequestParam(name="code") String code, @RequestParam(name="username")String username) {
		if(serviceUser.checkVerify(code, username)) {
			return "verification_success";
		}else {
			return "error";
		}
	}
	

}
