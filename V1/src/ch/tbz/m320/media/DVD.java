package ch.tbz.m320.media;

public class DVD extends Media{

    private int movieLength;

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public String toString() {
        return "Book " +
                "\n title: " + title +
                "\n year: " + year +
                "\n price: " + price +
                "\n movie length: " + movieLength;
    }
}
