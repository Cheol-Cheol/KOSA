package kosa.subject.oop.video;

public class Runner {

	public static void main(String[] args) {
		Video v1 = new Video("트랜스포머3", "서봉수");
		Video v2 = new Video("쿵푸팬더2", "지성민");

		GeneralMember m1 = new GeneralMember("cheolcheol", "황철원", "인천");
		GeneralMember m2 = new GeneralMember("helloWorld", "유재원", "부천");
		m1.rentVideo(v1);
		m2.rentVideo(v2);

		m1.printInfo();
		m2.printInfo();
	}

}
