package com.umanav.random.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umanav.random.models.WordGen;

/**
 * Servlet implementation class Random
 */
@WebServlet("/Random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Random() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session == null) {
    		session = request.getSession();
    		Integer count = 0;
    		session.setAttribute("count", count);
    	} else {
    		Integer count = (Integer) session.getAttribute("count");
//    		Integer count = 0;
    		session.setAttribute("count", count + 1);
    	}
        WordGen newWord = new WordGen();
        request.setAttribute("word", newWord.setWord());
        String timeStamp = new SimpleDateFormat("d MMM yyyy h:mm a").format(new Date());
        request.setAttribute("time", timeStamp);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Main.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}