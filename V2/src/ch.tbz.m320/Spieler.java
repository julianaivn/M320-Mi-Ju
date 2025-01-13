package src.ch.tbz.m320;

public class Spieler {
    protected String name;

    public Spieler(String name) {
        this.name = name;
    }

    public String spielen() {
        return name + " spielt als Spieler.";
    }
}
