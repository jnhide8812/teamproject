package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.OrderDetailDAO;
import com.shop.dto.OrderDetailVO;

/**
 * Servlet implementation class ManagerOrderDetailServlet
 */
@WebServlet("/ManagerOrderDetail.do") 
public class ManagerOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerOrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("수정");
		String ordernumber = request.getParameter("ordernumber");
		OrderDetailDAO odao = OrderDetailDAO.getInstance();
		OrderDetailVO ovo = odao.selectOrderDetailByOrdernumber(ordernumber);
		request.setAttribute("orderdetail", ovo);
		
		RequestDispatcher rd = request.getRequestDispatcher("manager/managerOrderDetail.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String ordernumber = request.getParameter("ordernumber");
		int orderdetailnumber = Integer.parseInt(request.getParameter("orderdetailnumber"));
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		int ordercnt = Integer.parseInt(request.getParameter("ordercnt"));
		String id = request.getParameter("id");
		String daddress = request.getParameter("daddress");
		String dname = request.getParameter("dname");
		
		OrderDetailVO ovo = new OrderDetailVO();
		ovo.setOrdernumber(Integer.parseInt(ordernumber));
		ovo.setOrderdetailnumber(orderdetailnumber);
		ovo.setOrdercnt(ordercnt);
		ovo.setPcode(pcode);
		ovo.setId(id);
		ovo.setDaddress(daddress);
		ovo.setDname(dname);

		
		OrderDetailDAO odao = OrderDetailDAO.getInstance();
		odao.updateOrderDetail(ovo);
		
		response.sendRedirect("ManagerOrderList.do");
		
		
	} 

}
