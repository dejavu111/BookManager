package model;
/**
 * 读者类别实体
 * @author Dell
 *
 */
public class ReaderType {
	
	private int id;
	private String readerTypeName;
	private int theLongestBorrowingDays;
	private int maximumBorrowingNumber;
	
	public ReaderType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ReaderType(String readerTypeName, int theLongestBorrowingDays,
			int maximumBorrowingNumber) {
		super();
		this.readerTypeName = readerTypeName;
		this.theLongestBorrowingDays = theLongestBorrowingDays;
		this.maximumBorrowingNumber = maximumBorrowingNumber;
	}


	public ReaderType(int id, String readerTypeName,
			int theLongestBorrowingDays, int maximumBorrowingNumber) {
		super();
		this.id = id;
		this.readerTypeName = readerTypeName;
		this.theLongestBorrowingDays = theLongestBorrowingDays;
		this.maximumBorrowingNumber = maximumBorrowingNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReaderTypeName() {
		return readerTypeName;
	}

	public void setReaderTypeName(String readerTypeName) {
		this.readerTypeName = readerTypeName;
	}

	public int getTheLongestBorrowingDays() {
		return theLongestBorrowingDays;
	}

	public void setTheLongestBorrowingDays(int theLongestBorrowingDays) {
		this.theLongestBorrowingDays = theLongestBorrowingDays;
	}

	public int getMaximumBorrowingNumber() {
		return maximumBorrowingNumber;
	}

	public void setMaximumBorrowingNumber(int maximumBorrowingNumber) {
		this.maximumBorrowingNumber = maximumBorrowingNumber;
	}


	@Override
	public String toString() {
		return readerTypeName;
	}
	
	
	
}
