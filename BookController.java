
package com.bookstore.management.controller;

import com.bookstore.management.entity.Book;
import com.bookstore.management.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get book by ID
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // Add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // Update book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // Delete book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}

