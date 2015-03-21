package cz.csob.hackathon.devnull.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_tbl"/* , uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) } */)
public class TestTable implements Serializable {

	private static final long serialVersionUID = 8224916651865239245L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email", unique = true, nullable = false, length = 200)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "TestTable [id=" + id + ", email=" + email + "]";
	}

}
