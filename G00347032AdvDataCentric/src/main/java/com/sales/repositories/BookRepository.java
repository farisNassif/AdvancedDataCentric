package com.sales.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sales.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	// Query to find books that aren't loaned
	@Query(value = "select " + "books.bid, books.title, books.author from books "
			+ "left join loans on books.bid = loans.bid " + "WHERE lid IS NULL", nativeQuery = true)
	Iterable<Book> findUnloanedBooks();
}
