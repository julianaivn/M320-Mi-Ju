package ch.tbz.m320.media;

public class DVD extends Media{

    private int movieLength;

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public DVD(String title, int year, double price, int movieLength) {
        this.title = title;
        this.year = year;
        this.price = price;
        this.movieLength = movieLength;
    }

    public String toString() {
        return "DVD " +
                "\n title: " + title +
                "\n year: " + year +
                "\n price: " + price +
                "\n movie length: " + movieLength;
    }
}
