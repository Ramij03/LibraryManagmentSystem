package com.example.LibraryManagmentSystem;


import com.example.LibraryManagmentSystem.Book;
import com.example.LibraryManagmentSystem.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    @Transactional
    public Book addBook(Book book) {
        // You can implement validation logic here if needed
        return bookRepository.save(book);
    }
    @Transactional
    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        return null; // or throw an exception
    }
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
