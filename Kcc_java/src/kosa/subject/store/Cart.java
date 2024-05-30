package kosa.subject.store;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private Customer customer;
	private List<Product> products;

	public Cart() {
	}

	public Cart(Customer customer) {
		this.customer = customer;
		this.products = new ArrayList<>();
	}

	// ��ٱ��� �߰�
	public void addCart(Product product) {
		products.add(product);
	}

	// ��ٱ��� ����
	public void removeCart(Product product) {
		products.remove(product);
	}

	// �ֹ��ϱ�
	public void orderCart() {
		// �� �ݾ�
		int totalPrice = 0;
		for (Product product : products) {
			totalPrice += product.getPrice();
		}

		int balance = customer.getBalance();
		if (totalPrice > balance) {
			System.out.println("�ݾ��� �����մϴ�. �ֹ��� ����մϴ�.");
			return;
		} else {
			// �ܾ� ����
			customer.setBalance(balance - totalPrice);
			// ��� ����
			for (Product product : products) {
				product.setStock(product.getStock() - 1);
			}

			products.clear(); // ��ٱ��� ����
			System.out.println("������ �Ϸ�Ǿ����ϴ�. ���� �ݾ�: " + totalPrice + "��" + " | ���� �ݾ�: " + customer.getBalance() + "��");
		}

	}

	// ��ٱ��� ���� ���
	public void printCartInfo() {
		System.out.println(customer.getName() + "���� ��ٱ���");
		System.out.println("======================");

		int totalPrice = 0;
		for (Product product : products) {
			System.out.println("��ǰ��: " + product.getName());
			System.out.println("����: " + product.getPrice());
			totalPrice += product.getPrice();
			System.out.println("======================");
		}
		System.out.println("�� �ݾ�: " + totalPrice);
	}

}
