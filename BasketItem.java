package main;

public class BasketItem {

	private Book itemBook;
	private String bookId;
	private int quantity;
	private int totalPrice;
	
	public BasketItem() {}

	public BasketItem(Book itemBook) {
		this.itemBook = itemBook;
		this.bookId = itemBook.getBookId();
		this.quantity = 1;
		updateTotalPrice();
	}
	
	public void updateTotalPrice() {
		totalPrice = this.itemBook.getUnitPrice() * this.quantity; 
	}

	public Book getItemBook() {
		return itemBook;
	}

	public void setItemBook(Book itemBook) {
		this.itemBook = itemBook;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

}
