package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.CookieNotFoundException;


@WebServlet("/member/logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("LogoutController...0");
		String uid = req.getParameter("uid");
		
		// 세션 제거
		HttpSession session = req.getSession();
		//session.removeAttribute("sessUser");
		session.invalidate();
		logger.info("LogoutController...1 : " + session);
		
		// 쿠키 제거
		Cookie cookie = new Cookie("SESSID", null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		logger.info("LogoutController...2");
		
		// 데이터베이스 세션 로그아웃
		MemberDAO.getInstance().updateUserForSessionOut(uid);
		logger.info("LogoutController...3");
		
		resp.sendRedirect("/kmarket/member/login.do?success=201");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}

