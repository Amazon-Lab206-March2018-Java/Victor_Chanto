package com.umanav.pets.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umanav.pets.models.cat;
import com.umanav.pets.models.dog;

/**
 * Servlet implementation class ShowInfo
 */
@WebServlet("/ShowInfo")
public class ShowInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process Request:
    	int Animal = Integer.parseInt(request.getParameter("Animal"));
        String Name = request.getParameter("Name");
        String Breed = request.getParameter("Breed");
        int Weight = Integer.parseInt(request.getParameter("Weight"));
    	System.out.println(Animal);
        if (Animal == 1) {
        	System.out.println("cat");
        	cat newCat = new cat(Name,Breed,Weight);
            request.setAttribute("affection", newCat.showAffection() );
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Cat.jsp");
            view.forward(request, response);
        }
        if (Animal == 2) {
        	System.out.println("dog");
        	dog newDog = new dog(Name,Breed,Weight);
            request.setAttribute("affection", newDog.showAffection());
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Dog.jsp");
            view.forward(request, response);
        }
    }


}
