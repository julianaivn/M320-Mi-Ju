public class Goalie extends Spieler {
    private double koerperGrosse;

    public Goalie(String name, double koerperGrosse) {
        super(name);
        this.koerperGrosse = koerperGrosse;
    }

    @Override
    public String spielen() {
        return name + " ist der Goalie mit Körpergröße " + koerperGrosse + " und hält das Tor sauber.";
    }
}
