package kr.co.kmarket.db;

public class Sql {
	
	//select cate1
	public static final String SELECT_CATE1 = " SELECT * FROM `km_product_cate1`"; 
	public static final String SELECT_CATE1_NAME = " SELECT * FROM `km_product_cate1` where `cate1`= ? "; 
	
	//select cate2
	public static final String SELECT_CATE2 = " SELECT * FROM `km_product_cate2` where `cate1`=? ";
	public static final String SELECT_CATE2_ = " SELECT * FROM `km_product_cate2` ";
	public static final String SELECT_CATE2_NAME = " SELECT * FROM `km_product_cate2` where `cate1`= ? and `cate2`= ?"; 

	//select terms
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms` ";
	
	//select member
	public static final String Select_Member = "Select * from `km_member` where `uid` = ? and `pass` = SHA2(?, 256)";
	


	//insert admin product 
	public static final String INSERT_ADMIN_PRODUCT = "INSERT INTO `km_product` SET "
													+ "`cate1` = ?, "
													+ "`cate2` = ?, "
													+ "`proName` = ?, "
													+ "`descript` = ?, "
													+ "`company` = ?, "
													+ "`seller` = '판매자' ,"
													+ "`price` = ?, "
													+ "`discount` = ?, "
													+ "`point` = ?, "
													+ "`stock` = ?, "
													+ "`delivery` = ?, "
													+ "`thumb1` = ?, "
													+ "`thumb2` = ?, "
													+ "`thumb3` = ?, "
													+ "`detail` = ?, "
													+ "`status` = ?, "
													+ "`duty` = ?, "
													+ "`receipt` = ?, "
													+ "`origin` = ?, "
													+ "`ip` = ?, "
													+ "`rdate`=NOW()"; 
													//seller not null 이라 임의의 데이터 입력
													//나중에 수정 해야함
	
	//insert member
	public static final String Insert_Member =  "INSERT INTO `km_member` SET   "
												+ "`uid` 	= ? , "
												+ "`pass` 	= SHA2(?,256) , "
												+ "`name` 	= ? , "
												+ "`gender` = ? , "
												+ "`email` 	= ? , "
												+ "`hp` 	= ? , "
												+ "`type` 	= 1 , " 
												// 타입 not null 이라 임의의 데이터 입력
												+ "`zip` 	= ? , "
												+ "`addr1` 	= ? ,"
												+ "`addr2` 	= ? , "
												+ "`regip` 	= ? , "
												+ "`rdate` 	= NOW()";
	
	public static final String INSERT_Member_Seller = "INSERT INTO `km_member` SET "
													 + " `uid`=?, "
													 + " `pass`=SHA2(?, 256), "
													 + " `name`=1, "
													 // 네임 not null 이라 임의의 데이터 입력
													 + " `hp`=1, "
													 // 폰번호 not null 이라 임의의 데이터 입력
													 + " `company`=?, "
													 + " `ceo`=?, "
													 + " `gender`=3, "
													 // 젠더 not null 이라 임의의 데이터 입력
													 + " `type`=1, "
													 // 타입 not null 이라 임의의 데이터 입력
													 + " `bizRegNum`=?, "
													 + " `comRegNum`=?, "
													 + " `tel`=?, "
													 + " `fax`=?, "
													 + " `email`=?, "
													 + " `zip`=?, "
													 + " `addr1`=?, "
													 + " `addr2`=?, "
													 + " `manager`=?, "
													 + " `managerHp`=?, "
													 + " `regip`=?, "
													 + " `rdate`=NOW() ";
	
	public static final String Select_Product_Carts = "SELECT b.proName,b.descript,a.*,b.thumb1,b.cate1,b.cate2 FROM `km_product_cart` AS a JOIN "
												+ "`km_product` AS b on a.proNo = b.proNo WHERE `uid` = ? ";
	
	public static final String Insert_Product_Cart = "INSERT INTO `km_product_cart` SET "
													+ "`uid` = ?  ,"
													+ "`proNo` = ? , "
													+ "`count` = ? , "
													+ "`price` = ? , "
													+ "`discount` = ? , "
													+ "`point` = 1 , "
													+ "`delivery` = ? , "
													+ "`total` = (price - (price * discount * 0.01)) * count + delivery , " //total 값 계산하기
													+ "`rdate` = NOW()";
	
	public static final String Select_Product_Cart = "SELECT COUNT('proNo') FROM `km_product_cart` WHERE `uid` = ? and `proNo` = ? ";
	
	public static final String Update_Product_Cart_Count = "UPDATE `km_product_cart` SET `count` = `count` + ? , "
														+ "`total` = (price - (price * discount * 0.01)) * count + delivery "
														+ "WHERE uid= ? AND `proNo`= ? ";
	
	public static final String SELECT_COUNT_UID  	= "select count(`uid`) from `km_member` where `uid`=?";
	public static final String SELECT_PRODUCT  		= "SELECT * FROM `km_product` ORDER BY `score` DESC";
	public static final String SELECT_PRODUCT_HIT  	= "SELECT * FROM `km_product` ORDER BY `hit` DESC";
	public static final String SELECT_PRODUCT_NOW  	= "SELECT * FROM `km_product` ORDER BY `rdate` DESC";
	public static final String SELECT_PRODUCT_DISCOUNT  	= "SELECT * FROM `km_product` WHERE `discount` >'0' ORDER BY `discount` DESC";
	public static final String SELECT_PRODUCT_BEST  	= "SELECT * FROM `km_product` ORDER BY `sold` DESC ";
	
	// select 상품 갯수
	public static final String SELECT_PRODUCT_COUNT_TOTAL = "SELECT COUNT(`proNo`) FROM `km_product` where `cate1`=? and `cate2`=? ";	
	
	public static final String SELECT_PRODUCT_LIST_CATE_SOLD ="SELECT * FROM `km_product` where `cate1`=? and `cate2`=? ORDER BY `sold` desc LIMIT ?, 10";
	public static final String SELECT_PRODUCT_LIST_CATE_PRICE_A ="SELECT * FROM `km_product` where `cate1`=? and `cate2`=? ORDER BY `price` ASC LIMIT ?, 10";
	public static final String SELECT_PRODUCT_LIST_CATE_PRICE_D ="SELECT * FROM `km_product` where `cate1`=? and `cate2`=? ORDER BY `price` DESC LIMIT ?, 10";
	public static final String SELECT_PRODUCT_LIST_CATE_SCORE ="SELECT * FROM `km_product` where `cate1`=? and `cate2`=? ORDER BY `score` DESC LIMIT ?, 10";
	public static final String SELECT_PRODUCT_LIST_CATE_REVIEW ="SELECT * FROM `km_product` where `cate1`=? and `cate2`=? ORDER BY `review` DESC LIMIT ?, 10";
	public static final String SELECT_PRODUCT_LIST_CATE_RDATE ="SELECT * FROM `km_product` where `cate1`=? and `cate2`=? ORDER BY `rdate` desc LIMIT ?, 10";
	
	public static final String Select_Member_For_Change_Info = "select * from `km_member` where = `uid` = ? ";
	public static final String SELECT_MEMBER_BY_SESSID = "SELECT * FROM `km_member` WHERE `sessId`=? AND `sessDate` > NOW()";
	public static final String SELECT_PRODUCT_VIEW = "SELECT a.*, b.c1Name, c.c2Name FROM `km_product` AS a "

				+ " JOIN `km_product_cate1` AS b ON a.cate1 = b.cate1 "
				+ " JOIN `km_product_cate2` AS c ON a.cate1 = c.cate1 AND a.cate2 = c.cate2 "
				+ " WHERE `proNo` =?";
	

	public static final String UPDATE_MEMBER_PASSWORD = "update `km_member` set `pass`=SHA2(?, 256) where `uid`=?";
	public static final String UPDATE_MEBER_FOR_SESSION = "update `km_member` set `sessId`=?, `sessDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) where `uid`=?";
	public static final String UPDATE_MEMBER_FOR_SESSION_OUT = "update `km_member` set `sessId`=NULL, `sessDate`=NULL where `uid`=?";
	public static final String Update_Member_Info = "update `km_member` set "
															+ "`name` 	= ?, "
															+ "`gender` = ?, "
															+ "`email` 	= ?, "
															+ "`hp` 	= ?, "
															+ "`zip` 	= ?, "
															+ "`addr1` 	= ?, "
															+ "`addr2` 	= ?"
															+ "where `uid` = ? ";
		
	
	
	// article 쿼리문
	public static final String SELECT_ARTICLE_NOTICE = "SELECT *FROM `board_article` WHERE `cate` like 'notice%';";
	public static final String SELECT_ARTICLE_QNA = "SELECT *FROM `board_article` WHERE `cate` like 'qna%';";
	
	public static final String Delete_Cart = "DELETE FROM `km_product_cart` WHERE `cartNo` = ? ";
	
	public static final String CART_PRICE = "SELECT * FROM `km_product_cart`  WHERE `cartNo` = ? ";
	
	public static final String Select_Product_Order = "SELECT a.*,b.proName,b.descript,b.thumb1,b.cate1,b.cate2 FROM `km_product_cart` AS a "
													+ "JOIN `km_product` AS b "
													+ "ON a.proNo = b.proNo WHERE cartNo = ? ";
	
}


