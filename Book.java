package main;

public class Book extends Item {
	
	private String author;
	private String description;
	private String category;
	private String releaseDate;
	
	public Book() {}
	
	public Book(String bookId, String bookCode, String title, int unitPrice) {
		super(bookId, bookCode, title, unitPrice);
	}
	
	public Book(String bookId, String bookCode, String title, int unitPrice, String author,
			String description, String category, String releaseDate) {
		super(bookId, bookCode, title, unitPrice);
		this.author = author;
		this.description = description;
		this.category = category;
		this.releaseDate = releaseDate;
	}

	@Override
	public String getBookId() {
		return bookId;
	}

	@Override
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Override
	public String getBookCode() {
		return bookCode;
	}

	@Override
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int getUnitPrice() {
		return unitPrice;
	}

	@Override
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
