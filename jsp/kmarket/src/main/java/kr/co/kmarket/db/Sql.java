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
														+ "`proname` = ?, "
														+ "`descript` = ?, "
														+ "`company` = ?, "
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
		
	
	//insert member
	public static final String Insert_Member =  "INSERT INTO `km_member` SET   "
												+ "`uid` 	= ? , "
												+ "`pass` 	= SHA2(?,256) , "
												+ "`name` 	= ? , "
												+ "`gender` = ? , "
												+ "`email` 	= ? , "
												+ "`hp` 	= ? , "
												+ "`type` 	= 1 , " //type 데이터 확인
												+ "`zip` 	= ? , "
												+ "`addr1` 	= ? ,"
												+ "`addr2` 	= ? , "
												+ "`ip`	= ? , "
												+ "`rdate` 	= NOW()";
}

