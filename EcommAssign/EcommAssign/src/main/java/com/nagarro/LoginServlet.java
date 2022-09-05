package com.nagarro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		try{
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			try {
				UserDao udao=new UserDao(ConnectionDao.getCon());
				User user = udao.userLogin(email, password);
				
				if(user != null) {
//					out.print("user login");
					request.getSession().setAttribute("auth", user);
					response.sendRedirect("index.jsp");
				}else {
					out.print("user login failed");
				}
			} catch (SQLException e) {
				out.print("Check user connectionDao");
			}
			out.print(email+password);
		}catch(Exception e) {
			out.print("Check Servlet PArametre");
		}
	}

}
