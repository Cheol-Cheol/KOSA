package kosa.subject.shopping_mall.utils;

public class UserValidation {

	public static boolean isValidName(String name) throws IllegalArgumentException {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("[서비스 알림] 이름은 필수 입력 항목입니다.");
		}
		return true;
	}

	public static boolean isValidNickname(String nickname) throws IllegalArgumentException {
		if (nickname == null || nickname.trim().isEmpty()) {
			throw new IllegalArgumentException("[서비스 알림] 닉네임은 필수 입력 항목입니다.\n");
		}
		return true;
	}

	public static boolean isValidAge(int age) throws IllegalArgumentException {
		if (age < 0) {
			throw new IllegalArgumentException("[서비스 알림] 나이는 0 이상의 값이어야 합니다.\n");
		}
		return true;
	}

	public static boolean isValidAddr(String addr) throws IllegalArgumentException {
		if (addr == null || addr.trim().isEmpty()) {
			throw new IllegalArgumentException("[서비스 알림] 주소는 필수 입력 항목입니다.\n");
		}
		return true;
	}

}
