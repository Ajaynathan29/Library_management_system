package com.library;

import com.library.model.*;
import com.library.patterns.*;
import com.library.service.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        LibraryInventory inventory = new LibraryInventory();
        LendingService lendingService = new LendingService();

        // 1. Create books using Factory Pattern
        Book book1 = BookFactory.createBook("1984", "George Orwell", "12345", 1949);
        Book book2 = BookFactory.createBook("The Hobbit", "J.R.R. Tolkien", "67890", 1937);

        // Add to inventory
        inventory.addBook(book1);
        inventory.addBook(book2);

        // 2. Create Patrons
        Patron alice = new Patron("P01", "Alice");
        Patron bob = new Patron("P02", "Bob");

        // 3. Simulate Lending and Reserving
        System.out.println("\n--- Checkout Phase ---");
        lendingService.checkoutBook(book1, alice);
        
        // Bob tries to checkout 1984, but it's unavailable, so he reserves it
        lendingService.checkoutBook(book1, bob); 
        lendingService.reserveBook(book1, bob);

        System.out.println("\n--- Return Phase ---");
        // Alice returns the book, which automatically notifies Bob (Observer Pattern)
        lendingService.returnBook(book1);
        
        System.out.println("\n--- Search Phase ---");
        // Using Strategy Pattern to dynamically search
        String searchQuery = "hobbit";
        SearchStrategy searchStrategy = new SearchByTitle();
        List<Book> searchResults = inventory.searchBooks(searchStrategy, searchQuery);
        
        if(!searchResults.isEmpty()) {
            System.out.println("Search result for '" + searchQuery + "': " + searchResults.get(0).toString());
        }
    }
}