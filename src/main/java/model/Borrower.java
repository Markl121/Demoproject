package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Reader")
// @PrimaryKeyJoinColumn(name = "readerId", referencedColumnName = "userId")
@NamedQueries({ 
    @NamedQuery(name = "Borrower.byUsername", query = "select r from Borrower r where r.username = :uname"),
    @NamedQuery(name = "Borrower.login", query = "select r from Borrower r where r.username = :uname and r.password = :pw") })

public class Borrower extends User {

	private static final long serialVersionUID = -4588616494784459089L;

	@OneToMany(mappedBy = "borrowerId")
	private Set<Lend> books;

	@OneToMany(mappedBy = "owner")
	private Set<Shelf> shelves;

	public Set<Lend> getBooks() {
		return books;
	}

	public Borrower setBooks(Set<Lend> books) {
		this.books = books;
		return this;
	}

	public Borrower addBook(Lend book) {
		if (this.books == null)
			this.books = new HashSet<>();

		this.books.add(book);

		return this;
	}

	public Set<Shelf> getShelfs() {
		return shelves;
	}

	public Borrower setShelfs(Set<Shelf> shelves) {
		this.shelves = shelves;
		return this;
	}

	public Borrower addShelf(Shelf shelf) {
		if (this.shelves == null)
			this.shelves = new HashSet<>();

		this.shelves.add(shelf);

		shelf.setOwner(this);

		return this;
	}

}
