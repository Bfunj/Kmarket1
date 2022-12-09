package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.AdminDAO;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;

public enum AdminService {
	instance;
	private AdminDAO dao = AdminDAO.getInstance();
	
	
	// 카테고리1 정보 불러오기
	public  List<Cate1VO> selectCate1s() {
		return dao.selectCate1s();
	}
	// 카테고리2 정보 불러오기
	public  List<Cate2VO> selectCate2s(String cate1) {
		return dao.selectCate2s(cate1);
	}

}
