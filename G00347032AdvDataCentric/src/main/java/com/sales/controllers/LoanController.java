package com.sales.controllers;

import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sales.exceptions.BookAlreadyOnLoanException;
import com.sales.exceptions.BookCustNotFoundException;
import com.sales.exceptions.NoSuchLoanException;
import com.sales.models.Loan;
import com.sales.services.LoanService;

@Controller
public class LoanController {

	@Autowired
	LoanService ls;

	// Show Loans
	@RequestMapping(value = "/showLoans")
	public String getLoans(Model model) {
		ArrayList<Loan> loans = (ArrayList<Loan>) ls.getLoans();
		model.addAttribute("loans", loans);
		return "showLoans";
	}

	// New Loan
	@RequestMapping(value = "/newLoan", method = RequestMethod.GET)
	public String addLoanGet(Model m) {
		Loan l = new Loan();
		m.addAttribute("loans", l);
		return "newLoan";
	}

	@RequestMapping(value = "/newLoan", method = RequestMethod.POST)
	public String addLoanPost(@Valid @ModelAttribute("loans") Loan loan, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// Error found
			return "addLoan";
		}
		try {
			// Try delete the loan
			ls.addLoan(loan);
		} catch (BookCustNotFoundException | BookAlreadyOnLoanException e) {
			// If customer wasn't found or book was already on loan
			model.addAttribute("error", e);
			return "errorAddLoan";
		}
		// If no exception was thrown and input was valid, redirect and show loans
		return "redirect:/showLoans";

	}

	@RequestMapping(value = "/deleteLoan", method = RequestMethod.GET)
	public String deleteLoanGet(Model m) {
		Loan l = new Loan();
		m.addAttribute("loans", l);
		return "deleteLoan";
	}

	@RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
	public String deleteLoanPost(@Valid @ModelAttribute("loans") Loan loan, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// Error found
			return "deleteLoan";
		} else {
			try {
				// Try delete the loan
				ls.deleteLoan(loan);
			} catch (NoSuchLoanException e) {
				// If no loan was found, return
				model.addAttribute("error", e);
				return "errorDeleteLoan";
			}
			// If loan was found, redirect and show updated view
			return "redirect:/showLoans";
		}
	}
}
