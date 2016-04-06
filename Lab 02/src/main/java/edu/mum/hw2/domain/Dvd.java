package edu.mum.hw2.domain;

import javax.persistence.Entity;

@Entity
public class Dvd extends ProductAbstract {

	public String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
