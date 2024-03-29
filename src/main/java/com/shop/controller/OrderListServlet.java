package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.OrderTableDAO;
import com.shop.dto.OrderTableVO;
import com.shop.dto.UsersVO;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/orderList.do")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") == null) 
		{
			response.sendRedirect("login.do");
		} else {
			UsersVO loginUser = (UsersVO) session.getAttribute("loginUser");
			OrderTableDAO odao = OrderTableDAO.getInstance();
			
		//	List<Object> orderList = odao.selectOrderListById(loginUser.getId());
			List<OrderTableVO> orderList = odao.selectOrderTableById(loginUser.getId());
			request.setAttribute("orderList", orderList);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("user/orderList.jsp");
			rd.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
