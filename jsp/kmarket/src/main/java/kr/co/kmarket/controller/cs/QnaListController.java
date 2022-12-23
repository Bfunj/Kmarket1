package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.ArticleVO;

@WebServlet("/cs/qna/list.do")
public class QnaListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("category1");
		String cate2 = req.getParameter("category2");
		String pg = req.getParameter("pg");
		
		int currentPage = service.getCurrentPage(pg);
		int total = service.selectCountTotal(cate1);
		int lastPageNum = service.getLastPageNum(total);
		int limitStart = service.getLimitStart(currentPage);
		int [] result = service.getPageGroupNum(currentPage, lastPageNum);
		int pageStartNum = service.getPageStartNum(total, limitStart);
		int start = service.getStartNum(currentPage);
		
		
		// 페이지 글 가져오기
		List<ArticleVO> articles = service.selectQnaArticles(cate1, cate2, start);
		

		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("articles", articles);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("limitStart", limitStart);
		req.setAttribute("pageStartNum", pageStartNum+1);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/cs/qna/list.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
