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
import com.shop.dao.OrderDetailDAO;
import com.shop.dao.OrderTableDAO;
import com.shop.dto.OrderDetailVO;
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
		//RequestDispatcher rd = request.getRequestDispatcher("user/order.jsp");
		//rd.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// order 테이블이랑 주문 상세 테이블이 인서트 하는 sql 사용해야 함
		// 파라미터로 가져와야 하는 값 : 아이디 id, 결제금액 totalprice, 결제방법(payment 신용카드 etc)
		// 주문상세: 아이디, 상품코드(pcode), 상품수량(ordercnt), 배송주소(daddress), 수령인명(dname)

		// 처리해야하는 값 : 주문상태, 주문번호ordernumber는 둘이 같은 걸로 처리해야함

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UsersVO loginUser = (UsersVO) session.getAttribute("loginUser");
		String id = loginUser.getId();

		String pcode[] = request.getParameterValues("pcode[]");
		String ordercnt[] = request.getParameterValues("ordercnt[]");

		String url = null; // 주문 성공, 실패에 따라 이동 장소 변경

		// 주문 테이블에 넣어야할 값 4가지
		String dname = request.getParameter("dname");
		String daddress = request.getParameter("daddress");
		String payment = request.getParameter("payment");
		int totalprice = Integer.parseInt(request.getParameter("totalprice"));
		String orderstatus = "주문중"; // 수정할 것(sql도 조건 주문중으로 했음)

		// 새로고침하면 반복해서 insert 되는 문제 수정해야함

		// 주문테이블에 인서트
		OrderTableVO ovo = new OrderTableVO();
		ovo.setId(id);
		ovo.setTotalprice(totalprice);
		ovo.setOrderstatus(orderstatus);
		ovo.setPayment(payment);

		OrderTableDAO odao = OrderTableDAO.getInstance();
		odao.insertOrder(ovo);

		// 주문 상세테이블에 인서트 준비(주문 넘버 셀렉)
		int ordernumber = odao.selectOrdernumber(id);

		// 주문상세: 아이디, 상품코드(pcode), 상품수량(ordercnt), 배송주소(daddress), 수령인명(dname)
		int result = 0; // 주문상세에 리스트가 insert 되면 1반환
		OrderDetailVO odvo = new OrderDetailVO();

		for (int i = 0; i < pcode.length; i++) {
			int pcodei = Integer.parseInt(pcode[i]);
			int ordercnti = Integer.parseInt(ordercnt[i]);

			odvo.setOrdernumber(ordernumber);
			odvo.setId(id);
			odvo.setPcode(pcodei);
			odvo.setOrdercnt(ordercnti);
			odvo.setDaddress(daddress);
			odvo.setDname(dname);

			OrderDetailDAO oddao = OrderDetailDAO.getInstance();
			result = oddao.insertOrderDetail(odvo); // 주문상세가 등록되면 1반환

		}

		// 주문 상세가 등록되면 1, 아니면 0 / 1이면 주문테이블의 상태를 주문중에서 주문완료로 변경
		// 리턴이 1이면 결제 완료로 변경하고 리턴이 0이면(주문상세 등록 실패하면) 오더테이블에서 삭제
		// 주문 성공하면 카트에서 해당 리스트 삭제할 것
		// 성공 실패후 이동할 장소 dispatcher 사용

		if (result == 1) { // 주문상세테이블에 목록이 추가되면
			odao.updateOrderStatus(ordernumber); // 오더테이블의 상태를 주문완료로 변경
			CartDAO cdao = CartDAO.getInstance();
			cdao.deleteAllByOrder(id); // 카트 비움

			// 매니저창에서 주문확인하고 배송하면 재고에서 -1씩 하기
			request.setAttribute("ordertable", ovo); // 주문한 목록 리스트 오더컨펌에 표시하기
			request.setAttribute("orderdetail", odvo);
			request.setAttribute("ordernumber", ordernumber);

			url = "user/orderConfirm.jsp";

		} else {
			odao.deleteOrder(ordernumber); // 주문 실패하면 오더테이블에 등록한 내역 삭제
			url = "user/cart.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
