package kr.co.kmarket.controller.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
@WebServlet("/admin/lndex.do")
public class AdminIndexController {
private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletRequest resp) throws ServletException, IOException {
		@SuppressWarnings("unused")
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/lndex.jsp");
		
	}	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}


