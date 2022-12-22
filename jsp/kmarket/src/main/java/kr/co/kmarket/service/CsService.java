package kr.co.kmarket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.CsDAO;
import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.vo.ArticleVO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.TermsVO;


public enum CsService {
	INSTANCE;
	private CsDAO dao = CsDAO.getInstance();
	
	private Logger  logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	// 문의글 작성
	public int insertArticle(ArticleVO article) {
		logger.info("service-insertArticle...");
		return dao.insertArticle(article);
	}
	
	
	/*** cs - list ***/
	// 현재 페이지 번호
	public int getCurrentPage(String pg) {
		int currentPage = 1;	// 현재 페이지 기본값
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	// 전체 게시물 개수
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	// 마지막 페이지 번호
	public int getLastPageNum(int total) {
		int lastPageNum = 0; // 마지막 페이지
		if(total % 10 == 0) {
			lastPageNum = (total/10);
		}else {
			lastPageNum = (total/10)+1;
		}
		return lastPageNum;
	}
	// 현재 페이지 게시글 시작값 
	public int getLimitStart(int currentPage) {
		int limitStart = 0;
		limitStart = (currentPage-1)*10;
		return limitStart;
	}
	// 페이지 그룹 
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
	// 페이지 시작 번호
	public int getPageStartNum(int total, int limitStart) {
		int pageStartNum = 0;
		pageStartNum = total - limitStart;
		return pageStartNum;
	}
	// 게시글 번호 정렬
	public int getStartNum(int currentPage) {
		return (currentPage-1)*10;
	}
	
	// 페이지 글 가져오기
	public List<ArticleVO> selectArticles(String cate, int start){
		return dao.selectArticles(cate, start);
	}
}
