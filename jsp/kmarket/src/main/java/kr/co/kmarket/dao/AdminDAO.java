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
import kr.co.kmarket.vo.ProductVO;

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
	
	//admin insert product
	public void INSERT_ADMIN_PRODUCT(ProductVO pv) {
		
		try {
			logger.info("insert admin product start...");
			
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ADMIN_PRODUCT);
			psmt.setString(1, pv.getProName());
			psmt.setString(2, pv.getDescript());
			psmt.setString(3, pv.getCompany());
			psmt.setInt(4, pv.getPrice());
			psmt.setInt(5, pv.getDiscount());
			psmt.setInt(6, pv.getPoint());
			psmt.setInt(7, pv.getStock());
			psmt.setInt(8, pv.getDelivery());
			psmt.setString(9, pv.getThumb1());
			psmt.setString(10, pv.getThumb2());
			psmt.setString(11, pv.getThumb3());
			psmt.setString(12, pv.getDetail());
			psmt.setString(13, pv.getStatus());
			psmt.setString(14, pv.getDuty());
			psmt.setString(15, pv.getRecipt());
			psmt.setString(16, pv.getOrigin());
			psmt.setString(17, pv.getIp());
			psmt.executeUpdate();
			clone();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}
