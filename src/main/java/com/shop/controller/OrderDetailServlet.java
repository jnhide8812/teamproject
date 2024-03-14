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

import com.shop.dao.OrderDetailDAO;
import com.shop.dao.OrderTableDAO;
import com.shop.dto.OrderTableVO;
import com.shop.dto.UsersVO;

/**
 * Servlet implementation class OrderDetailServlet
 */
@WebServlet("/orderDetail.do")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginUser") == null) {
			response.sendRedirect("login.do");
		
		} else {
			UsersVO loginUser = (UsersVO) session.getAttribute("loginUser");
			int ordernumber = Integer.parseInt(request.getParameter("ordernumber"));
			
			
			
			//주문 일반 정보 하단에 표시 예정
			OrderTableDAO odao = OrderTableDAO.getInstance();
			OrderTableVO orderList = odao.selectOrderTableByOrdernumber(ordernumber);
			
		
			//주문번호 ordernumber 을 받아 오더 디테일을 표시해주는 서블릿
			//a.ordercnt, a.daddress, a.dname, b.pname, b.price  정보 가져옴
			OrderDetailDAO oddao = OrderDetailDAO.getInstance();
			List<Object> orderDetailList = oddao.selectOrderDetail(ordernumber);
			
			request.setAttribute("orderList", orderList);
			request.setAttribute("orderDetailList", orderDetailList);
			
			RequestDispatcher rd = request.getRequestDispatcher("user/orderDetail.jsp");
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
