package com.trimai.userinformation;

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
		String fn = request.getParameter("firstName") == null ? "Unknown" : request.getParameter("firstName");
		String ln = request.getParameter("lastName") == null ? "Unknown" : request.getParameter("lastName");
		String fl = request.getParameter("favoriteLanguage") == null ? "Unknown" : request.getParameter("favoriteLanguage");
		String ht = request.getParameter("homeTown") == null ? "Unknown" : request.getParameter("homeTown");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(
			"<h1>Welcome, " + fn + " " + ln + "</h1><h3>Your favorite language is: " + fl + "</h3><h3>Your hometown is: " + ht + "</h3>"
		);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
