package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.LoginUser;

@WebServlet(loadOnStartup = 1, urlPatterns = { "*.view" })
public class HeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(HeadServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		log.trace(request.getRequestURI());
		String url = request.getRequestURL().toString();
		if (url.equals("http://localhost:8080/project_v1/login.view"))
			request.getRequestDispatcher("partials/login.html").forward(request, response);
		else if (url.equals("http://localhost:8080/project_v1/loadDashboard.view")) {
			ObjectMapper mapper = new ObjectMapper();
			LoginUser user = mapper.readValue(request.getInputStream(), LoginUser.class);
			if (user.getType() == 2)
				request.getRequestDispatcher("partials/employeedashboard.html").forward(request, response);
			else
				request.getRequestDispatcher("partials/managerdashboard.html").forward(request, response);
		} else if (url.equals("http://localhost:8080/project_v1/create.view")) {
			request.getRequestDispatcher("partials/createreimb.html").forward(request, response);
		} else if (url.equals("http://localhost:8080/project_v1/logout.view")) {
			request.getSession().invalidate();
			request.getSession().setMaxInactiveInterval(1);
			request.getRequestDispatcher("partials/login.html").forward(request, response);
		}else if(url.equals("http://localhost:8080/project_v1/allReimbForUser.view")) 
			request.getRequestDispatcher("partials/allReimbForUser.html").forward(request, response);
		else if(url.equals("http://localhost:8080/project_v1/allReimbForManager.view")) 
			request.getRequestDispatcher("partials/allReimbForManager.html").forward(request, response);
		else if(url.equals("http://localhost:8080/project_v1/editReimb.view")) 
			request.getRequestDispatcher("partials/ReimbEdit.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
}
