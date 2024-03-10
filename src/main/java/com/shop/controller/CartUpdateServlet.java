package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.CartDAO;

/**
 * Servlet implementation class CartUpdateServlet
 */
@WebServlet("/cartUpdate.do")
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int cartcnt = Integer.parseInt(request.getParameter("cartcnt"));
		int cartnumber = Integer.parseInt(request.getParameter("cartnumber"));
		String name = request.getParameter("name");
		
		CartDAO cdao = CartDAO.getInstance();
		
		if (name.equals("minus")) {
			if (cartcnt >= 2) {
				cdao.minusCartcnt(cartnumber, cartcnt);
				RequestDispatcher rd = request.getRequestDispatcher("cart.do");
				rd.forward(request, response);
			}else {  //카트 수량이 1개라면 카트에서 줄일 수 없음
				request.setAttribute("message", "수량은 1개 이상 담아주세요");
				RequestDispatcher rd = request.getRequestDispatcher("cart.do");
				rd.forward(request, response);
			}
			

		}else {
			cdao.plusCartcnt(cartnumber, cartcnt);
			RequestDispatcher rd = request.getRequestDispatcher("cart.do");
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
