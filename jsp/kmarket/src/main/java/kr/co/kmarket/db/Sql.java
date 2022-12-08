package kr.co.kmarket.db;

public class Sql {
	
	//member 
	public static final String Insert_Member = "INSERT INTO `km_member` SET "
											  + "`uid` = ? , "
											  + "`pass` = SHA2(?,256) , "
											  + "`name` = ? , `gender` = ? , "
											  + "`hp` = ?, `email` = ? ,  `addr1` = ?, `addr2` = ?, "
											  + "`regip` = ?, "
											  + "`rdate` = NOW(),"
											  + "`type` = 1 ";
	
		
}
