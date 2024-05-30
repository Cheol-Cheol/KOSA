package kosa.oop.book;

public class BookMain {

	public static void main(String[] args) {
		int total = 0;

		Book[] books = { new Book("JAVA", 30000), new Book("JSP", 20000), new Book("ORACLE", 15000) };

		for (Book book : books) {
			book.discount();
			book.printBook();
			total += book.dc_price;
		}

		System.out.println("ÃÑ±Ý¾×: " + total);
	}

}
