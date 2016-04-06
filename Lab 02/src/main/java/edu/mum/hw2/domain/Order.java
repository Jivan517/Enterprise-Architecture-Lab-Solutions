package edu.mum.hw2.domain;

import java.util.*;
import java.time.*;
import javax.persistence.*;

@Entity(name = "CustomerOrder")
public class Order {

	@Id
	private int orderId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private  Date date;
	
	@ElementCollection
	//We have to use @OneToMany association mapping
	//@JoinTable(name = "OrderLine", joinColumns = @JoinColumn(name = "OrderId"))
	private List<OrderLine> orderLines = new ArrayList<>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date localDate) {
		this.date = localDate;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	@Override
	public String toString(){
		return "OrderID: " + orderId + ", Date: " + date + ", lines: " + orderLines.toString();
	}
}
