package kr.co.kmarket.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.xdevapi.Result;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;


public class AdminDAO extends DBHelper{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}
	
	
	// 카테고리 1 정보 불러오기
	public List<Cate1VO> selectCate1s() {
		
		List<Cate1VO> cate1V = new ArrayList<>();
		
		try {
			logger.info("selectCate1s...");
			
			conn =getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_CATE1);
			
			while(rs.next()) {
				Cate1VO cate1 = new Cate1VO();
				
				cate1.setCate1(rs.getInt(1));
				cate1.setC1Name(rs.getString(2));
				
				cate1V.add(cate1);		
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate1V;
	}
	
	// 카테고리 2 정보 불러오기
	public List<Cate2VO> selectCate2s(String cate1) {
		
		List<Cate2VO> cate2V = new ArrayList<>();
		
		try {
			logger.info("selectCate2s...");
			
			conn =getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_CATE2);
			psmt.setString(1, cate1);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				
				cate2.setCate1(rs.getInt(1));
				cate2.setCate2(rs.getInt(2));
				cate2.setC2Name(rs.getString(3));
	
				cate2V.add(cate2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2V;
	}
	
	
}
