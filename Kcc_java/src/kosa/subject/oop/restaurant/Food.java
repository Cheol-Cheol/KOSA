package kosa.subject.oop.restaurant;

public class Food {

	private String foodName;
	private int price;

	public Food() {
	}

	public Food(final String foodName, final int price) {
		this.foodName = foodName;
		this.price = price;
	}

	public String getFoodName() {
		return foodName;
	}

	public int getPrice() {
		return price;
	}

	public void setFoodName(final String foodName) {
		this.foodName = foodName;
	}

	public void setPrice(final int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("[음식명: %s | 가격: %d원]", foodName, price);
	}

}
