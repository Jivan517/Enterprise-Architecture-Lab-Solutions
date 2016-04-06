package cs.mum.edu.hw3.domain.probd;

import javax.persistence.*;

import cs.mum.edu.hw3.domain.probb.Book;

import java.util.*;

@Entity
public class Reservation {
	
	@Id @GeneratedValue
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
