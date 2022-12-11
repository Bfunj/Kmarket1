package kr.co.kmarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.TermsVO;

public class MemberDAO extends DBHelper{
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void InsertMember(MemberVO mv) {
		
		try {
			logger.info("insert member start...");
			
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.Insert_Member);
			psmt.setString(1, mv.getUid());
			psmt.setString(2, mv.getPass());
			psmt.setString(3, mv.getName());
			psmt.setInt(4, mv.getGender());
			psmt.setString(5, mv.getEmail());
			psmt.setString(6, mv.getHp());
			psmt.setString(7, mv.getZip());
			psmt.setString(8, mv.getAddr1());
			psmt.setString(9, mv.getAddr2());
			psmt.setString(10, mv.getRegip());
			psmt.executeUpdate();
			close();
			
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public TermsVO SelectTerms() {
		
		TermsVO tv = null;
		
		try {
			logger.info("select terms start...");
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
			
			if(rs.next()) {
				tv = new TermsVO();
				tv.setTerms(rs.getString(1));
				tv.setPrivacy(rs.getString(2));
				tv.setLocation(rs.getString(3));
				tv.setFinance(rs.getString(4));
				tv.setTax(rs.getString(5));
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return tv;
	}
}
