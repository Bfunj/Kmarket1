package kr.co.kmarket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsDAO {
	private static CsDAO instance = new CsDAO();
	
	public static CsDAO getInstance() {
		return instance;
	}
	
	private CsDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
}
