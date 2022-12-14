package kr.co.kmarket.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
	// 경로 설정
	public MultipartRequest uploadFile(HttpServletRequest req, String path) throws IOException {
		int maxSize = 1024 * 1024 * 10; // 최대 파일 업로드 허용량 10MB
		return new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	}
	public MultipartRequest uploadFile2(HttpServletRequest req, String path) throws IOException {
		int maxSize = 1024 * 1024 * 10; // 최대 파일 업로드 허용량 10MB
		return new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	}
	// 파일명 수정
	public String renameFile(String thumbName, String path) {

		// 파일명 수정
		int idx = thumbName.lastIndexOf(".");
		String ext = thumbName.substring(idx);
			
		String now = UUID.randomUUID().toString();
		String newName = now+ext; // random.txt 
		
		File oriFile = new File(path+"/"+thumbName);
		File newFile = new File(path+"/"+newName);		
		
		oriFile.renameTo(newFile);
		
		return newName;
	}
	
	public List<ProductVO> SelectProduct(int code) {
		return dao.SelectProduct(code);
	}
}
