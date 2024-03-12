package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.ManagerOrderDetailDAO;
import com.shop.dto.ManagerOrderDetailVO;



/**
 * Servlet implementation class ManagerOrderListServlet
 */
@WebServlet("/ManagerOrderList.do")
public class ManagerOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test");
		ManagerOrderDetailDAO modao = ManagerOrderDetailDAO.getInstance();
		List<ManagerOrderDetailVO> managerOrderList = modao.selectAllMembers();
		request.setAttribute("managerOrderList", managerOrderList);
		
		RequestDispatcher rd = request.getRequestDispatcher("manager/managerOrderList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
