package kr.co.kmarket.controller.product;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String proNo = req.getParameter("proNo");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		ProductVO productView = service.SelectProductView(proNo);
		req.setAttribute("productView", productView );
		req.setAttribute("cate1", cate1 );
		req.setAttribute("cate2", cate2 );
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/view.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}