package Entities.Media;

import java.time.LocalDate;

public class Book extends Media{
    private String author;

    public Book(String mediaID, String title, boolean isAvailable, LocalDate borrowedSince,
                String borrowedById,  String author) {
        super(mediaID, title, isAvailable, borrowedSince, borrowedById);
        this.author = author;
    }

    public Book(){
        super();
    }

    @Override
    public String toString() {
        return "Book\n" +
                super.toString() +
                "author='" + author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
