package kr.co.kmarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminService;

import kr.co.kmarket.vo.ProductVO;

@WebServlet("/index.do")
public class IndexController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;
	
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductVO> listProduct = service.SelectProduct(0);
		List<ProductVO> listProductHit = service.SelectProduct(1);
		List<ProductVO> listProductNow = service.SelectProduct(2);
		List<ProductVO> listProductDiscount = service.SelectProduct(3);
		List<ProductVO> listProductBest = service.SelectProduct(4);
		req.setAttribute("listProduct", listProduct);
		req.setAttribute("listProductHit", listProductHit);
		req.setAttribute("listProductNow", listProductNow);
		req.setAttribute("listProductDiscount", listProductDiscount);
		req.setAttribute("listProductBest", listProductBest);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
