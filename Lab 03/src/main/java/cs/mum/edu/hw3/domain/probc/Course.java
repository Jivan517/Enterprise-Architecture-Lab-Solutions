package cs.mum.edu.hw3.domain.probc;

import javax.persistence.*;
import java.util.*;

@Entity
public class Course {
	
	@Id @GeneratedValue
	private int id;
	private String courseNumber;
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")	
	private Set<Student> students = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
}
