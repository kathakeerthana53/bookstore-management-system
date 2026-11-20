package com.bookstore.management.repository;

import com.bookstore.management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long> {

}
