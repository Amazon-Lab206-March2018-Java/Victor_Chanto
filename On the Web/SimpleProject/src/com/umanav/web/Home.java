package com.umanav.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String fName = "Unknown";
		String lName = "Unknown";
		String language = "Unknown";
		String town = "Unknown";
		if (request.getParameter("fName") != null) {
			fName = request.getParameter("fName");
		}
		if (request.getParameter("lName") != null) {
			lName = request.getParameter("lName");
		}
		if (request.getParameter("language") != null) {
			language = request.getParameter("language");
		}
		if (request.getParameter("town") != null) {
			language = request.getParameter("town");
		}
		PrintWriter header = response.getWriter();
		header.write("<h1>Hello World, " + fName + " " + lName + "</h1>");
		header.write("<h3>Your favorite language is " + language + "</h3>");
		header.write("<h3>Your hometown is: " + town + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


