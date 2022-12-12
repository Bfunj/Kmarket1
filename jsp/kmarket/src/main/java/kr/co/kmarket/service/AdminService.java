package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.AdminDAO;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;
import kr.co.kmarket.vo.ProductVO;

public enum AdminService {
	INSTANCE;
	private AdminDAO dao = AdminDAO.getInstance();
	
	public List<Cate1VO> SelectAdminProduct1() {
		return dao.SelectAdminProduct1();
	}
	
	public List<Cate2VO> SelectAdminProduct2(String cate1) {
		return dao.SelectAdminProduct2(cate1);
	}
	public void INSERT_ADMIN_PRODUCT(ProductVO pv) {
		dao.INSERT_ADMIN_PRODUCT(pv);
	}
}
