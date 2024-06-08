package kosa.subject.shopping_mall.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {

	private static int userUID = 1;

	private int userId;
	private String name;
	private String nickname;
	private int age;
	private String addr;
	private String createdAt;
	private List<Product> cart;
	private List<Order> orderList;

	public User() {
	}

	public User(String name, String nickname, int age, String addr) {
		userId = userUID++;
		createdAt = createDateTimeFormat();
		cart = new LinkedList();
		orderList = new ArrayList();

		this.name = name;
		this.nickname = nickname;
		this.age = age;
		this.addr = addr;
	}

	public void addCartItem(Product product) {
		cart.add(product);
	}

	public String printUserInfo() {
		return String.format("[%d]   %s    %-15s %d    %-15s %s", userId, name, nickname, age, addr, createdAt);
	}

	private static String createDateTimeFormat() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public int getAge() {
		return age;
	}

	public String getAddr() {
		return addr;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
