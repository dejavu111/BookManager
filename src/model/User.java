package model;
/**
 * 用户实体
 * @author Dell
 *
 */
public class User {
	
	private int id;
	private String username;
	private String password;
	private String usertype;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String username,String password) {
		super();
		this.username = username;
		this.password = password;
	}

	

	public User(String username) {
		super();
		this.username = username;
		this.usertype = "普通用户";
	}


	public User(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	
	
}
