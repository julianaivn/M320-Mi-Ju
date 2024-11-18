package ch.tbz.m320.media;

public class Book extends Media{
    private long ISBN;

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String title, int year, double price, long ISBN) {
        this.title = title;
        this.year = year;
        this.price = price;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book " +
                "\n title: " + title +
                "\n year: " + year +
                "\n price: " + price +
                "\n ISBN: " + ISBN;
    }
}
