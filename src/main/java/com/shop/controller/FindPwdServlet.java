package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.UsersDAO;

/**
 * Servlet implementation class FindPwdServlet
 */
@WebServlet("/findPwd.do")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("user/findPwd.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String uname = request.getParameter("uname");
		String uphone = request.getParameter("uphone");
		
		UsersDAO fdao = UsersDAO.getInstance();
		String upwd = fdao.findPwd(id, uname, uphone);
		request.setAttribute("upwd", upwd);
		
		RequestDispatcher rd = request.getRequestDispatcher("user/resultFindPwd.jsp");
		rd.forward(request, response);
		
	}

}
