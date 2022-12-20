package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.vo.CartVO;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;


@WebServlet("/product/cart.do")
public class CartController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		List<Cate1VO> cate1List = service.SelectAdminProduct1();
		req.setAttribute("cate1List", cate1List);
		
		List<Cate2VO> cate2List = service.SelectAdminProduct2();
		req.setAttribute("cate2List", cate2List);
		
		
		String proName = req.getParameter("proName");
		String descript = req.getParameter("descript");
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/cart.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
