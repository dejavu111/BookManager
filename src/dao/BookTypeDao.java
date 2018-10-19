package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;
import model.BookType;

/**
 * ͼ�����Dao��
 * @author Dell
 *
 */
public class BookTypeDao {

	/**
	 * ͼ��������
	 */
	
	public int add(Connection con,BookType booktype)throws Exception{
		
		String sql="insert into t_bookType values(?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,booktype.getBookTypeName());
		pstmt.setString(2,booktype.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ��ѯͼ�����
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,BookType bookType)throws Exception{
		
		StringBuffer sb=new StringBuffer("select* from view_bookType");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())){
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt= con.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
		
	}
	
	/**
	 * ɾ��ͼ�����
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		
		String sql="delete from t_bookType where id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, id);//idΪ�β�
		return pstmt.executeUpdate();
	}

	/**
	 * ����ͼ�����
	 */
	public int update(Connection con,BookType bookType)throws Exception{
		
		String sql="update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
}
