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

import com.shop.dao.CartDAO;
import com.shop.dto.CartVO;
import com.shop.dto.UsersVO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디 별로 카트 리스트 출력
		
		HttpSession session = request.getSession();
	
		if(session.getAttribute("loginUser") == null){
			response.sendRedirect("login.do");
		}
		else {
			UsersVO loginUser = (UsersVO)session.getAttribute("loginUser");
			
			CartDAO cdao = CartDAO.getInstance();
			List<Object> cartList = cdao.selectCartById(loginUser.getId());
			request.setAttribute("cartList", cartList);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("user/cart.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
