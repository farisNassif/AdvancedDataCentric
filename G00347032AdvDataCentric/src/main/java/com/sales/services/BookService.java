package com.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Book;
import com.sales.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository br;

	public Iterable<Book> getBooks() {
		return br.findAll();
	}

	public void addBook(Book b) {
		br.save(b);
	}

	public Iterable<Book> getUnloanedBooks() {
		return br.findUnloanedBooks();
	}

	public Book findBook(Long bid) {
		return br.findOne(bid);
	}
}