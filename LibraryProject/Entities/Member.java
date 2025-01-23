package Entities;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
    private List<Book> borrowedBooks;

    public Member(String name, String id) {
        super(name, id);
        borrowedBooks = new ArrayList<>();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
    }

    public void returnBook(Book book) {
    }
}
