package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;
import model.Return;

public class ReturnDao {

	/**
	 * 还书记录添加
	 */
	public int add(Connection con,String readerId,String bookId,java.sql.Date date)throws Exception{
		String sql="insert into t_return values(?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		pstmt.setString(2,bookId);
		pstmt.setDate(3,date);
		return pstmt.executeUpdate();
	}
	public int deleteInR(Connection con,String readerId,String bookId)throws Exception{
		String sql="delete from t_reader_bookRelation where readerId=? and bookId=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		pstmt.setString(2,bookId);
		return pstmt.executeUpdate();
	}
	
	
	/**
	 * 是否存在对应的借阅记录
	 */
	public boolean existInR(Connection con,String readerId,String bookId)throws Exception{
		
		String sql="select* from t_reader_bookRelation where readerId=? and bookId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,readerId);
		pstmt.setString(2, bookId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
		
	}
	
	/**
	 * 结果集
	 */
	public static ResultSet list(Connection con,Return returning)throws Exception {


		StringBuffer sb=new StringBuffer("select* from t_return");
		if(StringUtil.isNotEmpty(returning.getReaderId())&&StringUtil.isEmpty(returning.getBookId()))
		{
			sb.append(" where readerId like '%"+returning.getReaderId()+"%'");
		}
		else if(StringUtil.isNotEmpty(returning.getBookId())&&StringUtil.isEmpty(returning.getReaderId()))
		{
			sb.append(" where bookId like '%"+returning.getBookId()+"%'");
		}
		else if(StringUtil.isNotEmpty(returning.getBookId())&&StringUtil.isNotEmpty(returning.getReaderId()))
		{
			sb.append(" where bookId like '%"+returning.getBookId()+"%'"+" and readerId like '%"+returning.getReaderId()+"%'");
		}
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		
		return pstmt.executeQuery();
		
	}
}
