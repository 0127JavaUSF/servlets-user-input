package com.revature.servlets;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DogServlet
 */
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Forwarding dog GET requests to KittenServlet
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//		resp.sendRedirect("http://www.google.com");
		request.getRequestDispatcher("/kittens").forward(request, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reader reader =  request.getReader();
		char[] buffer = new char[5];
		int bytesRead = 0;
		while((bytesRead = reader.read(buffer)) != -1) {
			String content = new String(buffer).substring(0, bytesRead);
			System.out.print(content);
		}
	}

}
