package kr.co.kmarket.db;

public class Sql {
	
	//select cate1
	public static final String SELECT_CATE1 = " SELECT * FROM `km_product_cate1`"; 
	
	//select cate2
	public static final String SELECT_CATE2 = " SELECT * FROM `km_product_cate2` where `cate1`=? ";
	
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
	
	public static final String SELECT_COUNT_UID  	= "select count(`uid`) from `km_member` where `uid`=?";
	public static final String SELECT_PRODUCT  		= "SELECT * FROM `km_product` ORDER BY `score` DESC";
	public static final String SELECT_PRODUCT_HIT  	= "SELECT * FROM `km_product` ORDER BY `hit` DESC";
	public static final String SELECT_PRODUCT_NOW  	= "SELECT * FROM `km_product` ORDER BY `rdate` DESC";
	public static final String SELECT_PRODUCT_DISCOUNT  	= "SELECT * FROM `km_product` WHERE `discount` >'0' ORDER BY `discount` DESC";
	public static final String SELECT_PRODUCT_BEST  	= "SELECT * FROM `km_product` ORDER BY `sold` DESC ";
	
	public static final String Select_Member_For_Change_Info = "select * from `km_member` where = `uid` = ? ";

	public static final String SELECT_PRODUCT_VIEW = "SELECT a.*, b.c1Name, c.c2Name FROM `km_product` AS a "
			+ " JOIN `km_product_cate1` AS b ON a.cate1 = b.cate1 "
			+ " JOIN `km_product_cate2` AS c ON a.cate1 = c.cate1 AND a.cate2 = c.cate2 "
			+ " WHERE `proNo` =?";
	
	public static final String UPDATE_USER_PASSWORD = "update `km_member` set `pass`=SHA2(?, 256) where `uid`=?";
	
	public static final String Update_Member_Info = "update `km_member` set "
															+ "`name` 	= ?, "
															+ "`gender` = ?, "
															+ "`email` 	= ?, "
															+ "`hp` 	= ?, "
															+ "`zip` 	= ?, "
															+ "`addr1` 	= ?, "
															+ "`addr2` 	= ?"
															+ "where `uid` = ? ";
	
}


