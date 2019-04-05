package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ReimDto;
import com.revature.dto.User;
import com.revature.service.ReimbService;


public class Denied extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(Approved.class);
	private ReimbService service = new ReimbService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String out = "";
		ReimDto temp = mapper.readValue(request.getInputStream(), ReimDto.class);
		User user = (User) request.getSession().getAttribute("userSession");
		boolean result = service.deniedReimb(user, temp); 
	}

}
