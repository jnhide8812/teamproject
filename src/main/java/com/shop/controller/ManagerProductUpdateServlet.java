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
		String pcode = request.getParameter("pcode");
		ProductDAO mdao = ProductDAO.getInstance();
		ProductVO mvo = mdao.selectProductByPcode(pcode);
		request.setAttribute("manager", mvo);
		
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

		String pcode = multi.getParameter("pcode");
		String pname = multi.getParameter("pname");
		int price = Integer.parseInt(multi.getParameter("price"));
		int pstock = Integer.parseInt(multi.getParameter("pstock"));
		String pstatus = multi.getParameter("pstatus");
		String pinfo = multi.getParameter("pinfo");
		String pictureurl = multi.getParameter("pictureurl");
		String catecode = multi.getParameter("catecode");

		if (pictureurl == null)
			pictureurl = multi.getParameter("nonmakeImg");

		ProductVO mvo = new ProductVO();
		mvo.setPcode(Integer.parseInt(pcode));
		mvo.setPname(pname);
		mvo.setPrice(price);
		mvo.setPstock(pstock);
		mvo.setPstatus(pstatus);
		mvo.setPinfo(pinfo); 
		mvo.setPictureurl(pictureurl);
		mvo.setCatecode(catecode);

		ProductDAO mdao = ProductDAO.getInstance();
		mdao.updateProduct(mvo);
		response.sendRedirect("ManagerList.do");

	}

}