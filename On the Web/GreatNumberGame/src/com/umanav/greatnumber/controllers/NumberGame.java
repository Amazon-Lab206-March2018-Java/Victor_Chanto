package com.umanav.greatnumber.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umanav.greatnumber.models.NumberGen;

/**
 * Servlet implementation class NumberGame
 */
@WebServlet("/NumberGame")
public class NumberGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        if (session.getAttribute("number") == null) {
        	NumberGen number = new NumberGen();
    		session = request.getSession();
    		session.setAttribute("number", number.setNumber());
        }
        System.out.println(request.getParameter("number"));
        System.out.println(session.getAttribute("number"));
        if (request.getParameter("number") != null) {
	    	Integer guess = Integer.parseInt(request.getParameter("number"));
			Integer result = (Integer) session.getAttribute("number");
	        if(guess>result) {
	        	session.setAttribute("guess", 1);
	        }
	        else if(guess<result) {
	        	session.setAttribute("guess", -1);
	        }
	        else{
	        	session.setAttribute("guess", 0);
	        }
        }
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Main.jsp");
        view.forward(request, response);
	}

}
