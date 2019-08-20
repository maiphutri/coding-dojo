package com.codingdojo.pets.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.pets.models.Cat;

/**
 * Servlet implementation class Cats
 */
@WebServlet("/cats")
public class Cats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Cat cat = new Cat();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cats() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("cat", cat);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cat.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		double weight = Double.valueOf(request.getParameter("weight"));
		
		cat.setBreed(breed);
		cat.setName(name);
		cat.setWeight(weight);
		
		response.sendRedirect("/pets/cats");
	}

}
