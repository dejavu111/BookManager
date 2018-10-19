package model;


/**
 * Õº È µÃÂ
 * @author Dell
 *
 */
public class Book {

	private int id;
	private String bookName;
	private String author;
	private String publisher;
	private String publishtime;
	private Integer bookTypeid;
	private String bookTypeName;
	private String state;
	private String bookDesc;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String bookName, String author, String publisher,
			String publishtime, Integer bookTypeid, String state, String bookDesc) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.publishtime = publishtime;
		this.bookTypeid = bookTypeid;
		this.state = state;
		this.bookDesc = bookDesc;
	}

	 
	public Book(int id, String bookName, String author, String publisher,
			String publishtime, Integer bookTypeid, String state,
			String bookDesc) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.publishtime = publishtime;
		this.bookTypeid = bookTypeid;
		this.state = state;
		this.bookDesc = bookDesc;
	}

	public Book(String bookName, String author, Integer bookTypeid) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeid = bookTypeid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	public Integer getBookTypeid() {
		return bookTypeid;
	}
	public void setBookTypeid(Integer bookTypeid) {
		this.bookTypeid = bookTypeid;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
	
}
