package src.ch.tbz.m320;

public class Verteidiger extends Spieler {
    private int verteidigungNummer;

    public Verteidiger(String name, int verteidigungNummer) {
        super(name);
        this.verteidigungNummer = verteidigungNummer;
    }

    @Override
    public String spielen() {
        return name + " verteidigt als Verteidiger mit der Nummer " + verteidigungNummer + ".";
    }
}
