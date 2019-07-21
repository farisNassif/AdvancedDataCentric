package com.sales.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="CID", columnDefinition="Tinyint(5)")
	private Long cId;

	@Column(name="CNAME", columnDefinition="VARCHAR(45)")
	@NotBlank
	private String cName;
	
	
	@Column(name="LOANPERIOD", columnDefinition="Tinyint(5)")
	@Min(value=1)
	private int loanPeriod;
	
	@OneToMany(mappedBy="cust")
	private List<Loan> loans = new ArrayList<Loan>();

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

}