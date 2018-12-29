package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue(value = "Book")
@PrimaryKeyJoinColumn(name = "bookId", referencedColumnName = "materialId")
public class Book extends Material {

	@Column(unique = true, nullable = false)
	private String isbn;
	@ManyToMany // (cascade=CascadeType.ALL)
	private Set<Author> authors;

	public String getIsbn() {
		return isbn;
	}

	public Material setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public Material setAuthors(Set<Author> authors) {
		this.authors = authors;
		return this;
	}

	public Material addAuthor(Author author) {
		if (this.authors == null)
			this.authors = new HashSet<>();

		this.authors.add(author);

		return this;
	}

}
