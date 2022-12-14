package kr.co.kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket.dao.AdminDAO;
import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;
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
		
		String cate1s =  req.getParameter("category1"); 
		String cate2s =  req.getParameter("category2"); 
		
		System.out.println("cate1s" + cate1s);
		System.out.println("cate2s" + cate2s);
		
		// 파일 경로 설정
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/file/10/10");
		//String path = ctx.getRealPath("/file/"+cate1s+"/"+cate2s);
		MultipartRequest mr = service.uploadFile(req, path);

		String thumb1Name = service.renameFile(mr.getFilesystemName("thumb1"), path);
		String thumb2Name = service.renameFile(mr.getFilesystemName("thumb2"), path);
		String thumb3Name = service.renameFile(mr.getFilesystemName("thumb3"), path);
		String detailName = service.renameFile(mr.getFilesystemName("detail"), path);
		
		//데이터 수신
		String cate1 		= mr.getParameter("category1");
		String cate2 		= mr.getParameter("category2");
		String proName 		= mr.getParameter("proName");
		String descript 	= mr.getParameter("descript");
		String company 		= mr.getParameter("company");
		String price 		= mr.getParameter("price");
		String discount 	= mr.getParameter("discount");
		String point 		= mr.getParameter("point");
		String stock 		= mr.getParameter("stock");
		String delivery 	= mr.getParameter("delivery");
		String thumb1 		= thumb1Name;
		String thumb2 		= thumb2Name;
		String thumb3 		= thumb3Name;
		String detail 		= detailName;
		String status 		= mr.getParameter("status");
		String duty 		= mr.getParameter("duty");
		String recipt 		= mr.getParameter("recipt");
		String origin 		= mr.getParameter("origin");
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
