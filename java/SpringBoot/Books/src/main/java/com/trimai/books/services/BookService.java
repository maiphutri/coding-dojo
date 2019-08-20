package com.trimai.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trimai.books.models.Book;
import com.trimai.books.repositories.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepo;
	
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			Book editBook = book.get();
			editBook.setTitle(title);
			editBook.setDescription(desc);
			editBook.setLanguage(lang);
			editBook.setNumberOfPages(pages);
			bookRepo.save(editBook);
			return editBook;
			
		} else {
			return null;
		}

	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
