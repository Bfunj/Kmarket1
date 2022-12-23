package kr.co.kmarket.dao;

import java.sql.PreparedStatement;
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
import kr.co.kmarket.vo.Cate2VO;


public class CsDAO  extends DBHelper {
	private static CsDAO instance = new CsDAO();
	
	public static CsDAO getInstance() {
		return instance;
	}
	
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertArticle(ArticleVO article) {
		int parent = 0;
		try{
			logger.info("insertArticle start...");
			conn = getConnection();
			
			// 트랜젝션 시작
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			
			psmt.setString(1, article.getCate());
			psmt.setString(2, article.getTitle());
			psmt.setString(3, article.getContent());
			psmt.setString(4, article.getUid());
			psmt.setString(5, article.getRegip());
			
			psmt.executeUpdate(); // INSERT
			rs = stmt.executeQuery(Sql.SELECT_MAX_NO); // SELECT
			
			// 작업확정
			conn.commit(); 
			
			if(rs.next()){
				parent = rs.getInt(1);				
			}
			
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return parent;
	}
	
	public List<ArticleVO> selectArticles(String cate, int start) {
		
		List<ArticleVO> articles = new ArrayList<>();	
		
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				
				articles.add(article);
			}
			close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return articles;
	}
	
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
	
	public int selectCountTotal(String cate) {
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			while(rs.next()) {
				total = rs.getInt(1);
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	
	//admin category1
	public List<Cate1VO> SelectCsCate1() {
		
		List<Cate1VO> cate1s = new ArrayList<>();
		
		try {
			logger.info("select cate1 start...");
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_CATE1_CS);
			
			while(rs.next()) {
				Cate1VO cate1 = new Cate1VO();
				cate1.setCate1(rs.getInt(1));
				cate1.setC1Name(rs.getString(2));
				
				cate1s.add(cate1);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			logger.error("cate1 error..");
		}
		return cate1s;
	}
	
	public List<Cate2VO> SelectCsCate2(String cate1) {
		
		List<Cate2VO> cate2s = new ArrayList<>();
		
		try {
			logger.info("select cate2 start...");
			
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_CATE2_CS);
			psmt.setString(1, cate1);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				cate2.setCate1(rs.getInt(1));
				cate2.setCate2(rs.getInt(2));
				cate2.setC2Name(rs.getString(3));
				
				cate2s.add(cate2);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2s;
	}
	
}
