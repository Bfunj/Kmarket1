package kr.co.kmarket.controller.admin;

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

@WebServlet("/admin/register.do")
public class RegisterController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.instance;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Cate1VO> cateVO = service.selectCate1s();
		req.setAttribute("cateVO", cateVO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/register.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
