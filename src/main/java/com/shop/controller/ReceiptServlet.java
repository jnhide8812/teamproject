package com.shop.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.CartDAO;
import com.shop.dto.UsersVO;

/**
 * Servlet implementation class ReceiptServlet
 */
@WebServlet("/receipt.do")
public class ReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		UsersVO loginUser = (UsersVO)session.getAttribute("loginUser");
		
		//String totalprice = request.getParameter("totalprice");
		String totalprice = request.getParameter("total");
		
		CartDAO cdao = CartDAO.getInstance();
		List<Object> orderList = cdao.selectCartById(loginUser.getId());
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("totalprice", totalprice);
		
		System.out.println("totalprice :"+totalprice);
		
		RequestDispatcher rd = request.getRequestDispatcher("user/receipt.jsp");
		rd.forward(request, response);
		
		/*체크박스 선택한 것만 표현 못함...
		 * String pcode[] = request.getParameterValues("pcode[]"); String cnt[] =
		 * request.getParameterValues("cartcnt[]"); String totalprice =
		 * request.getParameter("totalprice");
		 * 
		 * request.setAttribute("pcode[]", pcode); request.setAttribute("cnt[]", cnt);
		 * request.setAttribute("totalprice", totalprice);
		 */
		//System.out.println(Arrays.toString(pcode));
		//System.out.println(Arrays.toString(cartcnt));
		
	}

}
