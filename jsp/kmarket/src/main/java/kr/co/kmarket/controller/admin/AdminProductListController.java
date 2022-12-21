package kr.co.kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket.service.AdminService;

import kr.co.kmarket.vo.ProductVO;

@WebServlet("/admin/product/list.do")
public class AdminProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;
	@Override
	public void init() throws ServletException {
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String level =req.getParameter("level");
		
		List<ProductVO> listProduct = service.SelectProduct(2);
		req.setAttribute("listProduct", listProduct);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}	
}	
	
