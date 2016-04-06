package cs.mum.edu.hw3.domain.probc;

import javax.persistence.*;
import java.util.*;

@Entity
public class Student {

	
	@Id
	private String studentId;
	private String firstname;
	private String lastName;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "StudentCourse", joinColumns = {@JoinColumn(name = "studentId")}, 
	inverseJoinColumns = {@JoinColumn(name = "courseId")})
	private Set<Course> courses = new HashSet<>();

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
