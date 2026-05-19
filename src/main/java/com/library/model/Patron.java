package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Patron implements Observer {
    private String id;
    private String name;
    private List<Book> borrowingHistory;

    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowingHistory = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBorrowingHistory() { return borrowingHistory; }

    public void addToHistory(Book book) {
        borrowingHistory.add(book);
    }

    @Override
    public void update(Book book) {
        System.out.println("🔔 Notification for " + name + ": The book '" + book.getTitle() + "' is now available!");
    }
}