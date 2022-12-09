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
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;

public class AdminDAO extends DBHelper{
	
	private static AdminDAO instance = new AdminDAO();
	
	public static AdminDAO getInstance() {
		return instance;
	}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//admin category1
	public List<Cate1VO> SelectAdminProduct1() {
		
		List<Cate1VO> cate1s = new ArrayList<>();
		
		try {
			logger.info("select cate1 start...");
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_CATE1);
			
			while(rs.next()) {
				Cate1VO cate1 = new Cate1VO();
				cate1.setCate1(rs.getInt(1));
				cate1.setC1Name(rs.getString(2));
				
				cate1s.add(cate1);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate1s;
	}
	
	//admin category2
	public List<Cate2VO> SelectAdminProduct2(String cate1) {
		
		List<Cate2VO> cate2s = new ArrayList<>();
		
		try {
			logger.info("select cate2 start...");
			
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_CATE2);
			psmt.setString(1, cate1);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				cate2.setCate1(rs.getInt(1));
				cate2.setCate2(rs.getInt(2));
				cate2.setC2Name(rs.getString(3));
				
				cate2s.add(cate2);
			}
			clone();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2s;
	}
}
