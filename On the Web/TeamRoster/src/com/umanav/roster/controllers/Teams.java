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

import com.umanav.roster.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		if (request.getParameter("id")==null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp");
			view.forward(request, response);			
		}
		else {
			Integer id = Integer.parseInt(request.getParameter("id"));
			session.setAttribute("id", id);
			ArrayList<Team> teams = new ArrayList<Team>();
			teams = (ArrayList<Team>) session.getAttribute("teams_saved");
			Team currentTeam = teams.get(id);
			System.out.println(teams.get(id));
			session.setAttribute("currentTeam", currentTeam);
			session.setAttribute("team_Players", currentTeam.getPlayers());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();  //starting session
		ArrayList<Team> teams = new ArrayList<Team>();  // creating the array
		if (session.getAttribute("teams_saved") != null) {
			teams = (ArrayList<Team>) session.getAttribute("teams_saved"); // adding the teams in session to the array list
		}
		String name = request.getParameter("name"); // getting the team name
		Team newTeam = new Team(name); // saving the new team
		teams.add(newTeam); // adding the new team to the array list
		session.setAttribute("teams_saved", teams); // saving in session
		System.out.println(session.getAttribute("teams_saved"));
		response.sendRedirect("/TeamRoster/");
	}

}
