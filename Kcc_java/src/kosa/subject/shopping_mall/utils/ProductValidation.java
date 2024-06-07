package kosa.subject.shopping_mall.utils;

public class ProductValidation {

	public static boolean isValidName(String name) throws IllegalArgumentException {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 필수 입력 항목입니다.");
		}
		return true;
	}

	public static boolean isValidPrice(int price) throws IllegalArgumentException {
		if (price < 0) {
			throw new IllegalArgumentException("가격은 0 이상의 값이어야 합니다.");
		}
		return true;
	}

}
