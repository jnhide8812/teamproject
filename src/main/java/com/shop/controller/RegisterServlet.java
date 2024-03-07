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
@WebServlet("/Register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersVO uvo = (UsersVO)session.getAttribute("loginUser");
		Integer result = (Integer)session.getAttribute("result");
		if(uvo != null&& result ==2) {
			String url = "register.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
		}else{
			response.sendRedirect("login.do");
			
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		usersdao.insertUsers(member);
		
		request.setAttribute("loginUser", member);
		request.setAttribute("message", "회원등록에 성공했습니다");
		String url ="login.jsp"; 
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		
		
	}
		
}

