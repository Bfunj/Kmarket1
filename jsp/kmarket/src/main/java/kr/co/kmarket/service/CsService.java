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
}
