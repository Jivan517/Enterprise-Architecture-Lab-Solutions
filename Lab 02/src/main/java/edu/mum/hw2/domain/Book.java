package edu.mum.hw2.domain;

import javax.persistence.Entity;

@Entity
public class Book  extends ProductAbstract{

	public String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString(){
		return "Book[Name: " + super.getName() + ", desc: " + super.getDescription() + ", title: " + title +"]";
	}
	
	
}
