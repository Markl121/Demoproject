package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Author implements IStorable {

	@Id
	@Column(name = "authorId")
	@SequenceGenerator(name = "seq_authorId", sequenceName = "seq_authorId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_authorId")
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(name = "description")
	private String desc;

	public Author() {
	}

	public int getId() {
		return id;
	}

	public Author setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Author setName(String name) {
		this.name = name;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public Author setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

}
