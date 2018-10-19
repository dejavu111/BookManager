package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;
import model.Book;
import model.User;

/**
 * 用户Dao类
 * @author Dell
 *
 */
public class UserDao {
	
	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select* from t_user where username=? and password=? and usertype=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUsername());
		pstmt.setString(2,user.getPassword());
		pstmt.setString(3, user.getUsertype());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			resultUser=new User();
			resultUser.setId(Integer.parseInt(rs.getString("id")));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setUsertype(rs.getString("usertype"));
		}
		
		return resultUser;
	}
	
	/**
	 * 添加普通用户
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,User user)throws Exception{
		
		String sql="insert into t_user values(?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getUsertype());
		
		return pstmt.executeUpdate();
		
	}
	
	/*
	 * 普通用户查询
	 */
	public ResultSet list(Connection con,User user)throws Exception{
		StringBuffer sb=new StringBuffer("select * from view_userlist");
		if(StringUtil.isNotEmpty(user.getUsername())){
			sb.append(" and username like '%"+user.getUsername()+"%'");
		}
		
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
		
	}
	
	/**
	 * 用户密码修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,User user)throws Exception{
		String sql="update t_user set password=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setInt(2, user.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 用户信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_user where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
	}
}
