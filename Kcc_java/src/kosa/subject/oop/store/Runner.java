package kosa.subject.oop.store;

public class Runner {

	public static void main(String[] args) {
		Customer c1 = new Customer("Ȳö��", 20000);
		Cart c1Cart = new Cart(c1);

		Product p1 = new Product("A����", 2000, 10);
		Product p2 = new Product("B����", 4000, 10);
		Product p3 = new Product("C����", 6000, 10);

		c1Cart.addCart(p1);
		c1Cart.addCart(p2);
		c1Cart.addCart(p3);
		
		c1Cart.printCartInfo();
		c1Cart.orderCart();
	}

}
