package ch.tbz.m320.media;

public class CD extends Media{
    private String bandName;

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public CD(String title, int year, double price, String bandName) {
        this.title = title;
        this.year = year;
        this.price = price;
        this.bandName = bandName;
    }

    public String toString() {
        return "CD " +
                "\n title: " + title +
                "\n year: " + year +
                "\n price: " + price +
                "\n band-name: " + bandName;
    }
}
