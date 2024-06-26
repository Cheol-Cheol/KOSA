package kosa.oop.course;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;;
	private List<Course> courses;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
		courses = new ArrayList();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printMember() {
		System.out.println("학생이름: " + name);
		for (Course course : courses) {
			System.out.println("수강과목: " + course.getName());
		}
	}

	public void register(Course course) {
		courses.add(course);
		course.addStudent(this);
	}

	public void dropCourse(Course course) {
		if (courses.contains(course)) {
			courses.remove(course);
			course.removeStudent(this);
		}
	}

}
