package kr.co.kmarket.controller.admin;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.Cate2VO;

@WebServlet("/admin/cate2Select.do")
public class Cate2SelectController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.instance;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String cate1 = req.getParameter("cate1");
		
		List<Cate2VO> cate2VO = service.selectCate2s(cate1);
		
		System.out.println("진행중");
		System.out.println(cate2VO.size());
	
		req.setAttribute("cate2VO", cate2VO);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(cate2VO);

	}
}
