package kosa.subject.store;

public class Product {

	private static int id = 0;

	private int productNo;
	private String name;
	private int price;
	private int stock;

	public Product() {
	}

	public Product(String name, int price, int stock) {
		id++;
		productNo = id;

		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getProductNo() {
		return productNo;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
