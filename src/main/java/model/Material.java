package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
//@NamedQueries({ @NamedQuery(name = "Material.all", query = "SELECT m FROM Material m"),
//	@NamedQuery(name = "Material.byAuthor", query = "SELECT m FROM Material m WHERE :author MEMBER OF m.authors"),
//	@NamedQuery(name = "Material.byIsbn", query = "SELECT m FROM Material m WHERE m.isbn = :isbn"),
//	@NamedQuery(name = "Material.byNameLike", query = "SELECT m FROM Material m WHERE m.name LIKE :str")
//
//})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, length = 10)
public class Material implements IStorable {

	@Id
	@Column(name = "materialId")
	@SequenceGenerator(name = "seq_materialId", sequenceName = "seq_materialId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_materialId")
	private int id;
	@Column(name = "title", nullable = false)
	private String name;
	@Column(name = "description")
	private String description;
	@Column
	private String imgUrl;

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

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public Material setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
