package kr.co.kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD:jsp/kmarket/src/main/java/kr/co/kmarket/controller/admin/AdminindexController.java
@WebServlet("/admin/index.do")
public class AdminindexController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletRequest resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/index.jsp");
		
	}	
=======

@WebServlet("/admin/lndex.do")
public class AdminIndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/index.jsp");
		dispatcher.forward(req, resp);
	}
>>>>>>> 5da3876482e3578b56a9bac175bb334ac58fd7f3:jsp/kmarket/src/main/java/kr/co/kmarket/controller/admin/AdminIndexController.java
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}



