package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.vo.MemberVO;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/login.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 수신
		String uid  = req.getParameter("uid");
		String pass = req.getParameter("pass");
		
		//데이터베이스 처리
		 MemberVO mv = MemberDAO.getInstance().Select_Member(uid, pass);
		 
		 //로그인 처리
		 if(mv != null) {
			 //회원O
			HttpSession session = req.getSession(); // 현재 클라이언트 세션 구함
			session.setAttribute("sessUser", mv);
			 
			resp.sendRedirect("/kmarket/index.do");
			 
		 }else {
			 //회원 아님
			 resp.sendRedirect("/kmarket/member/login.do?succuss=100");
		 }
	}
}
