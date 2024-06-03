package kosa.subject.oop.speak;

public class Work extends Man implements Speakable {

	public Work() {
	}

	public Work(String name) {
		super(name);
	}

	@Override
	public String speak() {
		return getName() + " 열심히 일해야 한다.";
	}

}
