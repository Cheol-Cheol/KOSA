package kosa.subject.shopping_mall.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kosa.subject.shopping_mall.constants.DeliveryStatus;

public class Order {

	private static int orderUID = 1;

	private int orderId;
	private DeliveryStatus deliveryStatus;
	private int totalPrice;
	private User fromUser;
	private String createdAt;
	private ExecutorService executorService;

	public Order() {
	}

	public Order(User fromUser) {
		orderId = orderUID++;
		deliveryStatus = DeliveryStatus.SHIPPING;
		createdAt = createDateTimeFormat();
		executorService = Executors.newSingleThreadExecutor();

		this.fromUser = fromUser;
	}

	public void startDelivery() {
		executorService.submit(() -> {
			try {
				Thread.sleep(30000); // 30초
				setDeliveryStatus(DeliveryStatus.DELIVERED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

	public String printOrderInfo() {
		return String.format("[%d]    %-5s          %-5s    	%-5s", orderId, deliveryStatus.getStatus(), fromUser.getName(),
				createdAt);
	}

	private static String createDateTimeFormat() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public int getOrderId() {
		return orderId;
	}

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public User getFromUser() {
		return fromUser;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
