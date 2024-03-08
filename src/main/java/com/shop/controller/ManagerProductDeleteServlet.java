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
 * Servlet implementation class ManagerProductDeleteServlet
 */
@WebServlet("/ManagerProductDelete.do")
public class ManagerProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		ProductDAO pdao = ProductDAO.getInstance();
		ProductVO pvo = pdao.selectProductByPcode(pcode);
		
		request.setAttribute("product", pvo);
		RequestDispatcher rd = request.getRequestDispatcher("manager/managerProductDelete.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		
		ProductDAO pdao = ProductDAO.getInstance();
		pdao.deleteProduct(pcode);
		response.sendRedirect("ManagerList.do");
	}

}
