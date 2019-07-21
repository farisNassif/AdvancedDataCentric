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

import com.sales.exceptions.NoSuchLoanException;
import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bs;

	// Show Books
	@RequestMapping(value = "/showBooks")
	public String getBooks(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bs.getBooks();
		model.addAttribute("books", books);
		return "showBooks";
	}

	// Add Book
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBookGet(Model book) {
		Book b = new Book();
		book.addAttribute("books", b);
		return "addBook";
	}

	// Unloaned Books
	@RequestMapping(value = "/unloanedBooks", method = RequestMethod.GET)
	public String getUnloanedBooks(Model model) {
		// Making an Array list of Unloaned Books.
		// The query to find Unloaned books is contained within BookRepository
		ArrayList<Book> books = (ArrayList<Book>) bs.getUnloanedBooks();
		model.addAttribute("books", books);
		return "unloanedBooks";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBookPOST(@Valid @ModelAttribute("books") Book book, BindingResult result) {
		// Error found
		if (result.hasErrors()) {
			// Don't add book
			return "addBook";
		} else {
			// Otherwise add it & redirect to showBooks
			bs.addBook(book);
			return "redirect:/showBooks";
		}
	}
}
