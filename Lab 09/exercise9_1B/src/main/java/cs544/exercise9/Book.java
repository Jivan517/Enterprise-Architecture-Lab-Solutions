package cs544.exercise9;



import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Book {
	private int id;
	
	@NotBlank(message = "Title cannot be blank")
	private String title;
	
	@Pattern(regexp = "\\d{3}-\\d{10}", message = "ISBN must contain 3 to 10 digits")
	private String ISBN;
	
	@NotBlank(message = "Author cannot be blank")
	private String author;
	
	@DecimalMin(value  = "0.0001", message = "Price must be greater than 0")
	private double price;

	@Past
	private Date publishedDate;
	
	public Book() {
		super();
	}

	public Book(String title, String iSBN, String author, double price, Date date) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.author = author;
		this.price = price;
		this.publishedDate = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
