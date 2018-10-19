package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;
import model.ReaderType;

/**
 * 读者类别Dao
 * @author Dell
 *
 */
public class ReaderTypeDao {
	
	/**
	 * 读者类别添加
	 */
	public int add(Connection con,ReaderType readertype)throws Exception{
		
		String sql="insert into t_readerType values(?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,readertype.getReaderTypeName());
		pstmt.setInt(2,readertype.getTheLongestBorrowingDays());
		pstmt.setInt(3,readertype.getMaximumBorrowingNumber());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询读者类别
	 */
	public ResultSet list(Connection con,ReaderType readerType)throws Exception{
		
		StringBuffer sb=new StringBuffer("select* from t_readerType");
		if(StringUtil.isNotEmpty(readerType.getReaderTypeName())){
			sb.append(" and readerTypeName like '%"+readerType.getReaderTypeName()+"%'");
		}
		PreparedStatement pstmt= con.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
		
	}
	
	/**
	 * 删除读者类别
	 */
	public int delete(Connection con,String id)throws Exception{
		
		String sql="delete from t_readerType where id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, id);//id为形参
		return pstmt.executeUpdate();
	}

	/**
	 * 修改读者类别
	 */
	public int update(Connection con,ReaderType readerType)throws Exception{
		
		String sql="update t_readerType set readerTypeName=?,theLongestBorrowingDays=?,maximumBorrowingNumber=? where id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, readerType.getReaderTypeName());
		pstmt.setInt(2, readerType.getTheLongestBorrowingDays());
		pstmt.setInt(3, readerType.getMaximumBorrowingNumber());
		pstmt.setInt(4, readerType.getId());
		return pstmt.executeUpdate();
	}
}

