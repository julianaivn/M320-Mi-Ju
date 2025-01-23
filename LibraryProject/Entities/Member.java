package Entities;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
    private List<Book> borrowedBooks;

    public Member(String name, String id) {
        super(name, id);
        borrowedBooks = new ArrayList<>();
    }

}
