package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.service.ProductService;

@WebServlet("/product/CartPrice.do")
public class CartPriceController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cartNos[] = req.getParameterValues("arr");
		int price =0;
		for(String cartNo : cartNos) {
			price += service.CartPrice(cartNo);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("price", price);
		
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		
	}

}