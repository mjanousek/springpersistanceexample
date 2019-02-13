package cz.janousek.web;

import javax.persistence.*;

@Entity
public class SpecialSet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JoinColumn
	@ManyToOne
	private Book book;
	@Column
	private int price;

	public SpecialSet() {
	}

	public SpecialSet(Book book, int price) {
		this.book = book;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
