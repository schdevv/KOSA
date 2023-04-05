package assignment.bookstore;

import java.util.HashSet;

public class BookTest {
	
	public static void main(String[] args) {
		Book bookArray[] = new Book[5];
		bookArray[0] = new Book("IT","SQL PLUS", 50000, 0.05);
		bookArray[1] = new Book("IT","Java 2.0", 40000, 0.03);
		bookArray[2] = new Book("IT","JSP Servlet", 60000, 0.06);
		bookArray[3] = new Book("Novel","davincicode", 30000, 0.1);
		bookArray[4] = new Book("Novel","cloven hoof", 50000, 0.15);

		// 객체 정보 출력
		for (Book book: bookArray) {
			System.out.println(book);
		}

		System.out.println();

		// 다른 종류의 category 책이 추가될 경우를 대비해서 다음과 같이 하는게 좋겠죠?
		HashSet<String> set = new HashSet<String>();
		for (Book book: bookArray) {
			set.add(book.getCategory());
		}
		
		for(String category: set) {
			double sumOfBookPrice = 0;
			double sumOfBookPriceDis = 0;
			for(Book book: bookArray) {
				if(book.getCategory().equals(category)) {
					sumOfBookPrice += book.getBookPrice();
					sumOfBookPriceDis += book.getBookPrice() - 
							(book.getBookPrice() * book.getBookDiscountRate());
				}				
			}
			System.out.println(category + " Category의 책 가격 합: " + sumOfBookPrice);
			System.out.println(category + " Category의 할인된 책 가격 합: " + sumOfBookPriceDis);
		}
		
	}

}
