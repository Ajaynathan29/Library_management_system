package com.library.service;

import com.library.model.Book;
import com.library.patterns.SearchStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryInventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Inventory: Added -> " + book.getTitle());
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
        System.out.println("Inventory: Removed book with ISBN: " + isbn);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Book> searchBooks(SearchStrategy strategy, String query) {
        return strategy.search(getAllBooks(), query);
    }
}