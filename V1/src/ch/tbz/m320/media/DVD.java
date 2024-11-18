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
        super(title, year, price);
        this.movieLength = movieLength;
    }

    public String toString() {
        return "DVD " +
                super.toString() +
                "\n movie length: " + movieLength;
    }
}
