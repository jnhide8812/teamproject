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
 * Servlet implementation class FindIdServlet
 */
@WebServlet("/findId.do")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("user/findId.jsp");
		rd.forward(request, response);
		
	}
//찾은 아이디 올릴 창 만들기!!
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aaaa");
		
		String uname = request.getParameter("uname").trim();
		String uphone = request.getParameter("uphone").trim();
		
		UsersDAO fdao = UsersDAO.getInstance();
		String id = fdao.findId(uname,uphone);
		request.setAttribute("id", id);
		System.out.println("id :" + id);
		RequestDispatcher rd = request.getRequestDispatcher("user/resultFindId.jsp");
		rd.forward(request, response);
		//수정중
		
		
	
	}

}
