package kr.co.kmarket.controller.product;
import java.io.IOException;

import java.io.PrintWriter;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.JsonObject;

import kr.co.kmarket.dao.ProductDAO;

import kr.co.kmarket.vo.CartVO;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;

import kr.co.kmarket.vo.ProductVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	private AdminService a_service = AdminService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Cate1VO> cate1List = a_service.SelectAdminProduct1();
		req.setAttribute("cate1List", cate1List);
		
		List<Cate2VO> cate2List = a_service.SelectAdminProduct2();
		req.setAttribute("cate2List", cate2List);
			
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
		
		String uid = req.getParameter("uid");
		String proNo = req.getParameter("proNo");
		String count = req.getParameter("count");
		String price = req.getParameter("price");
		String discount = req.getParameter("discount");
		String delivery = req.getParameter("delivery");
		
		CartVO cart = new CartVO();
		cart.setUid(uid);
		cart.setProNo(proNo);
		cart.setCount(count);
		cart.setPrice(price);
		cart.setDiscount(discount);
		cart.setDelivery(delivery);
		
		int check = ProductDAO.getInstance().SelectProductCart(uid, proNo);
		
		if(check > 0) {
			//장바구니에 동일한 상품이 있다면
			int result = ProductDAO.getInstance().UpdateProductCartCount(uid, proNo);
			
			JsonObject json = new JsonObject();
			json.addProperty("result", result);
			
			PrintWriter writer = resp.getWriter();
			writer.print(json.toString());
			
		}else {
			//없으면 
			int result = ProductDAO.getInstance().InsertProductCart(cart);
			
			JsonObject json = new JsonObject();
			json.addProperty("result", result);
			
			PrintWriter writer = resp.getWriter();
			writer.print(json.toString());
		}
	}
}