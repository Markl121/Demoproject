package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Shelf implements IStorable{

	@Id
	@Column(name = "shelfId")
	@SequenceGenerator(name = "seq_shelfId", sequenceName = "seq_shelfId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_shelfId")
	private int id;
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "readerId", referencedColumnName = "userId")
	private Borrower owner;


	@ManyToMany
	private Set<Material> books;

	public int getId() {
		return id;
	}

	public Shelf setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Shelf setName(String name) {
		this.name = name;
		return this;
	}

	public Set<Material> getBooks() {
		return books;
	}

	public Shelf setBooks(Set<Material> books) {
		this.books = books;
		return this;
	}

	public Shelf addBook(Material book) {
		if (this.books == null)
			this.books = new HashSet<>();
		this.books.add(book);

		return this;
	}
	public Borrower getOwner() {
		return owner;
	}

	public Shelf setOwner(Borrower owner) {
		if (this.getOwner() != null)
			throw new IllegalStateException("Shelf cannot be assigned a new owner");

		this.owner = owner;
		return this;
	}

	@Override
	public String toString() {
		return "Shelf [id=" + id + ", name=" + name + "]";
	}

}
