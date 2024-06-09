
package kosa.subject.shopping_mall.constants;

public enum Category {

	TOP("상의"), BOTTOM("하의"), OUTER("아우터"), ACCESSORY("악세사리"), SHOES("신발");

	private String value;

	private Category(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
