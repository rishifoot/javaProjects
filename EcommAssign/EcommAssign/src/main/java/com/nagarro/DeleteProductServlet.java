package com.nagarro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	int pid = Integer.parseInt(request.getParameter("id"));
	 PrintWriter out = response.getWriter();
        try{
            ProductDao prod = new ProductDao(ConnectionDao.getCon());
            prod.deleteProduct(pid);
            response.sendRedirect("index.jsp");
        }catch(Exception e){
            out.print("Delete operation failed....checkDelete Sql");
        }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
