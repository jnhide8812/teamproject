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
		//String id = request.getParameter("loginUser.id");
		String id = "user1";  //임시로 넣음 로그인 연결되면 삭제할것
		CartDAO cdao = CartDAO.getInstance();
		List<Object> cartList = cdao.selectCartById(id);
		request.setAttribute("cartList", cartList);
		
		RequestDispatcher rd = request.getRequestDispatcher("user/cart.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//HttpSession session = request.getSession();
		//String id = (String)session.getAttribute("id");  //로그인세션 가져오는 걸로 수정할 것
		
		String id = request.getParameter("id");
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		int cartcnt = Integer.parseInt(request.getParameter("cartcnt"));
		
		CartVO cvo = new CartVO();
		cvo.setId(id);
		cvo.setPcode(pcode);
		cvo.setCartcnt(cartcnt);
		
		CartDAO cdao = CartDAO.getInstance();
		cdao.insertCart(cvo);
		
	
		
		
		
	}

}
