package kosa.subject.oop.store;

public class Customer {

	private static int id = 0;

	private int customerNo;
	private String name;
	private int balance;

	public Customer() {
	}

	public Customer(String name, int balance) {
		id++;
		customerNo = id;

		this.name = name;
		this.balance = balance;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
