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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("user/login.jsp");
		rd.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "user/login.jsp";
		String id = request.getParameter("id"); 
		String upwd = request.getParameter("upwd");
		String ugrade = request.getParameter("ugrade");
		
		UsersDAO udao = UsersDAO.getInstance();  
		int result = udao.userCheck(id, upwd);
		
		if(result == 1 || result == 2) {
			UsersVO uvo = new UsersVO();
			uvo = udao.selectById(id); 	 
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", uvo);
			session.setAttribute("id", uvo.getId());
		
			if(result==2) {
				url = "manager/manager.jsp";
			}else {
				url = "main.do";
			}
				
			
			request.setAttribute("message", "로그인에 성공했습니다");
			
		}else if(result == 0) {
				request.setAttribute("message", "비밀번호가 일치하지 않습니다");
		}else if(result == -1) {
			request.setAttribute("message", "등록되지 않은 아이디입니다");
		}
	

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
