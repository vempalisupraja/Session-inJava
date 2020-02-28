package com.sample.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		//System.out.println(name+" "+password);
		//writer.write("<html><body>");
		if(name.equalsIgnoreCase("supraja") && password.equalsIgnoreCase("jin")) {
			request.setAttribute("username", name);
			HttpSession session = request.getSession();
			session.setAttribute("namesession", name);
			//writer.write("<h1>"+name+"</h1>");
			//writer.write("</body></html>");
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error.jsp").include(request, response);
		}
	}
}
