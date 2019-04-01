package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ReimbSubmit;
import com.revature.dto.User;
import com.revature.service.ReimbService;


public class SubmitReimb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimbService rService = new ReimbService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ReimbSubmit reimb = mapper.readValue(request.getInputStream(), ReimbSubmit.class);
		User user = (User)request.getSession().getAttribute("userSession");
		boolean result = rService.insertReimb(reimb.getAmount(), reimb.getDescription(), user.getUserId(), reimb.getType());
		if(result)
			request.getRequestDispatcher("partials/employeedashboard.html").forward(request, response);
		else
			request.getRequestDispatcher("partials/createreimb.html").forward(request, response);
	}

}
