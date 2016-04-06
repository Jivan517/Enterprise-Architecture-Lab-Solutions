package cs.mum.edu.hw3.domain.probb;

import javax.persistence.*;

@Entity
public class Book {

	@Id @GeneratedValue
	private int id;
	private String isbn;
	private String title;
	private String author;
	
	@ManyToOne(optional = true)
	@JoinTable(name = "PublisherBook", joinColumns = @JoinColumn(name = "bookId"), 
	inverseJoinColumns = @JoinColumn(name = "publisherId"))
	private Publisher publisher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
}
