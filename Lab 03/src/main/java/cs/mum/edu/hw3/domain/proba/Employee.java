package cs.mum.edu.hw3.domain.proba;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	private String employeeNumber;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentId")
	private Department department;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "officeId")
	private Office office;

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	

	@Override
	public String toString(){
		return "Employee[Id:" + this.employeeNumber + ", name:" + this.name +"]";
	}
}
