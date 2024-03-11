package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.dao.ProductDAO;
import com.shop.dto.ProductVO;

/**
 * Servlet implementation class Update
 */
@WebServlet("/ManagerProductUpdate.do")
public class ManagerProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerProductUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Test");
		String pcode = request.getParameter("pcode");
		ProductDAO pdao = ProductDAO.getInstance();
		ProductVO pvo = pdao.selectProductByPcode(pcode);
		request.setAttribute("product", pvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("manager/managerProductUpdate.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = getServletContext();
		String path = context.getRealPath("img");
		String enctype = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, enctype, new DefaultFileRenamePolicy());

		String pcode =(multi.getParameter("pcode"));
		String pname = multi.getParameter("pname");
		int price = Integer.parseInt(multi.getParameter("price"));
		int pstock = Integer.parseInt(multi.getParameter("pstock"));
		String pstatus = multi.getParameter("pstatus");
		String pinfo = multi.getParameter("pinfo");
		String pictureurl = multi.getParameter("pictureurl");
		String catecode = multi.getParameter("catecode");

		if (pictureurl == null)
			pictureurl = multi.getParameter("nonmakeImg");

		ProductVO pvo = new ProductVO();
		pvo.setPcode(Integer.parseInt(pcode));
		pvo.setPname(pname);
		pvo.setPrice(price);
		pvo.setPstock(pstock);
		pvo.setPstatus(pstatus);
		pvo.setPinfo(pinfo); 
		pvo.setPictureurl(pictureurl);
		pvo.setCatecode(catecode);

		ProductDAO pdao = ProductDAO.getInstance();
		pdao.updateProduct(pvo);
		
		response.sendRedirect("ManagerList.do");

	}

}