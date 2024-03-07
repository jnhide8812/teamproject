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
import com.shop.dao.ManagerDAO;
import com.shop.dto.ManagerVO;

/**
 * Servlet implementation class ManagerWriteServlet
 */
@WebServlet("/ManagerWrite.do")
public class ManagerWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/managerWrite.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = getServletContext();
		String path = context.getRealPath("img");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String pname = multi.getParameter("pname");
		int price = Integer.parseInt(multi.getParameter("price"));
		int pstock = Integer.parseInt(multi.getParameter("pstock"));
		int catecode = Integer.parseInt(multi.getParameter("catecode"));
		String pstatus = multi.getParameter("pstatus");
		String pinfo = multi.getParameter("pinfo");
		String pictureurl = multi.getParameter("pictureurl");
		
		ManagerVO vo = new ManagerVO();
		vo.setPname(pname);
		vo.setPrice(price);
		vo.setPstock(pstock);
		vo.setCatecode(catecode);
		vo.setPstatus(pstatus);
		vo.setPinfo(pinfo);
		vo.setPictureurl(pictureurl);
		
		System.out.println(path);
		
		ManagerDAO mdao = ManagerDAO.getInstance();
		mdao.insertProduct(vo);
		
		response.sendRedirect("ManagerList.do");
		
		
	}

}
