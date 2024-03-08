package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daewoo.dao.MemberDAO;
import com.daewoo.dto.memberVo;
import com.shop.dao.UsersDAO;

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
		//맵핑 주소(login.do)는 get 방식을 이동해서 doget도 처리해줘야함 
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
			UsersVO uVo = usersdao.getMember(id);
			HttpSession session = request.getSession();
			//세션은 값을 계속 물고 다녀서 중간에 값이 사라지거나 하지 않게 추가로 만들어주는 것
			
			session.setAttribute("loginUser", mVo);
			//mvo안에 담긴 정보를 loginuser라는 session의 변수로 만들어서 저장
			request.setAttribute("message", "인증에 성공했습니다");
			url = "main.jsp";
		}else if(result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다");
			
		}else if(result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다");
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
