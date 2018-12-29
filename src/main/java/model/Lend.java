package model;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Lend implements IStorable {
	@Id
	@Column(name = "lendUid")
	@SequenceGenerator(name = "seq_lendId", sequenceName = "seq_lendId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq_lendId")
	private int id;

	@ManyToOne
	@JoinColumn(name = "borrowerId", referencedColumnName = "userId")
	private Borrower borrowerId;
	@ManyToOne
	@JoinColumn(name = "materialId", referencedColumnName = "materialId")
	private Material materialId;
	@Basic
	private LocalDate borrowdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Borrower getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(Borrower borrowerId) {
		this.borrowerId = borrowerId;
	}

	public Material getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Material materialId) {
		this.materialId = materialId;
	}

	public LocalDate getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(LocalDate borrowdate) {
		this.borrowdate = borrowdate;
	}

	@Override
	public String toString() {
		return "Lend [id=" + id + ", borrowerId=" + borrowerId + ", materialId=" + materialId + ", borrowdate="
				+ borrowdate + "]";
	}

}
