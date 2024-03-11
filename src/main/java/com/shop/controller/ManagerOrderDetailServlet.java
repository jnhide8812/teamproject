package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.dao.ManagerOrderDetailDAO;
import com.shop.dto.ManagerOrderDetailVO;

/**
 * Servlet implementation class ManagerOrderDetailServlet
 */
@WebServlet("/managerOrderDetail.do")
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
		String orderdetailnumber = request.getParameter("orderdetailnumber");
		ManagerOrderDetailDAO dao = ManagerOrderDetailDAO.getInstance();
		ManagerOrderDetailVO vo = dao.selectOrderDetailByNumber(orderdetailnumber);

		request.setAttribute("manager", vo);
		RequestDispatcher rd = request.getRequestDispatcher("manager/managerOrderDetail.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = getServletContext();
		String encType = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				encType);
		
		String dname = multi.getParameter("dcode");
		String daddress = multi.getParameter("daddress");
		String pcode = multi.getParameter("pcode");
		String pname = multi.getParameter("pname");
		int totalprice = Integer.parseInt(multi.getParameter("totalprice"));
		String orderstatus = multi.getParameter("orderstatus");
	
		ManagerOrderDetailVO vo = new ManagerOrderDetailVO();
		vo.setDname(dname);
		vo.setDaddress(daddress);
		vo.setPcode(Integer.parseInt(pcode));
		vo.setPname(pname);
		vo.setTotalprice(totalprice);
		vo.setOrderstatus(orderstatus);
	
		ManagerOrderDetailDAO dao = ManagerOrderDetailDAO.getInstance();
		dao.updateOrderstatus(vo);
		
		response.sendRedirect("managerOrderList.do");
		
		
	}

}
