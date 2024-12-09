package src.ch.tbz.m320;

import java.util.ArrayList;

public class Mannschaft {
    private Goalie goalie;
    private ArrayList<Angreifer> angreiferListe;
    private ArrayList<Verteidiger> verteidigerListe;

    public Mannschaft() {
        this.goalie = null;
        this.angreiferListe = new ArrayList<>();
        this.verteidigerListe = new ArrayList<>();
    }

    public void setGoalie(Goalie goalie) {
        this.goalie = goalie;
    }

    public void addAngreifer(Angreifer angreifer) {
        angreiferListe.add(angreifer);
    }

    public void addVerteidiger(Verteidiger verteidiger) {
        verteidigerListe.add(verteidiger);
    }

    public void showPlayers() {
        System.out.println("\nAktuelle Mannschaft:");

        // Goalie
        if (goalie != null) {
            System.out.println("Goalie: " + goalie.spielen());
        } else {
            System.out.println("Goalie: Kein Spieler mit dieser Position vorhanden.");
        }

        // Angreifer
        if (!angreiferListe.isEmpty()) {
            System.out.println("Angreifer:");
            for (Angreifer angreifer : angreiferListe) {
                System.out.println("- " + angreifer.spielen());
            }
        } else {
            System.out.println("Angreifer: Kein Spieler mit dieser Position vorhanden.");
        }

        // Verteidiger
        if (!verteidigerListe.isEmpty()) {
            System.out.println("Verteidiger:");
            for (Verteidiger verteidiger : verteidigerListe) {
                System.out.println("- " + verteidiger.spielen());
            }
        } else {
            System.out.println("Kein Spieler mit dieser Position vorhanden.");
        }
    }
}

