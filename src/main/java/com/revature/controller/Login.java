package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.LoginUser;
import com.revature.dto.User;
import com.revature.service.UserService;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(Login.class);
	private UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace(request.getRequestURL());
		ObjectMapper mapper = new ObjectMapper();
		String out = "";
		LoginUser temp = mapper.readValue(request.getInputStream(), LoginUser.class);
		temp.setType(0);
		log.trace("Login user and password : " + temp);
		User user = userService.checkAuth(temp.getUserName(), temp.getPassword());
		log.trace("Returned user from DB:  " + user);
		if (user == null) {
			out = mapper.writeValueAsString(null);
		} else {
			if (user.getUserRole() == 1)
				temp.setType(1);
			else
				temp.setType(2);
			
			request.getSession().setAttribute("userSession", user);
			log.trace("User In Session" + request.getSession().getAttribute("userSession"));
			out = mapper.writeValueAsString(temp);
		}

		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		pw.write(out);

	}

}
