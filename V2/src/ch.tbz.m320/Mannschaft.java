package src.ch.tbz.m320;

import java.util.ArrayList;

public class Mannschaft {
    private ArrayList<Spieler> spielerListe;

    public Mannschaft() {
        spielerListe = new ArrayList<>();
    }

    public void addSpieler(Spieler spieler) {
        spielerListe.add(spieler);
    }

    public void showTeam() {
        for (Spieler spieler : spielerListe) {
            System.out.println(spieler.spielen());
        }
    }
}
