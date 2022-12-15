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
	
	public void InsertMemberSeller(MemberVO vo) {
		
		try {
			logger.info("insert MemberSeller start...");
			
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_Member_Seller);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getCompany());
			psmt.setString(4, vo.getCeo());
			psmt.setString(5, vo.getBizRegNum());
			psmt.setString(6, vo.getComRegNum());
			psmt.setString(7, vo.getTel());
			psmt.setString(8, vo.getFax());
			psmt.setString(9, vo.getEmail());
			psmt.setString(10, vo.getZip());
			psmt.setString(11, vo.getAddr1());
			psmt.setString(12, vo.getAddr2());
			psmt.setString(13, vo.getManager());
			psmt.setString(14, vo.getManagerHp());
			psmt.setString(15, vo.getRegip());
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
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
	
	public TermsVO selectTermsSeller () {
		TermsVO vo = null;
		
		try {
			logger.info("selectTermsSeller start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_TERMS);
			
			if(rs.next()) {
				vo = new TermsVO();
				vo.setPrivacy(rs.getString(2));
				vo.setLocation(rs.getString(3));
				vo.setFinance(rs.getString(4));
				vo.setTax(rs.getString(5));
			}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		logger.debug("vo : " + vo);
		return vo;
	}

	
	public int selectCountUid(String uid) {
		
		int result = 0;
		
		try {
			logger.info("selectCheckUid");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.debug("result : " + result);
		
		return result;
	}
	
	public MemberVO Select_Member (String uid, String pass) {
		
		MemberVO mv = null;
		
		try {
			logger.info("Select Member Start...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.Select_Member);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mv = new MemberVO();
				mv.setUid(rs.getString(1));
				mv.setPass(rs.getString(2));
				mv.setName(rs.getString(3));
				mv.setGender(rs.getString(4));
				mv.setEmail(rs.getString(5));
				mv.setHp(rs.getString(6));
				mv.setType(rs.getInt(7));
				mv.setPoint(rs.getInt(8));
				mv.setLevel(rs.getInt(9));
				mv.setZip(rs.getString(10));
				mv.setAddr1(rs.getString(11));
				mv.setAddr2(rs.getString(12));
				mv.setCompany(rs.getString(13));
				mv.setCeo(rs.getString(14));
				mv.setBizRegNum(rs.getString(15));
				mv.setComRegNum(rs.getString(16));
				mv.setTel(rs.getString(17));
				mv.setManager(rs.getString(18));
				mv.setManagerHp(rs.getString(19));
				mv.setFax(rs.getString(20));
				mv.setRegip(rs.getString(21));
				mv.setWdate(rs.getString(22));
				mv.setRdate(rs.getString(23));
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return mv;
	}
	
	public MemberVO SelectMemberForChangeInfo(String uid) {
		
		MemberVO mv = null;
		
		try {
			logger.info("Select Member For ChangeInfo Start..");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.Select_Member_For_Change_Info);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mv = new MemberVO();
				mv.setUid(rs.getString(1));
				mv.setPass(rs.getString(2));
				mv.setName(rs.getString(3));
				mv.setGender(rs.getString(4));
				mv.setEmail(rs.getString(5));
				mv.setHp(rs.getString(6));
				mv.setType(rs.getInt(7));
				mv.setPoint(rs.getInt(8));
				mv.setLevel(rs.getInt(9));
				mv.setZip(rs.getString(10));
				mv.setAddr1(rs.getString(11));
				mv.setAddr2(rs.getString(12));
				mv.setCompany(rs.getString(13));
				mv.setCeo(rs.getString(14));
				mv.setBizRegNum(rs.getString(15));
				mv.setComRegNum(rs.getString(16));
				mv.setTel(rs.getString(17));
				mv.setManager(rs.getString(18));
				mv.setManagerHp(rs.getString(19));
				mv.setFax(rs.getString(20));
				mv.setRegip(rs.getString(21));
				mv.setWdate(rs.getString(22));
				mv.setRdate(rs.getString(23));
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return mv;
	}
	
	public int UpdateUserPassword(String uid, String pass) {
		
		int result = 0;
		
		try {
			logger.info("UpdateUserPassword Start... ");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_USER_PASSWORD);
			psmt.setString(1, pass);
			psmt.setString(2, uid);
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public void UpdateMemberInfo(MemberVO mv) {
		
		try {
			logger.info("Update Member Info Start...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.Update_Member_Info);
			psmt.setString(1, mv.getName());
			psmt.setInt(2, mv.getGender());
			psmt.setString(3, mv.getEmail());
			psmt.setString(4, mv.getHp());
			psmt.setString(5, mv.getZip());
			psmt.setString(6, mv.getAddr1());
			psmt.setString(7, mv.getAddr2());
			psmt.setString(8, mv.getUid());
			psmt.executeUpdate();
			
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	
}
