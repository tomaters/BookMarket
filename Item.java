package main;

public abstract class Item {

	String bookId;
	String bookCode;
	String title;
	int unitPrice;
	
	public Item() {}
	
	public Item(String bookId, String bookCode, String title, int unitPrice) {
		this.bookId = bookId;
		this.bookCode = bookCode;
		this.title = title;
		this.unitPrice = unitPrice;
	}

	public abstract String getBookId();

	public abstract void setBookId(String bookId);

	public abstract String getBookCode();

	public abstract void setBookCode(String bookCode);

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract int getUnitPrice();
	
	public abstract void setUnitPrice(int unitPrice);	
	
}
