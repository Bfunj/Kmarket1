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
			logger.error("cate1 error..");
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
			logger.error("cate2 error..");
		}
		return cate2s;
	}
	
	//admin insert product
	public void INSERT_ADMIN_PRODUCT(ProductVO pv) {
		
		try {
			logger.info("insert admin product start...");
			
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ADMIN_PRODUCT);
			psmt.setInt(1, pv.getCate1());
			psmt.setInt(2, pv.getCate2());
			psmt.setString(3, pv.getProName());
			psmt.setString(4, pv.getDescript());
			psmt.setString(5, pv.getCompany());
			psmt.setInt(6, pv.getPrice());
			psmt.setInt(7, pv.getDiscount());
			psmt.setInt(8, pv.getPoint());
			psmt.setInt(9, pv.getStock());
			psmt.setInt(10, pv.getDelivery());
			psmt.setString(11, pv.getThumb1());
			psmt.setString(12, pv.getThumb2());
			psmt.setString(13, pv.getThumb3());
			psmt.setString(14, pv.getDetail());
			psmt.setString(15, pv.getStatus());
			psmt.setString(16, pv.getDuty());
			psmt.setString(17, pv.getRecipt());
			psmt.setString(18, pv.getOrigin());
			psmt.setString(19, pv.getIp());
			psmt.executeUpdate();
			clone();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
	
		}
	}
	
	// 상품 불러오기
	
	public List<ProductVO> SelectProduct() {
		
		List<ProductVO> listProduct = new ArrayList<>();
		
		try {
			logger.info("SelectProduct start...");
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(Sql.SELECT_PRODUCT);
			
			while(rs.next()) {
				ProductVO pv = new ProductVO();
				
				pv.setProNo(rs.getInt(1));
				pv.setCate1(rs.getInt(2));
				pv.setCate2(rs.getInt(3));
				pv.setProName(rs.getString(4));
				pv.setDescript(rs.getString(5));
				pv.setCompany(rs.getString(6));
				pv.setSeller(rs.getString(7));
				pv.setPrice(rs.getInt(8));
				pv.setDiscount(rs.getInt(9));
				pv.setPoint(rs.getInt(10));
				pv.setStock(rs.getInt(11));
				pv.setSold(rs.getInt(12));
				pv.setDelivery(rs.getInt(13));
				pv.setHit(rs.getInt(14));
				pv.setScore(rs.getInt(15));
				pv.setReviw(rs.getInt(16));
				pv.setThumb1(rs.getString(17));
				pv.setThumb2(rs.getString(18));
				pv.setThumb3(rs.getString(19));
				pv.setDetail(rs.getString(20));
				pv.setStatus(rs.getString(21));
				pv.setDuty(rs.getString(22));
				pv.setRecipt(rs.getString(23));
				pv.setBizType(rs.getString(24));
				pv.setOrigin(rs.getString(25));
				pv.setIp(rs.getString(26));
				pv.setRdate(rs.getString(27));
				pv.setEtc1(rs.getInt(28));
				pv.setEtc2(rs.getInt(29));
				pv.setEtc3(rs.getString(30));
				pv.setEtc4(rs.getString(31));
				pv.setEtc5(rs.getString(32));
				
				listProduct.add(pv);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return listProduct;
	}
	

}
