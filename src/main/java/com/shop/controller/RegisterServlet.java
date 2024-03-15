package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.UsersDAO;
import com.shop.dto.UsersVO;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  RequestDispatcher rd = request.getRequestDispatcher("user/register.jsp");
		  rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UsersVO member = new UsersVO();
		member.setId(request.getParameter("id"));
		member.setUpwd(request.getParameter("upwd"));
		member.setUname(request.getParameter("uname"));
		member.setUphone(request.getParameter("uphone"));
		member.setUbirth(request.getParameter("ubirth"));
		member.setUaddress(request.getParameter("uaddress"));
		member.setUgrade(request.getParameter("ugrade"));
		member.setUpoint(Integer.parseInt(request.getParameter("upoint")));

		
		UsersDAO usersdao = UsersDAO.getInstance(); 
	    int result = usersdao.insertUsers(member);
		 
		    if(result == 1) {
		    
			  response.sendRedirect("login.do");
			  
		    }else {
		    	 response.sendRedirect("register.do");
		    }
	    
		
	}
}
