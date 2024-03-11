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
		HttpSession session = request.getSession();
		String loginUser = (String)session.getAttribute("loginUser");
		String id = (String)session.getAttribute("id"); 
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("user/receipt.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id"); // 세션으로 수정할 것
		String totalprice = request.getParameter("totalprice");
		
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
		
		CartDAO cdao = CartDAO.getInstance();
		List<Object> orderList = cdao.selectCartById(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);   //세션 되면 수정할 것
		request.setAttribute("orderList", orderList);
		request.setAttribute("totalprice", totalprice);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("user/receipt.jsp");
		rd.forward(request, response);
		
		
		
	}

}
