package com.library.service;

import com.library.model.Book;
import com.library.model.Patron;

public class LendingService {

    public void checkoutBook(Book book, Patron patron) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            patron.addToHistory(book);
            System.out.println("Lending: " + patron.getName() + " checked out " + book.getTitle());
        } else {
            System.out.println("Lending: " + book.getTitle() + " is currently unavailable.");
        }
    }

    public void returnBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("Lending: " + book.getTitle() + " has been returned.");
            book.setAvailable(true); // Triggers Observer notification
        }
    }

    public void reserveBook(Book book, Patron patron) {
        if (!book.isAvailable()) {
            book.registerObserver(patron);
            System.out.println("Lending: " + patron.getName() + " reserved " + book.getTitle());
        } else {
            System.out.println("Lending: " + book.getTitle() + " is already available.");
        }
    }
}