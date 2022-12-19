package kr.co.kmarket.controller.product;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// aside-카테고리 목록 불러오기
		List<Cate1VO> cate1List = service.SelectAdminProduct1();
		req.setAttribute("cate1List", cate1List);
		
		List<Cate2VO> cate2List = service.SelectAdminProduct2();
		req.setAttribute("cate2List", cate2List);
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		List<Cate1VO> cate1Name = service.SelectCate1Name(cate1);
		List<Cate2VO> cate2Name = service.SelectCate2Name(cate1, cate2);
	
		req.setAttribute("cate1Name", cate1Name);
		req.setAttribute("cate2Name", cate2Name);
		
		List<ProductVO> ListProduct = service.SelectProductList(cate1, cate2);
		req.setAttribute("ListProduct", ListProduct);
		


		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}