package model;

import java.sql.Date;

public class Borrowing {

	private String readerId;
	private String bookId;
	private String IDNumber;
	private String readerName;
	private Date date;
	public Borrowing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
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
	
	public Borrowing(String iDNumber) {
		super();
		IDNumber = iDNumber;
	}

	public Borrowing(String readerId, String bookId, String iDNumber,
			String readerName, Date date) {
		super();
		this.readerId = readerId;
		this.bookId = bookId;
		IDNumber = iDNumber;
		this.readerName = readerName;
		this.date = date;
	}

	public Borrowing(String readerId, String bookId, Date date) {
		super();
		this.readerId = readerId;
		this.bookId = bookId;
		this.date = date;
	}
	public Borrowing(String IDNumber, String bookId) {
		super();
		this.IDNumber = IDNumber;
		this.bookId = bookId;
	}
	
	
	
}
