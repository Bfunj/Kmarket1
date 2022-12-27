package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.vo.CartVO;
import kr.co.kmarket.vo.OrderVO;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/product/directOrder.do")
public class DirectOrderController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		
		List<CartVO> carts = ProductDAO.getInstance().SelectProductCarts2(uid);
		req.setAttribute("carts", carts);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/directOrder.jsp");
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
		
		int result = ProductDAO.getInstance().InsertProductCart(cart);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		}
}