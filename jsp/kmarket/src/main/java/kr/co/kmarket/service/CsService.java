package kr.co.kmarket.service;

import kr.co.kmarket.dao.CsDAO;
import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.TermsVO;


public enum CsService {
	INSTANCE;
	private CsDAO dao = CsDAO.getInstance();
	

}
