package com.sales.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sales.models.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

	// Should return the ID for the guy who already has the book on loan
	@Query(value = "select customers.cid from customers left join loans on customers.cid = "
			+ "loans.cid where loans.bid = :bid", nativeQuery = true)
	long findLoanedBookGuyCid(@Param("bid") long bid);
	
	// Should return the Name for the guy who already has the book on loan
	@Query(value = "select customers.cname from customers left join loans on customers.cid = "
			+ "loans.cid where loans.bid = :bid", nativeQuery = true)
	String findLoanedBookGuyName(@Param("bid") long bid);
}
