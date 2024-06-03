package kosa.oop3;

public class Person {
	
	private String name;
	private Role role;

	public Person() {
	}

	public Person(String name, Role role) {
		this.name = name;
		this.role = role;
	}

	public void doit() {
		role.doing();
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
