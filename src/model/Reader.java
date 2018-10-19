package model;

/*
 * ∂¡’ﬂ µÃÂ
 */
public class Reader {
	
	private int id;
	private String IDNumber;
	private String name;
	private Integer readerTypeid;
	private String tel;
	private String readerTypeName;
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Reader(String iDNumber, String name, Integer readerTypeid, String tel) {
		super();
		IDNumber = iDNumber;
		this.name = name;
		this.readerTypeid = readerTypeid;
		this.tel = tel;
	}


	public Reader(int id,String IDNumber, String name, Integer readerTypeid, String tel) {
		super();
		this.id=id;
		this.IDNumber = IDNumber;
		this.name = name;
		this.readerTypeid = readerTypeid;
		this.tel = tel;
	}

	

	public Reader(String name, String iDNumber,  Integer readerTypeid) {
		super();
		IDNumber = iDNumber;
		this.name = name;
		this.readerTypeid = readerTypeid;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getReaderTypeid() {
		return readerTypeid;
	}
	public void setReaderTypeid(Integer readerTypeid) {
		this.readerTypeid = readerTypeid;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getReaderTypeName() {
		return readerTypeName;
	}


	public void setReaderTypeName(String readerTypeName) {
		this.readerTypeName = readerTypeName;
	}
	
	
	
}
