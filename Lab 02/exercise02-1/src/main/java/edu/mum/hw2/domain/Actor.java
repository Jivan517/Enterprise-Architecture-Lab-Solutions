package edu.mum.hw2.domain;

import javax.persistence.*;

@Entity
public class Actor {

	@Id @GeneratedValue
	private int id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Rating rating;
	private String actorCharacter;
	
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
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public String getActorCharacter() {
		return actorCharacter;
	}
	public void setActorCharacter(String character) {
		this.actorCharacter = character;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
