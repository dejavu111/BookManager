package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;
import model.Book;

/**
 * 图书DAO类
 * @author Dell
 *
 */
public class BookDao {
	
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		String sql="insert into t_book values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setInt(3, book.getBookTypeid());
		pstmt.setString(4, book.getPublisher());
		pstmt.setString(5, book.getPublishtime());
		pstmt.setString(6, book.getState());
		pstmt.setString(7, book.getBookDesc());
		return pstmt.executeUpdate();
		
	}
	
	/**图书信息查询
	 * 
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_book b,t_booktype bt where b.bookTypeid=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeid()!=null && book.getBookTypeid()!=-1){
			sb.append(" and b.bookTypeid="+"book.getBookTypeid()");
		}
		
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
		
	}
	
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 图书信息修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book)throws Exception{
		String sql="update t_book set bookName=?,author=?,publisher=?,publishtime=?,state=?,bookDesc=?,bookTypeid=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPublisher());
		pstmt.setString(4, book.getPublishtime());
		pstmt.setString(5, book.getState());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getBookTypeid());
		pstmt.setInt(8, book.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 指定图书类别下是否存在图书
	 * @param con
	 * @param bookTypeId
	 * @return
	 */
	
	//运用存储过程existBookByBookTypeId
	public boolean existBookByBookTypeId(Connection con,String bookTypeId)throws Exception{
		 
		String sql="{call existBookByBookTypeId(?)}";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,bookTypeId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
		
	}
	/*public boolean existBookByBookTypeId(Connection con,String bookTypeId)throws Exception{
		 
		String sql="select * from t_book where bookTypeId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,bookTypeId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
		
	}
	*/

}
