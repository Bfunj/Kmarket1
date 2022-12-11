package kr.co.kmarket.service;

import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.TermsVO;


public enum MemberService {
	INSTANCE;
	private MemberDAO dao = MemberDAO.getInstance();
	
	public void InsertMember(MemberVO mv) {
		dao.InsertMember(mv);
	}
	public TermsVO SelectTerms() {
		return dao.SelectTerms();
	}
}
