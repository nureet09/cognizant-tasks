package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Default No-Argument Constructor required for setter injection architectures
    public BookService() {
        System.out.println("BookService initialized via no-arg constructor.");
    }

    // Setter method for BookRepository (Step 2 requirement)
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Spring IoC container called setBookRepository() to inject dependency.");
        this.bookRepository = bookRepository;
    }

    public void processBookLoan() {
        System.out.println("Processing business logic inside BookService...");
        bookRepository.saveData();
    }
}

