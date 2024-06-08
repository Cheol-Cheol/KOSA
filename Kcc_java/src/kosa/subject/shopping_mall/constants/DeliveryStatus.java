package kosa.subject.shopping_mall.constants;

public enum DeliveryStatus {

	SHIPPING("배송중"), DELIVERED("배송완료");

	private String status;

	private DeliveryStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
