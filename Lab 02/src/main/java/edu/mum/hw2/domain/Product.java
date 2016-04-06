package edu.mum.hw2.domain;

import javax.persistence.*;
import java.util.*;


@Entity
public class Product {

	
	@Id @GeneratedValue
	private int id;
	private String name;
	private String description;
	
	@ElementCollection
	//@JoinTable(name = "OrderLine", joinColumns = @JoinColumn(name = "ProductId"))
	private List<OrderLine> orderLines = new ArrayList<>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}
