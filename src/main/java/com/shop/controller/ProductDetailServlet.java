package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.ProductDAO;
import com.shop.dto.ProductVO;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/productDetail.do")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode"); //피코드를 이용해서 검색하고 싶으니까
		 //테스트용 삭제예정
		ProductDAO pdao = ProductDAO.getInstance();
		ProductVO productDetail = pdao.selectProductByPcode(pcode);
		request.setAttribute("productDetail", productDetail);
		RequestDispatcher rd = request.getRequestDispatcher("shopping/productDetail.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginUser = (String)session.getAttribute("loginUser");
	}

}
