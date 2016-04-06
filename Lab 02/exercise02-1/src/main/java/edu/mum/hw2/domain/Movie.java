package edu.mum.hw2.domain;
import java.util.*;

import javax.persistence.*;

@Entity
public class Movie {
	
	@Id @GeneratedValue
	private int id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	@Lob
	private byte[] cover;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<Category> categories = new HashSet<>();
	
	
	@ElementCollection
	@OrderColumn(name = "Position")
	@CollectionTable(
	        name="Comment",
	        joinColumns=@JoinColumn(name="Movie_Id")
	  )
	@Column(name = "comment")
	private List<String> comments = new ArrayList<>();
	
	@ElementCollection
	//@CollectionTable(name = "Actor", joinColumns = @JoinColumn(name = "Movie_Id"))
	private List<Actor> actors = new ArrayList<>();

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

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	@Override 
	public String toString(){
		return "Movie: " + this.name + " with actors: " + actors.toString();
	}
	
}
