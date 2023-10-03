package main;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class WelcomeBookMarket {
	static final int BOOK_NUMBER = 3;
	static final int BOOK_PROPERTIES = 8;

	static Basket basket = new Basket();
	static User user;
	
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String userName = null, userPhone = null;
		int numberSelection = 0;
		boolean close = false; 
		Book[] bookInfoList = new Book[BOOK_NUMBER];
		
		System.out.println("[Book Market] Please input customer information");
		System.out.println("Enter name:");
		userName = scan.nextLine();
		System.out.println("Enter phone number:");
		userPhone = scan.nextLine();
		
		user = new User(userName, userPhone);
		
		while (!close) {
			menuIntroduction();
			
			try {
				System.out.println("Select an option from the menu: ");
					numberSelection = scan.nextInt();
				
				if(numberSelection < 1 || numberSelection > 9) {
					System.out.println("Please enter a number between 1 and 9");
					continue;
				}
				System.out.printf("You selected [%d]%n", numberSelection);
				scan.nextLine(); // clear buffer
				
				switch(numberSelection) {
					case 1: 
						customerInfo(userName, userPhone);
						break;
					case 2: 
						displayBasket();
						break;
					case 3: 
						emptyBasket();
						break;
					case 4: 
						addItem(bookInfoList);
						break;
					case 5: 
						decreaseItemCount();
						break;
					case 6: 
						removeItem();
						break;
					case 7: 
						displayReceipt();
						break;
					case 8:
						System.out.println("[Closing program]");
						close = true;
						break;
					case 9:
						menuAdminLogin();
				}
			} catch(BasketException e) {
				System.out.println(e.getMessage());
				close = true;
			} catch(Exception e) {
				System.out.println("Error: program closing");
				close = true;
			}
		}
	}

	private static void menuIntroduction() {
		System.out.println("**********************************************************");
		System.out.println("\t\t Welcome to Book Market");
		System.out.println("**********************************************************");
		
		System.out.println("1. Check customer information \t6. Remove item from basket");
		System.out.println("2. Check basket list \t\t7. Display receipt");
		System.out.println("3. Empty basket \t\t8. Close program");
		System.out.println("4. Add item to basket \t\t9. Admin login");
		System.out.println("5. Decrease item count ");		
		System.out.println("**********************************************************");
	}

	private static void customerInfo(String name, String phone) {
		System.out.println("[Displaying customer information]");
		System.out.printf("Name: %s%nPhone number: %s%n", user.getName(), user.getPhone());
		
	}
	
	private static void displayBasket() {
		System.out.println("[Displaying basket list]");
		if(Basket.basketCount >= 0) basket.printBasket();
	}
	
	private static void emptyBasket() throws BasketException {
		System.out.println("[Empty basket]");
		if(basket.basketCount == 0) {
			throw new BasketException ("The basket is empty");
		} else {
			System.out.println("Would you like to empty all the items in the basket? Y | N");
			String input = scan.nextLine();
			
			if(input.toUpperCase().equals("Y")) {
				System.out.println("The basket has been emptied");
				basket.deleteBook();
			}
		}
	}
	
	private static void addItem(Book[] book) {
		System.out.println("[Add item to basket]");
		bookList(book); // call method containing list of books
		
		basket.printBookList(book);
		boolean close = false;
		
		while(!close) {
			System.out.println("Enter book number that you would like to add:");
			String input = scan.nextLine();
			
			boolean flag = false;
			int numId = -1; // index number
			
			for(int i = 0; i < BOOK_NUMBER; i++) {
				if(input.equals(book[i].getBookId())) {
					numId = i;
					flag = true;
					break;
				}
			}
			
			if(flag) {
				System.out.println("Would you like to add this item to your basket? Y | N");
				input = scan.nextLine();
				
				if(input.toUpperCase().equals("Y")) {
					System.out.printf("'%s' has been added to your basket%n", book[numId].getBookId());
					if(!isBookInBasket(book[numId].getBookId())) {
						basket.insertBook(book[numId]);
					}
				}
				close = true;
				} else System.out.println("Please try again");
			}
		}

	public static void displayReceipt() throws BasketException {
		if(basket.basketCount == 0) {
			throw new BasketException ("The basket is empty");
		} else {
			System.out.println("Is the delivery recipient the same as the customer? Y | N");
			String input = scan.nextLine();
			
			if(input.toUpperCase().equals("Y")) {
				System.out.println("Please enter the delivery address");
				String address = scan.nextLine();
				printBill(user.getName(), String.valueOf(user.getPhone()), address);
			} else {
				System.out.println("Please enter the name of the delivery recipient");
				String name = scan.nextLine();
				System.out.println("Please enter the phone number of the delivery recipient");
				String phone = scan.nextLine();				
				System.out.println("Please enter the delivery address");
				String address = scan.nextLine();
				printBill(user.getName(), String.valueOf(user.getPhone()), address);
			}
		}
	}
	
	private static void printBill(String name, String phone, String address) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		System.out.println();
		System.out.println("--------------Delivery recipient information--------------");
		System.out.printf("Name: %s\t\tPhone number:%s%n", name, phone);
		System.out.printf("Address: %s\t\tDelivery date:%s%n", address, strDate);
		// display items in basket
		basket.printBasket(); 
		// calculate total price of basket
		int sum = 0;
		for(int i = 0; i < basket.basketCount; i++) {
			sum += basket.basketItem[i].getTotalPrice();
		}
		System.out.printf("\tTotal order price: $%s%n", sum);
		System.out.println("----------------------------------------------------------");
	}

	private static void bookList(Book[] book) {
		book[0] = new Book("book1", "bookcode1", "booktitle1", 10);
		book[0].setAuthor("author1");
		book[0].setDescription("description1");
		book[0].setCategory("category1");
		book[0].setReleaseDate("releasedate1");

		book[1] = new Book("book2", "bookcode2", "booktitle2", 20);
		book[1].setAuthor("author2");
		book[1].setDescription("description2");
		book[1].setCategory("category2");
		book[1].setReleaseDate("releasedate2");
		
		book[2] = new Book("book3", "bookcode3", "booktitle3", 30);
		book[2].setAuthor("author3");
		book[2].setDescription("description3");
		book[2].setCategory("category3");
		book[2].setReleaseDate("releasedate3");
	}

	private static void decreaseItemCount() {
		System.out.println("[Decrease item count]");
		// TODO Auto-generated method stub	
	}
	
	private static void removeItem() throws BasketException {
		System.out.println("[Remove item from basket]");
		if(basket.basketCount == 0) {
			throw new BasketException ("The basket is empty");
		} else {
			displayBasket();
			boolean close = false;
			while(!close) {
				System.out.println("Enter ID of book you would like to remove");
				String input = scan.nextLine();
				boolean flag = false;
				int numId = -1;
				
				for(int i = 0; i < basket.basketCount; i++) {
					if(input.equals(basket.basketItem[i].getBookId())) {
						numId = i;
						flag = true;
						break;
					}
				}
				if(flag) {
					System.out.println("Would you like to remove this item from your basket? Y | N");
					input = scan.nextLine();
					if(input.toUpperCase().equals("Y")) {
						System.out.printf("%s has been removed from your basket%n", basket.basketItem[numId].getBookId());
						basket.removeBasket(numId);
					}
					close = true;
				} else System.out.println("Please try again");
			}
		}
	}
	
	private static boolean isBookInBasket(String bookId) {
		return basket.isBookInBasket(bookId);
	}
	
	private static void menuAdminLogin() {
		System.out.println("[Enter admin information]");
		System.out.println("ID: ");
		String adminID = scan.nextLine();
		System.out.println("Password: ");
		String adminPW = scan.nextLine();
		
		Admin admin = new Admin(user.getName(),user.getPhone());
		if(adminID.equals(admin.getId()) && adminPW.equals(admin.getPassword())){
			System.out.printf("Name: %s, Phone number: %s%n", admin.getName(), admin.getPhone());
			System.out.printf("ID: %s, PW: %s%n", admin.getId(), admin.getPassword());
		} else System.out.println("The information you entered is incorrect");
	}
}
