package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.Reimbursement;
import com.revature.dto.User;
import com.revature.service.ReimbService;


public class DisplayAllReimbForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimbService rs = new ReimbService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String out = "";
		User user = (User)request.getSession().getAttribute("userSession");
		List<Reimbursement> list = rs.getAllReimbByUser(user.getUserId());
		if(list.size() >= 1)
			out = mapper.writeValueAsString(list);
		else
			out = mapper.writeValueAsString(null);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		pw.write(out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
