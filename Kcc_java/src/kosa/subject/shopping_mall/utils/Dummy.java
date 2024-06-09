package kosa.subject.shopping_mall.utils;

import java.util.Arrays;
import java.util.List;

import kosa.subject.shopping_mall.constants.Category;
import kosa.subject.shopping_mall.domain.Product;
import kosa.subject.shopping_mall.domain.User;

public class Dummy {

	public static List<User> setUserData() {
		return Arrays.asList(new User("황철원", "cheol12", 28, "인천 계양구"), new User("유재원", "helloooo", 28, "부천 원미구"),
				new User("관리자", "admin", 99, "서울 종로구"));
	}

	public static List<Product> setProductData() {
		return Arrays.asList(new Product("흰색반팔", 12000, Category.TOP), new Product("검정바지", 32000, Category.BOTTOM),
				new Product("갈색점퍼", 25000, Category.OUTER), new Product("갈색신발", 14000, Category.SHOES),
				new Product("노랑신발", 12000, Category.SHOES), new Product("회색반팔", 40000, Category.TOP));
	}

}
