package edu.mum.hw2.domain;

import javax.persistence.Entity;

@Entity
public class Cd  extends ProductAbstract{

	public String artist;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
}
