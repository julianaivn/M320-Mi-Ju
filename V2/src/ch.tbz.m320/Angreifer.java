public class Angreifer extends Spieler {
    private int sturmNummer;

    public Angreifer(String name, int sturmNummer) {
        super(name);
        this.sturmNummer = sturmNummer;
    }

    @Override
    public String spielen() {
        return name + " greift als Angreifer mit der Nummer " + sturmNummer + " an.";
    }
}
