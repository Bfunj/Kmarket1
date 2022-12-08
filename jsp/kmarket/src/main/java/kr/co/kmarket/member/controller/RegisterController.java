package kr.co.kmarket.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.member.dao.MemberDAO;
import kr.co.kmarket.vo.MemberVO;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/register.jsp");
		dispatcher.forward(req, resp);
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 수신
		String uid = req.getParameter("km_uid");
		String pass1 = req.getParameter("km_pass1");
		String pass2 = req.getParameter("km_pass2");
		String name = req.getParameter("km_name");
		String gender = req.getParameter("km_gender");
		String hp = req.getParameter("km_hp");
		String email = req.getParameter("km_email");
		String addr1 = req.getParameter("km_addr1");
		String addr2 = req.getParameter("km_addr2");
		String regip = req.getRemoteAddr();
		
		// 데이터 생성
		MemberVO member = new MemberVO();
		member.setUid(uid);
		member.setPass(pass1);
		member.setName(name);
		member.setGender(gender);
		member.setHp(hp);
		member.setEmail(email);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setRegip(regip);
		
		//데이터베이스 처리
		MemberDAO.getinstance().InsertMember(member);
		
		//리다이렉트
		resp.sendRedirect("/kmarket/index.jsp");
		
	}
}
