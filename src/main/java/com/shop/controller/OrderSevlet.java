package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.OrderTableDAO;
import com.shop.dto.OrderTableVO;
import com.shop.dto.UsersVO;

/**
 * Servlet implementation class OrderSevlet
 */
@WebServlet("/order.do")
public class OrderSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("user/order.jsp");
		rd.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//order 테이블이랑 주문 상세 테이블이 인서트 하는 sql 사용해야 함
		//파라미터로 가져와야 하는 값 : 아이디 id, 결제금액 totalprice, 결제방법(payment 신용카드 etc)
		//주문상세: 아이디, 상품코드(pcode), 상품수량(ordercnt), 배송주소(daddress), 수령인명(dname)
		
		//처리해야하는 값 : 주문상태, 주문번호ordernumber는 둘이 같은 걸로 처리해야함
		
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UsersVO loginUser = (UsersVO)session.getAttribute("loginUser");
		String id = loginUser.getId();
		
		String pcode[] = request.getParameterValues("pcode[]");
		String ordercnt[] = request.getParameterValues("ordercnt[]");
		
		String dname = request.getParameter("dname");
		String daddress = request.getParameter("daddress");
		String payment = request.getParameter("payment");
		int totalprice = Integer.parseInt(request.getParameter("totalprice"));		
		String orderstatus = "주문중";  //request로 수정할 것
		
		OrderTableVO ovo = new OrderTableVO();
		ovo.setId(id);
		ovo.setTotalprice(totalprice);
		ovo.setOrderstatus(orderstatus);
		ovo.setPayment(payment);
		
		OrderTableDAO odao = OrderTableDAO.getInstance();
		odao.insertOrder(id, totalprice, orderstatus, payment);
				
		
		
		/*체크박스 선택한 것만 표현 못함...
		 * String pcode[] = request.getParameterValues("pcode[]"); 
		 * String cnt[] =request.getParameterValues("cartcnt[]");
		 *  String totalprice =
		 * request.getParameter("totalprice");
		 * 
		 * request.setAttribute("pcode[]", pcode); request.setAttribute("cnt[]", cnt);
		 * request.setAttribute("totalprice", totalprice);
		 */
		//System.out.println(Arrays.toString(pcode));
		//System.out.println(Arrays.toString(cartcnt));
		
		
	}

}
