package model;

import java.sql.Date;

public class Return {

	private String readerId;
	private String bookId;
	private Date date;
	public Return() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Return(String readerId, String bookId, Date date) {
		super();
		this.readerId = readerId;
		this.bookId = bookId;
		this.date = date;
	}

	
	public Return(String readerId, String bookId) {
		super();
		this.readerId = readerId;
		this.bookId = bookId;
	}

	public String getReaderId() {
		return readerId;
	}
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
