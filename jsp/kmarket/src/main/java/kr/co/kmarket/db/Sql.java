package kr.co.kmarket.db;

public class Sql {
	
	//select cate1
	public static final String SELECT_CATE1 = " SELECT * FROM `km_product_cate1`"; 
	
	//select cate2
	public static final String SELECT_CATE2 = " SELECT * FROM `km_product_cate2` where `cate1`=? ";
	
	//select terms
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms` ";
	
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
												//타입 not null 이라 임의의 데이터 입력
												+ "`zip` 	= ? , "
												+ "`addr1` 	= ? ,"
												+ "`addr2` 	= ? , "
												+ "`regip` 	= ? , "
												+ "`rdate` 	= NOW()";
	
	public static final String SELECT_COUNT_UID  	= "select count(`uid`) from `km_member` where `uid`=?";
	public static final String SELECT_PRODUCT  		= "SELECT * FROM `km_product`";

	
}


