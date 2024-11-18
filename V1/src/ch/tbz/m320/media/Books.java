package ch.tbz.m320.media;

public class Books extends Media{
    private long ISBN;

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
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
