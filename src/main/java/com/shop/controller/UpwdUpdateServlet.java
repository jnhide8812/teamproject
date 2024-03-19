package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.UsersDAO;

/**
 * Servlet implementation class UpwdUpdateServlet
 */
@WebServlet("/upwdUpdate.do")
public class UpwdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpwdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dddd");
		request.setCharacterEncoding("UTF-8");
		String upwd = request.getParameter("upwd");
		String id = request.getParameter("id");
		System.out.println("id :"+id);
		System.out.println("upwd"+upwd);
		UsersDAO udao = UsersDAO.getInstance();
		udao.upwdUpdate(id,upwd);
		response.sendRedirect("login.do");
		
	}

}
