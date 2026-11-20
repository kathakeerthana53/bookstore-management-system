
package com.bookstore.management.service;

import com.bookstore.management.entity.Book;
import com.bookstore.management.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setQuantity(book.getQuantity());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Book not found"));

        bookRepository.delete(existingBook);
    }
}
