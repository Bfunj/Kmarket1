package kr.co.kmarket.dao;

import java.sql.Connection;
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

public class CsDAO extends DBHelper{
	private static CsDAO instance = new CsDAO();
	
	public static CsDAO getInstance() {
		return instance;
	}
	
	private CsDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
public int insertArticle(ArticleVO article) {
		
		int result = 0;
		
		try {
			
			logger.info("insertArticle...");
			
			Connection con = getConnection();
			
			con.setAutoCommit(false);
			
			PreparedStatement psmt = con.prepareStatement(Sql.INSERT_ARTICLE);
			Statement stmt = con.createStatement();
			
			psmt.setString(1, article.getCate());
			psmt.setString(2, article.getTitle());
			psmt.setString(3, article.getContent());
			psmt.setString(4, article.getUid());
			psmt.setString(5, article.getRegip());

			psmt.executeUpdate();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_NO);

			con.commit();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			rs.close();
			psmt.close();
			con.close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	// 전체 게시물 개수
		public int selectCountTotal(String cate) {
			int total = 0;
			try {
				logger.info("selectCountTotal...");
				
				Connection conn = getConnection();
				
				PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL);
				psmt.setString(1, cate);
				ResultSet rs = psmt.executeQuery();
				
				while(rs.next()) {
					total = rs.getInt(1);
				}
				
				rs.close();
				psmt.close();
				conn.close();
				
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return total;
		}
		
		// 페이지 글 가져오기
		public List<ArticleVO> selectArticles(String cate, String group, int start){
			List<ArticleVO> articles = new ArrayList<>();
			try {
				logger.info("selectArticles...");
				
				Connection conn = getConnection();
				PreparedStatement psmt = null;
				
				if(group == null) {
					 psmt = conn.prepareStatement(Sql.SELECT_WHOLE_ARTICLES);
					 psmt.setInt(1, start);
				}else {
					psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
					psmt.setString(1, cate);
					psmt.setString(2, group);
					psmt.setInt(3, start);
				}
				
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					ArticleVO article = new ArticleVO();
					article.setNo(rs.getInt(1));
					article.setParent(rs.getInt(2));
					article.setCate(rs.getString(3));
					article.setTitle(rs.getString(4));
					article.setContent(rs.getString(5));
					article.setUid(rs.getString(6));
					article.setRegip(rs.getString(7));
					article.setRdate(rs.getString(8));
					
					articles.add(article);
					
				}
				rs.close();
				psmt.close();
				conn.close();
				
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return articles;
		}

}