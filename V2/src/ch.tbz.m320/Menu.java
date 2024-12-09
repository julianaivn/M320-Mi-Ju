package src.ch.tbz.m320;

import java.util.Scanner;

public class Menu {
    private Mannschaft mannschaft;

    public Menu() {
        this.mannschaft = new Mannschaft();
    }

    public void createSpieler() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSpieler erstellen:");
            System.out.println("1: Goalie setzen");
            System.out.println("2: Angreifer hinzufügen");
            System.out.println("3: Verteidiger hinzufügen");
            System.out.println("4: Aktuelle Spieler anzeigen");
            System.out.println("5: Beenden");
            System.out.print("Wählen Sie die Option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Name des Goalies: ");
                String name = scanner.nextLine();
                System.out.print("Körpergröße des Goalies: ");
                double koerperGrosse = scanner.nextDouble();
                scanner.nextLine();
                Goalie goalie = new Goalie(name, koerperGrosse);
                mannschaft.setGoalie(goalie);
                System.out.println("Goalie wurde gesetzt.");

            } else if (choice.equals("2")) {
                System.out.print("Name des Angreifers: ");
                String name = scanner.nextLine();
                int sturmNummer;
                while (true) {
                    System.out.print("Sturmnnummer des Angreifers (zwischen 1 und 16): ");
                    sturmNummer = scanner.nextInt();
                    scanner.nextLine();
                    if (sturmNummer >= 1 && sturmNummer <= 16) {
                        break;
                    } else {
                        System.out.println("Ungültige Nummer. Bitte geben Sie eine Zahl zwischen 1 und 16 ein.");
                    }
                }
                Angreifer angreifer = new Angreifer(name, sturmNummer);
                mannschaft.addAngreifer(angreifer);
                System.out.println("Angreifer wurde hinzugefügt.");

            } else if (choice.equals("3")) {
                System.out.print("Name des Verteidigers: ");
                String name = scanner.nextLine();
                int verteidigungNummer;
                while (true) {
                    System.out.print("Verteidigungsnummer des Verteidigers (zwischen 1 und 4): ");
                    verteidigungNummer = scanner.nextInt();
                    scanner.nextLine();
                    if (verteidigungNummer >= 1 && verteidigungNummer <= 4) {
                        break;
                    } else {
                        System.out.println("Ungültige Nummer. Bitte geben Sie eine Zahl zwischen 1 und 4 ein.");
                    }
                }
                Verteidiger verteidiger = new Verteidiger(name, verteidigungNummer);
                mannschaft.addVerteidiger(verteidiger);
                System.out.println("Verteidiger wurde hinzugefügt.");

            } else if (choice.equals("4")) {
                mannschaft.showPlayers();

            } else if (choice.equals("5")) {
                System.out.println("Programm beendet.");
                break;

            } else {
                System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
            }
        }

        scanner.close();
    }
}
