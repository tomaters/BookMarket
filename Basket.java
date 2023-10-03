package main;

public class Basket implements BasketInterface {

	static final int BOOK_NUMBER = 3;
	public BasketItem[] basketItem = new BasketItem[BOOK_NUMBER];
	public static int basketCount = 0;
	
	public Basket() {}
	
	@Override
	public void printBookList(Book[] booklist) {
		for(int i = 0; i < booklist.length; i++) {
			System.out.printf("%s  |  ", booklist[i].getBookId());
			System.out.printf("%s  |  ", booklist[i].getBookCode());
			System.out.printf("%s  |  ", booklist[i].getTitle());
			System.out.printf("%s  |  ", booklist[i].getUnitPrice());
			System.out.printf("%s  |  ", booklist[i].getAuthor());
			System.out.printf("%s  |  ", booklist[i].getDescription());
			System.out.printf("%s%n", booklist[i].getReleaseDate());
		}
	}

	@Override
	public boolean isBookInBasket(String bookId) {
		boolean flag = false;
		for(int i = 0; i < basketCount; i++) {
			if(bookId == basketItem[i].getBookId()) {
				basketItem[i].setQuantity(basketItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void insertBook(Book book) {
		basketItem[basketCount++] = new BasketItem(book);
	}

	@Override
	public void removeBasket(int numId) {
		BasketItem[] basketItem = new BasketItem[BOOK_NUMBER];
		int num = 0;
		
		for(int i = 0; i < basketCount; i++) {
			if(numId != i) basketItem[num++] = basketItem[i];
		}
		basketCount = num;
	}

	@Override
	public void deleteBook() {
		basketItem = new BasketItem[BOOK_NUMBER];
		basketCount = 0;
	}
 
	public void printBasket() {
		System.out.println("[Displaying items in basket]");
		System.out.println("----------------------------------------------------------");
		System.out.printf("\tBook ID\t\tAmount\t\tTotal%n");
		for(int i = 0; i < basketCount; i++) {
			System.out.printf("\t%s\t\t%s\t\t%s%n", basketItem[i].getBookId(), basketItem[i].getQuantity(),
					basketItem[i].getTotalPrice());
		}
		System.out.println("----------------------------------------------------------");
	}
}
