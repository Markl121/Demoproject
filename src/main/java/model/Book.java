package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({ @NamedQuery(name = "Book.all", query = "SELECT b FROM Book b"),
		@NamedQuery(name = "Book.byAuthor", query = "SELECT b FROM Book b WHERE :author MEMBER OF b.authors"),
		@NamedQuery(name = "Book.byUser", query = "SELECT b FROM Book b WHERE :users MEMBER OF b.users"),
		@NamedQuery(name = "Book.byIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
		@NamedQuery(name = "Book.byNameLike", query = "SELECT b FROM Book b WHERE b.name LIKE :str")

})
public class Book implements IStorable {

	@Id
	@Column(name = "bookId")
	@SequenceGenerator(name = "seq_bookId", sequenceName = "seq_bookId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_bookId")
	private int id;
	@Column(name = "bookTitle", nullable = false)
	private String name;
	@Column(name = "description")
	private String desc;
	@Column(unique = true, nullable = false)
	private String isbn;
	@Column
	private String imgUrl;

	@Basic
	private LocalDate publishedDate;

	@ManyToMany // (cascade=CascadeType.ALL)
	private Set<Author> authors;

	@ManyToMany // (cascade=CascadeType.ALL)
	private Set<User> users;

	@ElementCollection
	@JoinColumn(name = "bookId")

	public int getId() {
		return id;
	}

	public Book setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Book setName(String name) {
		this.name = name;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public Book setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public String getIsbn() {
		return isbn;
	}

	public Book setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public Book setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public Book setAuthors(Set<Author> authors) {
		this.authors = authors;
		return this;
	}

	public Book addAuthor(Author author) {
		if (this.authors == null)
			this.authors = new HashSet<>();

		this.authors.add(author);

		return this;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Book addUser(User user) {
		if (this.users == null)
			this.users = new HashSet<>();
		
		this.users.add(user);

		return this;
	}

	public Book removeUser(User user) {
		if (this.users != null)
			this.users.remove(user);

		return this;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

//	public Book setPublishedDate(LocalDate publishedDate) {
//		this.publishedDate = publishedDate;
//		return this;
//	}

	public Book setPublishedDate() {
		this.publishedDate = LocalDate.now();
		return this;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", desc=" + desc + ", imgUrl=" + imgUrl + ", authors=" + authors
				+ "]";
	}

}
