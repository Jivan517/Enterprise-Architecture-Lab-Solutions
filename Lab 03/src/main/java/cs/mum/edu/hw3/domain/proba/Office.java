package cs.mum.edu.hw3.domain.proba;

import java.util.*;
import javax.persistence.*;

@Entity
public class Office {

	@Id
	private String roomNumber;
	private String building;
	
	@OneToMany(mappedBy = "office")
	private List<Employee> employees = new ArrayList<>();

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
