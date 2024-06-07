package kosa.subject.shopping_mall.domain;

import kosa.subject.shopping_mall.constants.Category;

public class Product {

	private static int productUID = 1;

	private int productId;
	private String name;
	private int price;
	private int stock;
	private Category category;

	public Product() {
	}

	public Product(String name, int price, Category category) {
		productId = productUID++;
		stock = 10;

		this.name = name;
		this.price = price;
		this.category = category;
	}

	public int getProductId() {
		return productId;
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

	public Category getCategory() {
		return category;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public void setCategory(Category category) {
		this.category = category;
	}

	public String printProductInfo() {
		return String.format("[%d]\t%s\t\t%d원\t%d개\t\t%s\t", productId, name, price, stock, category.getValue());
	}

	public String printProductFromCart() {
		return String.format("[%d]\t%s\t\t%d원", productId, name, price);
	}
	
}
