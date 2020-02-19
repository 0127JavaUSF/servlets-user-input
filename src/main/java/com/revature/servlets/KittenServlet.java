package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Kitten;

public class KittenServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String furColor = req.getParameter("fur-color");
		
		Kitten kitten = new Kitten(name, furColor);
		
		// pass to service layer for processing
		kitten.setId(1);
		
		resp.setStatus(201); // created
		resp.getWriter().write(kitten.toString());		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String furColor = req.getParameter("fur-color");
		
		Kitten kitten = new Kitten(name, furColor);
		
		// pass to service layer for processing
		kitten.setId(1);
		
		resp.setStatus(201); // created
		resp.getWriter().write(kitten.toString());	
	}
}
