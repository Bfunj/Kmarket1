package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.ArticleVO;
import kr.co.kmarket.vo.Cate2VO;

@WebServlet("/cs/qna/writeCate.do")
public class QnaWriteCateController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/cs/qna/write.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//cate2 파라미터 수신
		String cate1 = req.getParameter("cate1");
		
		//cate2
		List<Cate2VO> cate2s = service.SelectCsCate2(cate1);
		req.setAttribute("cate2", cate2s);
		
		//json 출력
		Gson gson = new Gson();
		String jsonData = gson.toJson(cate2s);
		
		//인코딩 필터
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData.toString());
		
		
	}
}
