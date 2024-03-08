package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.UsersDAO;
import com.shop.dto.UsersVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/userUpdate.do")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		UsersDAO udao = UsersDAO.getInstance();
		
		UsersVO uvo = udao.selectById(id);
		
		request.setAttribute("uvo", uvo);
		RequestDispatcher rd = request.getRequestDispatcher("user/userUpdatePage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id= request.getParameter("id");
		String upwd= request.getParameter("upwd");
		String uaddress = request.getParameter("uaddress");
		String uphone= request.getParameter("uphone");
		String ubirth = request.getParameter("ubirth");
		String ugrade= request.getParameter("ugrade");
		Integer upoint= Integer.parseInt(request.getParameter("upoint"));
		String uname = request.getParameter("uname");
		
	
		//회원정보를 vo객체에 저장
		UsersVO uvo = new UsersVO();
		uvo.setId(id);
		uvo.setUpwd(upwd);
		uvo.setUaddress(uaddress);
		uvo.setUname(uname);
		uvo.setUphone(uphone);
		uvo.setUbirth(ubirth);
		uvo.setUgrade(ugrade);
		uvo.setUpoint(upoint);
		
		
		
		
		UsersDAO udao = UsersDAO.getInstance();
		udao.updateUser(uvo);
		response.sendRedirect("login.do");
		
		
		
	}

}
