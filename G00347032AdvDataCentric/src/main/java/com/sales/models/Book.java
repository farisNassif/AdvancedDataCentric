package com.sales.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="BOOKS")
public class Book {
	@Id
	@GeneratedValue
	@Column(name="BID", columnDefinition="Tinyint(5)")
	private Long bid;
		
	@Column(name="TITLE", columnDefinition="VARCHAR(45)")
	@NotBlank
	private String title;
		
	@Column(name="AUTHOR", columnDefinition="VARCHAR(30)")
	@NotBlank
	private String author;

	
	@OneToMany(mappedBy="book")
	private List<Loan> loans = new ArrayList<Loan>();


	public Long getBid() {
		return bid;
	}


	public void setBid(Long bid) {
		this.bid = bid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public List<Loan> getLoans() {
		return loans;
	}


	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
}