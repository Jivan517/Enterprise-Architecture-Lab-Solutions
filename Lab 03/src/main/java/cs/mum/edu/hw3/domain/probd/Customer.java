package cs.mum.edu.hw3.domain.probd;

import javax.persistence.*;
import java.util.*;

@Entity
public class Customer {

	@Id @GeneratedValue
	private int id;
	private String name;
	
	@OneToMany
	@JoinColumn(name = "customerId") //not reservationId
	private List<Reservation> reservations = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	@Override
	public String toString(){
		return "Customer[name:" + name + "]";
	}
	
}
