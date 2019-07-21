package com.sales.services;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.exceptions.BookAlreadyOnLoanException;
import com.sales.exceptions.BookCustNotFoundException;
import com.sales.exceptions.NoSuchLoanException;
import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;

@Service
public class LoanService {
	@Autowired
	BookService bs;
	@Autowired
	CustomerService cs;
	@Autowired
	LoanService ls;
	@Autowired
	LoanRepository lr;

	public Iterable<Loan> getLoans() {
		return lr.findAll();
	}

	public Loan findLoan(Long lid) {
		return lr.findOne(lid);
	}

	public void deleteLoan(Loan loan) throws NoSuchLoanException {
		Loan l = ls.findLoan(loan.getLid());
		if (l == null) {
			throw new NoSuchLoanException("No such Loan: " + loan.getLid());
		} else {
			lr.delete(loan);
		}
	}

	public void addLoan(Loan loan) throws BookCustNotFoundException, BookAlreadyOnLoanException {
		Book book = bs.findBook(loan.getBook().getBid());
		Customer customer = cs.findCustomer(loan.getCust().getcId());

		if (book == null || customer == null) {
			// Throw an exception should there be no existing Customer/Book
			throw new BookCustNotFoundException(
					"No such Customer: " + loan.getCust().getcId() + " No such Book: " + loan.getBook().getBid());
		}

		// Setting the due date = due date + whatever the customers loan period is set
		// at
		LocalDate dateDue = LocalDate.now().plusDays(customer.getLoanPeriod());
		loan.setDueDate(dateDue.toString());

		try {
			// Save the loan as long as the input is valid
			lr.save(loan);
		} catch (Exception e) {
			System.out.println(loan.getCust().getcId());
			// Throw an exception should the input be invalid
			throw new BookAlreadyOnLoanException("Book: " + loan.getBook().getBid() + " (" + book.getTitle()
					+ ") already on Loan to Customer: " + lr.findLoanedBookGuyCid(loan.getBook().getBid()) + " ("
					+ lr.findLoanedBookGuyName(loan.getBook().getBid()) + ")");

		}
	}
}
