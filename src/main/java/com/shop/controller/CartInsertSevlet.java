package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.CartDAO;
import com.shop.dto.CartVO;
import com.shop.dto.UsersVO;

/**
 * Servlet implementation class CartInsertSevlet
 */
@WebServlet("/cartInsert.do")
public class CartInsertSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartInsertSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디와 pcode, cartcnt로 장바구니에 담는 메소드 호출

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null){
			response.sendRedirect("login.do");
		}
		else {
		
		UsersVO loginUser = (UsersVO) session.getAttribute("loginUser");
		
		
		System.out.println("1111" + request.getParameter("pcode"));

		int pcode = Integer.parseInt(request.getParameter("pcode"));
		int cartcnt = Integer.parseInt(request.getParameter("cartcnt"));

		CartVO cvo = new CartVO();
		cvo.setId(loginUser.getId());
		cvo.setPcode(pcode);
		cvo.setCartcnt(cartcnt);

		CartDAO cdao = CartDAO.getInstance();
		cdao.insertCart(cvo);
		
		response.sendRedirect("cart.do");

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
