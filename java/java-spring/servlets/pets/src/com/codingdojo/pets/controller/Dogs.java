package com.codingdojo.pets.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.pets.models.Dog;

/**
 * Servlet implementation class Dogs
 */
@WebServlet("/dogs")
public class Dogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Dog dog = new Dog();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dogs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("dog", dog);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dog.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		double weight = Double.valueOf(request.getParameter("weight"));
		
		dog.setBreed(breed);
		dog.setName(name);
		dog.setWeight(weight);
		
		response.sendRedirect("/pets/dogs");
	}

}
