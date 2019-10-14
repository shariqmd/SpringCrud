package com.myspringcrud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySpringServlet
 */
@WebServlet("/MySpringServlet")
public class MySpringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  /*  public MySpringServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		
		
		//setup connection variable
		
		String user="root";
		String pass="root";
		String jdbcUrl="jdbc:mysql://localhost:3306/crudsp?userSSL=false";
		String driver="com.mysql.jdbc.Driver";
		
		// get connection to database
		
		
		try {
		PrintWriter out= response.getWriter();
		out.println("connecting to database"+ jdbcUrl);
		Class.forName(driver);
		Connection myconn=DriverManager.getConnection(jdbcUrl, user, pass);
		out.println("success");
		myconn.close();
		}
		catch(Exception exc) {
			
			exc.printStackTrace();
			
			throw new ServletException(exc);
			
			
		}
		
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
