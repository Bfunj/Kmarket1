package kr.co.kmarket.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.vo.ArticleVO;
import kr.co.kmarket.vo.Cate1VO;


public class CsDAO  extends DBHelper {
	private static CsDAO instance = new CsDAO();
	
	public static CsDAO getInstance() {
		return instance;
	}
	
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<ArticleVO> SelectArticleNotice() {
		List<ArticleVO> ArticleNotice = new ArrayList<>();
		try {
			logger.info("SelectArticleNotice ...");
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_ARTICLE_NOTICE);
			while(rs.next()) {
				ArticleVO av = new ArticleVO();
				av.setNo(rs.getInt(1));
				av.setParent(rs.getInt(2));
				av.setComment(rs.getInt(3));
				av.setCate(rs.getString(4));
				av.setTitle(rs.getString(5));
				av.setContent(rs.getString(6));
				av.setFile(rs.getInt(7));
				av.setHit(rs.getInt(8));
				av.setUid(rs.getString(9));
				av.setRegip(rs.getString(10));
				av.setRdate(rs.getString(11));
				
				ArticleNotice.add(av);
			}
			close();
		}catch(Exception e) {
			logger.error("SelectArticleNotice error ...");			
			logger.error(e.getMessage());			
		}
		return ArticleNotice;
	}
	
	public List<ArticleVO> SelectArticleQna() {
		List<ArticleVO> ArticleQna = new ArrayList<>();
		try {
			logger.info("SelectArticleQna ...");
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_ARTICLE_QNA	);
			while(rs.next()) {
				ArticleVO av = new ArticleVO();
				av.setNo(rs.getInt(1));
				av.setParent(rs.getInt(2));
				av.setComment(rs.getInt(3));
				av.setCate(rs.getString(4));
				av.setTitle(rs.getString(5));
				av.setContent(rs.getString(6));
				av.setFile(rs.getInt(7));
				av.setHit(rs.getInt(8));
				av.setUid(rs.getString(9));
				av.setRegip(rs.getString(10));
				av.setRdate(rs.getString(11));
				
				ArticleQna.add(av);
			}
			close();
		}catch(Exception e) {
			logger.error("SelectArticleQna error ...");			
			logger.error(e.getMessage());			
		}
		return ArticleQna;
	}
}
