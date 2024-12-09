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
            System.out.println("1: Set Goalie");
            System.out.println("2: Add Angreifer");
            System.out.println("3: Add Verteidiger");
            System.out.println("4: Show current players");
            System.out.println("5: Exit");
            System.out.print("Wählen Sie die Option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Name des Goalies: ");
                String name = scanner.nextLine();
                System.out.print("Körpergröße des Goalies: ");
                double koerperGrosse = scanner.nextDouble();
                scanner.nextLine(); // Consume leftover newline
                Goalie goalie = new Goalie(name, koerperGrosse);
                mannschaft.setGoalie(goalie);
                System.out.println("Goalie wurde gesetzt.");

            } else if (choice.equals("2")) {
                System.out.print("Name des Angreifers: ");
                String name = scanner.nextLine();
                System.out.print("Sturmnnummer des Angreifers: ");
                int sturmNummer = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
                Angreifer angreifer = new Angreifer(name, sturmNummer);
                mannschaft.addAngreifer(angreifer);
                System.out.println("Angreifer wurde hinzugefügt.");

            } else if (choice.equals("3")) {
                System.out.print("Name des Verteidigers: ");
                String name = scanner.nextLine();
                System.out.print("Verteidigungsnummer des Verteidigers: ");
                int verteidigungNummer = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
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
