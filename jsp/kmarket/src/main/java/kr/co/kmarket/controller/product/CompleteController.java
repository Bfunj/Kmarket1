package kr.co.kmarket.controller.product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.vo.OrderItemVO;

@WebServlet("/product/complete.do")
public class CompleteController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/complete.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String proNo_arr[] = req.getParameterValues("proNo_arr");
		String count_arr[] = req.getParameterValues("count_arr");
		String price_arr[] = req.getParameterValues("price_arr");
		String discount_arr[] = req.getParameterValues("discount_arr");
		String point_arr[] = req.getParameterValues("point_arr");
		String delivery_arr[] = req.getParameterValues("delivery_arr");
		
		OrderItemVO oiv = new OrderItemVO();
		oiv.setProdNo(0);
		oiv.setCount(0);
		oiv.setPrice(0);
		oiv.setDiscount(0);
		oiv.setPoint(0);
		oiv.setDelivery(0);
		oiv.setTotal(0);
		
		ProductDAO.getInstance().Insert_Product_OrderItem(oiv);
		
		
	}
}