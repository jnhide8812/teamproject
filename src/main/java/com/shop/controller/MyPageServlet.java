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
 * Servlet implementation class MyPageServlet
 */
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
		        String id = request.getParameter("id"); 	
				UsersDAO udao = UsersDAO.getInstance();
				UsersVO loginUser = udao.selectById(id);
				request.setAttribute("loginUser", loginUser);
				System.out.println("마이페이지 연결1");
				RequestDispatcher rd = request.getRequestDispatcher("user/mypage.jsp");
			
				rd.forward(request, response);
				System.out.println("마이페이지 연결2");
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}