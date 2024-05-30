package kosa.bank;

public class MyBank {

	private Customer[] customers;
	private int customersNum; // 고객 수

	public MyBank() {
		this.customers = new Customer[10];
		this.customersNum = 0;
	}

	// o
	public void addCustomer(String id, String name, long balance) {
		customers[customersNum++] = new Customer(id, name, balance);
	}

	// o
	public int getCutomersNum() {
		return customersNum;
	}

	// o
	public Customer getCustomer(String id) {
		for (int i = 0; customers[i] != null; i++) {
			if (customers[i].getId().equals(id)) {
				return customers[i];
			}
		}
		return null;
	}

	// o
	public Customer[] getAllCustomers() {
		Customer[] copy = new Customer[customersNum];
		for (int i = 0; i < customersNum; i++) {
			copy[i] = customers[i];
		}
		return copy;
	}
}
