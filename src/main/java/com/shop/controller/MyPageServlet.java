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


@WebServlet("/mypage.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null){
			response.sendRedirect("login.do");
		}
		else {
			UsersVO loginUser = (UsersVO)session.getAttribute("loginUser");
		
		
		
		
		//		UsersDAO udao = UsersDAO.getInstance();
		//		UsersVO loginUser = udao.selectById(id);
				request.setAttribute("loginUser", loginUser);
				
				RequestDispatcher rd = request.getRequestDispatcher("user/mypage.jsp");
			
				rd.forward(request, response);
				
			}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}