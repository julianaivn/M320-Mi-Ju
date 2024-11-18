package ch.tbz.m320.media;

public class CD extends Media{
    private String bandName;

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String toString() {
        return "Book " +
                "\n title: " + title +
                "\n year: " + year +
                "\n price: " + price +
                "\n band-name: " + bandName;
    }
}
