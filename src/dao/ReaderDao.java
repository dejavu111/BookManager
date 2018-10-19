package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;
import model.Reader;

/*
 * ����Dao��
 */
public class ReaderDao {
	/*
	 * �������
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
	 * ������Ϣ��ѯ
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
	 * ������Ϣɾ��
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
	 * ������Ϣ�޸�
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
	 * ָ������������Ƿ��ж���
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	//���ô洢����existReaderByReaderTypeId
		public boolean existReaderByReaderTypeId(Connection con,String readerTypeId)throws Exception{
			 
			String sql="{call existReaderByReaderTypeId(?)}";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,readerTypeId);
			ResultSet rs=pstmt.executeQuery();
			return rs.next();
			
		}
		
		/**
		 * �ö����Ƿ�����δ��
		 */
		public boolean existBookNotReturn(Connection con,String readerId)throws Exception{
			 
			String sql="select* from t_reader_bookRelation where readerId=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,readerId);
			ResultSet rs=pstmt.executeQuery();
			return rs.next();
			
		}
}
