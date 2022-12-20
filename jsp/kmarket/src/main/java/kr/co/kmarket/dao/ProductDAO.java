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
import kr.co.kmarket.vo.CartVO;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.ProductVO;

public class ProductDAO extends DBHelper{
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	private ProductDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ProductVO SelectProductView(String proNo) {
		
		ProductVO pv = null;
		
		try {
			logger.info("SelectProductView start...");
			
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_VIEW);
			psmt.setString(1, proNo);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				pv = new ProductVO();
				
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
				pv.setC1Name(rs.getString(33));
				pv.setC2Name(rs.getString(34));
						
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
			logger.error("SelectProductView error!!!");
		}	
		return pv;
	}
	
	public int InsertProductCart(CartVO cart) {
		
		int result = 0;
		
		try {
			logger.info("Insert Product Cart Start...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.Insert_Product_Cart);
			psmt.setString(1, cart.getUid());
			psmt.setInt(2, cart.getProNo());
			psmt.setInt(3, cart.getCount());
			psmt.setInt(4, cart.getPrice());
			psmt.setInt(5, cart.getDiscount());
			psmt.setInt(6, cart.getDelivery());
			result = psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
}

