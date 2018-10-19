package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import util.StringUtil;
import model.Borrowing;

public class BorrowingDao {

	/**
	 * 借书记录添加
	 */
	public int add(Connection con,String readerId,String bookId,java.sql.Date date)throws Exception{
		String sql="insert into t_borrowing values(?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		pstmt.setString(2,bookId);
		pstmt.setDate(3,date);
		return pstmt.executeUpdate();
	}
	public int addInR(Connection con,String readerId,String bookId)throws Exception{
		String sql="insert into t_reader_bookRelation values(?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		pstmt.setString(2,bookId);
		return pstmt.executeUpdate();
	}
	/**
	 * 是否存在该读者
	 * @param con
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public boolean existInReader(Connection con,String readerId)throws Exception{
	
		String sql="select* from t_reader where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	
	/**
	 * 是否存在该图书
	 * @param con
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public boolean existInBook(Connection con,String bookId)throws Exception{
		
		String sql="select* from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,bookId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	/*
	 * 读者已借阅数量
	 */
	public int numberOfbook(Connection con,String readerId)throws Exception{
		
		String sql="select count(*) count from t_reader_bookRelation where readerId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		return rs.getInt("count");
	}
	
	/**
	 * 最大借阅本数
	 * @param con
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public int maxBorrowingNumber(Connection con,String readerId)throws Exception{
		
		String sql="select maximumBorrowingNumber from t_reader,t_readerType where t_reader.id=? and readerTypeid=t_readerType.id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		return rs.getInt("maximumBorrowingNumber");
	}
	
	/**
	 * 最长借阅时间
	 * @param con
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public int theLongestBorrowingDays(Connection con,String readerId)throws Exception{
		String sql="select theLongestBorrowingDays from t_reader,t_readerType where t_reader.id=? and readerTypeid=t_readerType.id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		return rs.getInt("theLongestBorrowingDays");
	}
	/**
	 * 最远未还图书日期
	 * @param con
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public Date farthestDay(Connection con,String readerId)throws Exception{
		String sql="select min(borrowingTime) m from t_borrowing,t_reader_bookRelation where t_borrowing.readerId=t_reader_bookRelation.readerId and t_borrowing.bookId=t_reader_bookRelation.bookId";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		return rs.getDate("m");
	}
	/**
	 * 结果集
	 * @param con
	 * @param borrowing
	 * @return
	 * @throws Exception
	 */
	public static ResultSet list(Connection con,Borrowing borrowing)throws Exception {


		StringBuffer sb=new StringBuffer("select* from view_borrowing");
		if(StringUtil.isNotEmpty(borrowing.getIDNumber())&&StringUtil.isNotEmpty(borrowing.getBookId()))
		{
			sb.append(" where IDNumber like '%"+borrowing.getIDNumber()+"%'"+" and bookId like'%"+borrowing.getBookId()+"%'");
		}
		else if(StringUtil.isNotEmpty(borrowing.getIDNumber())&&StringUtil.isEmpty(borrowing.getBookId()))
		{
			sb.append(" where IDNumber like '%"+borrowing.getIDNumber()+"%'");
		}else if(StringUtil.isEmpty(borrowing.getIDNumber())&&StringUtil.isNotEmpty(borrowing.getBookId())){
			sb.append(" where BookId like '%"+borrowing.getBookId()+"%'");
		}
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		
		return pstmt.executeQuery();	
	}

}
