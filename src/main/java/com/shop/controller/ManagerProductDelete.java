package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.ProductDAO;
import com.shop.dto.ProductVO;

/**
 * Servlet implementation class delete
 */
@WebServlet("/managerProductDelete.do")
public class ManagerProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerProductDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		ProductDAO mdao = ProductDAO.getInstance();
		ProductVO mvo = mdao.selectProductByPcode(pcode);
		
		request.setAttribute("manager", mvo);
		RequestDispatcher rd = request.getRequestDispatcher("manager/managerProductUpdate.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		ProductDAO mdao = ProductDAO.getInstance();
		mdao.deleteProduct(pcode);
		response.sendRedirect("ManagerList.do");
	}

}
