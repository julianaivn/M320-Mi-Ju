package ch.tbz.m320;

public class Book extends Media {
    private long ISBN;

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String title, int year, double price, long ISBN) {
        super(title, year, price);
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book " +
                super.toString() +
                "\n ISBN: " + ISBN;
    }
}
