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
@WebServlet("/Login.do")
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
		String url = "user/login.jsp";
		String id = request.getParameter("id"); //로그인 폼에서 입력한 아이디 비번
		String upwd = request.getParameter("upwd");
		String ugrade = request.getParameter("ugrade");
		
		UsersDAO usersdao = UsersDAO.getInstance();//(싱글톤)객체 생성, 클래스 이름이 아닌 객체 이름으로 접근해야함
		int result = usersdao.userCheck(id, upwd,ugrade); 	 
		if(result ==1) {
			UsersVO uVo = usersdao.selectById(id);
			HttpSession session = request.getSession();
		
			session.setAttribute("loginUser", uVo);
			
			request.setAttribute("message", "인증에 성공했습니다");
			url = "main.do";
		}else if(result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다");
			
		}else if(result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다");
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
