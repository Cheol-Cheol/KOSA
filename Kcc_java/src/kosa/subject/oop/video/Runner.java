package kosa.subject.oop.video;

public class Runner {

	public static void main(String[] args) {
		Video v1 = new Video("범죄도시3", "황철원");
		Video v2 = new Video("쿵푸팬더2", "유재원");

//		SpecialMember m1 = new SpecialMember("cheolcheol", "철원", "인천");
//		GeneralMember m2 = new GeneralMember("helloWorld", "재원", "부천");
//
//		m1.rentVideo(v1); // 단골
//		m2.rentVideo(v2);
//
//		m1.printInfo(); // 단골
//		m2.printInfo();

		SpecialMember m1 = new SpecialMember("cheolcheol", "철원", "인천");
		GeneralMember m2 = new GeneralMember("helloWorld", "재원", "부천");

		GeneralMember arr[] = new GeneralMember[] { m1, m2 };

		m1.rentVideo(v1);
		m2.rentVideo(v2);

		for (GeneralMember member : arr) {
			if (member instanceof SpecialMember) {
				((SpecialMember) member).specialPrint();
			}
		}
	}

}
