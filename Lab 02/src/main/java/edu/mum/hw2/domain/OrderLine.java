package edu.mum.hw2.domain;

import javax.persistence.*;


@Embeddable
public class OrderLine {

	

	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
	
	@Override
	public String toString()
	{
		return "quantity: " + quantity;
	}
}
