package com.umanav.roster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umanav.roster.models.Player;
import com.umanav.roster.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp");
        view.forward(request, response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		Player newPlayer = new Player(firstName,lastName,age);
		ArrayList <Team> teams= (ArrayList <Team>) session.getAttribute("teams_saved");
		Team currentTeam =  teams.get((Integer) session.getAttribute("id"));
		ArrayList <Player> list = currentTeam.getPlayers();
		list.add(newPlayer);
		currentTeam.setPlayers(list);
		session.setAttribute("currentTeam", currentTeam.getPlayers());
		response.sendRedirect("/TeamRoster/");
	}

}
