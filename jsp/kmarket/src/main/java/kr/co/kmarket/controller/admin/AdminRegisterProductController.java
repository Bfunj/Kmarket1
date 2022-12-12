package kr.co.kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dao.AdminDAO;
import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/admin/registerProduct.do")
public class AdminRegisterProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//데이터 수신
			String cate1 		= req.getParameter("category1");
			String cate2 		= req.getParameter("category2");
			String proName 		= req.getParameter("proName");
			String descript 	= req.getParameter("descript");
			String company 		= req.getParameter("company");
			String price 		= req.getParameter("price");
			String discount 	= req.getParameter("discount");
			String point 		= req.getParameter("point");
			String stock 		= req.getParameter("stock");
			String delivery 	= req.getParameter("delivery");
			String thumb1 		= req.getParameter("thumb1");
			String thumb2 		= req.getParameter("thumb2");
			String thumb3 		= req.getParameter("thumb3");
			String detail 		= req.getParameter("detail");
			String status 		= req.getParameter("status");
			String duty 		= req.getParameter("duty");
			String recipt 		= req.getParameter("recipt");
			String origin 		= req.getParameter("origin");
			String ip 			= req.getRemoteAddr();
			
			//VO데이터 설정
			ProductVO pv = new ProductVO();
			pv.setCate1(cate1);
			pv.setCate2(cate2);
			pv.setProName(proName);
			pv.setDescript(descript);
			pv.setCompany(company);
			pv.setPrice(price);
			pv.setDiscount(discount);
			pv.setPoint(point);
			pv.setStock(stock);
			pv.setDelivery(delivery);
			pv.setThumb1(thumb1);
			pv.setThumb2(thumb2);
			pv.setThumb3(thumb3);
			pv.setDetail(detail);
			pv.setStatus(status);
			pv.setDuty(duty);
			pv.setRecipt(recipt);
			pv.setOrigin(origin);
			pv.setIp(ip);
			
			//데이터베이스 처리
			service.INSERT_ADMIN_PRODUCT(pv);
			
			//리다이렉트
			resp.sendRedirect("/kmarket/index.do");
	}
}
