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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DogServlet() {
        super();
        // TODO Auto-generated constructor stub
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
