package main;

public interface BasketInterface {

	void printBookList(Book[] p);
	
	boolean isBookInBasket(String id);
	
	void insertBook(Book p);
	
	void removeBasket(int numId);
	
	void deleteBook();
}
