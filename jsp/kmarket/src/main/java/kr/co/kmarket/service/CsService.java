package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.CsDAO;
import kr.co.kmarket.vo.ArticleVO;


public enum CsService {
	INSTANCE;
	private CsDAO dao = CsDAO.getInstance();
	
	public List<ArticleVO> SelectArticleNotice() {
		return dao.SelectArticleNotice();
	}
	public List<ArticleVO> SelectArticleQna() {
		return dao.SelectArticleQna();
	}
	public int insertArticle(ArticleVO article) {
		return dao.insertArticle(article);
	}
	public List<ArticleVO> selectArticles(String cate, int start){
		return dao.selectArticles(cate,start);
	}
	public int getCurrentPage(String pg) {
		int currentPage = 1;	// 현재 페이지 기본값
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 10 == 0) {
			lastPageNum = (total/10);
		}else {
			lastPageNum = (total/10)+1;
		}
		return lastPageNum;
	}
	public int getLimitStart(int currentPage) {
		int limitStart = 0;
		limitStart = (currentPage-1)*10;
		return limitStart;
	}
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		int pageGroupCurrent = (int) Math.ceil(currentPage/10.0);
		int pageGroupStart = (pageGroupCurrent - 1)*10+1;
		int pageGroupEnd = pageGroupCurrent * 10;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		
		int[] result = {pageGroupStart,pageGroupEnd};
		return result;
	}
	public int getPageStartNum(int total, int limitStart) {
		int pageStartNum = 0;
		pageStartNum = total - limitStart;
		return pageStartNum;
	}
	public int getStartNum(int currentPage) {
		return (currentPage-1)*10;
	}
}
