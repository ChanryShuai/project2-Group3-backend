package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.services.LoginService;

@Controller
@RequestMapping
@ResponseBody
@CrossOrigin
@SessionAttributes("log")
public class LoginController {

	private LoginService lSer;

	@Autowired
	public LoginController() {
		super();
		this.lSer = lSer;
	}

	@PostMapping("/login")
	public void login(HttpSession ses) {
}
