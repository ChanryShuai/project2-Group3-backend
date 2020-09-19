package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

@Controller
@RequestMapping
@ResponseBody
@CrossOrigin
public class LogController {

	private LoginService lSer;

	@Autowired
	public LogController() {
		super();
		this.lSer = lSer;
	}

	@PostMapping("/login")
	public void login(HttpServletRequest req, HttpServletResponse res, @RequestBody LoginDTO l)
			throws IOException, ServletException {

//		l.username = req.getParameter("username");
//		l.password = req.getParameter("password");

		if (lSer.addLogin(l) != null) {
			HttpSession ses = req.getSession();
			ses.setAttribute("user", l);
			ses.setAttribute("loggedin", true);
			res.setStatus(200);
			res.getWriter().println("Login Successful");
		} else {
			HttpSession ses = req.getSession(false);
			if (ses != null) {
				ses.invalidate();
			}
			res.setStatus(401);
			res.getWriter().println("Login failed");
		}
	}

	@PostMapping("/logout")
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println(l.getUsername() + " has logged out successfully");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout!");
		}

	}
}