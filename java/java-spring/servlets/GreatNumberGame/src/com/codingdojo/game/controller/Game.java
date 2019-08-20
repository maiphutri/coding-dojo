package com.codingdojo.game.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet("")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String result = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("randNum") == null) {
			Random rand = new Random();
			session.setAttribute("randNum", (rand.nextInt(100) + 1));
		}
		request.setAttribute("randNum", (int) session.getAttribute("randNum"));
		if (!result.isEmpty()) {
			request.setAttribute("result", result);
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int num =  Integer.valueOf(request.getParameter("number"));
		int randNum = (int) session.getAttribute("randNum");
		if (num < randNum) {
			result = "Too Low";
		}
		if (num > randNum) {
			result = "Too High";
		}
		if (num == randNum) {
			result = "Correct!";
		}
		response.sendRedirect("/home");
	}

}
