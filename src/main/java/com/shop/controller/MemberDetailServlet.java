package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.shop.dao.UsersDAO;
import com.shop.dto.UsersVO;

/**
 * Servlet implementation class MemberDetailServlet
 */
@WebServlet("/MemberDetail.do")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Get");
		String id = request.getParameter("id");
		UsersDAO udao = UsersDAO.getInstance();
		UsersVO memberDetail = udao.selectById(id);
		request.setAttribute("memberDetail", memberDetail);
		

		RequestDispatcher rd = request.getRequestDispatcher("manager/memberDetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post서블릿");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String ugrade = request.getParameter("ugrade");
		String uaddress = request.getParameter("uaddress");
		String uphone = request.getParameter("uphone");
		
		UsersVO uvo = new UsersVO();
		uvo.setId(id);
		uvo.setUgrade(ugrade);
		uvo.setUaddress(uaddress);		
		uvo.setUphone(uphone);
		
		UsersDAO udao = UsersDAO.getInstance();
		udao.updateUser(uvo); //업데이트
		
		response.sendRedirect("MemberList.do");
		
	}

}
