package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;
import model.Reader;

/*
 * 读者Dao类
 */
public class ReaderDao {
	/*
	 * 读者添加
	 */
	public int add(Connection con,Reader reader)throws Exception{
		String sql="insert into t_reader values(?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, reader.getIDNumber());
		pstmt.setString(2, reader.getName());
		pstmt.setInt(3, reader.getReaderTypeid());
		pstmt.setString(4,reader.getTel());
		return pstmt.executeUpdate();
		
	}
	
	/*
	 * 读者信息查询
	 */
	public ResultSet list(Connection con,Reader reader)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_reader r,t_readertype rt where r.readerTypeid=rt.id");
		if(StringUtil.isNotEmpty(reader.getName())){
			sb.append(" and r.name like '%"+reader.getName()+"%'");
		}
		if(StringUtil.isNotEmpty(reader.getIDNumber())){
			sb.append(" and r.IDNumber like '%"+reader.getIDNumber()+"%'");
		}
		if(reader.getReaderTypeid() != null && reader.getReaderTypeid()!=-1){
			sb.append(" and r.readerTypeid="+"reader.getReaderTypeid()");
		}
		
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
		
	}
	
	/**
	 * 读者信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_reader where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 读者信息修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Reader reader)throws Exception{
		String sql="update t_reader set name=?,IDNumber=?,readerTypeid=?,tel=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, reader.getName());
		pstmt.setString(2, reader.getIDNumber());
		pstmt.setInt(3, reader.getReaderTypeid());
		pstmt.setString(4,reader.getTel());
		pstmt.setInt(5, reader.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 指定读者类别下是否有读者
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	//运用存储过程existReaderByReaderTypeId
		public boolean existReaderByReaderTypeId(Connection con,String readerTypeId)throws Exception{
			 
			String sql="{call existReaderByReaderTypeId(?)}";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,readerTypeId);
			ResultSet rs=pstmt.executeQuery();
			return rs.next();
			
		}
		
		/**
		 * 该读者是否有书未还
		 */
		public boolean existBookNotReturn(Connection con,String readerId)throws Exception{
			 
			String sql="select* from t_reader_bookRelation where readerId=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,readerId);
			ResultSet rs=pstmt.executeQuery();
			return rs.next();
			
		}
}
