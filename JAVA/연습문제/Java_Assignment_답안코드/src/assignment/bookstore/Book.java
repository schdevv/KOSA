package assignment.bookstore;

public class Book {
	
	public Book() {

	}
	
	private String category;
	private String bookName;
	private double bookPrice;
	private double bookDiscountRate;
	

	public Book(String category, String bookName, double bookPrice, double bookDiscountRate) {
		this.category = category;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}

	public double getkDiscountBookRate() {
		return (bookPrice - (double) bookPrice * bookDiscountRate);
	}

	@Override
	public String toString() {
		return category + " "
				+ bookName + " " 
				+ bookPrice + " "
				+ bookDiscountRate*100 + "%";
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookDiscountRate() {
		return bookDiscountRate;
	}

	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}

	

}
