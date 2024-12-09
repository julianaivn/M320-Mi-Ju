package src.ch.tbz.m320;

import java.util.Scanner;

public class Menu {
    private Mannschaft mannschaft;

    public Menu() {
        mannschaft = new Mannschaft();
    }

    public void createSpieler() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSpieler erstellen:");
            System.out.println("1: Goalie");
            System.out.println("2: Angreifer");
            System.out.println("3: Verteidiger");
            System.out.println("4: Fertig");
            System.out.print("Wählen Sie die Position: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Name des Goalies: ");
                String name = scanner.nextLine();
                System.out.print("Körpergröße des Goalies: ");
                double koerperGrosse = scanner.nextDouble();
                scanner.nextLine(); // Consume leftover newline
                mannschaft.addSpieler(new Goalie(name, koerperGrosse));

            } else if (choice.equals("2")) {
                System.out.print("Name des Angreifers: ");
                String name = scanner.nextLine();
                System.out.print("Sturmnnummer des Angreifers: ");
                int sturmNummer = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
                mannschaft.addSpieler(new Angreifer(name, sturmNummer));

            } else if (choice.equals("3")) {
                System.out.print("Name des Verteidigers: ");
                String name = scanner.nextLine();
                System.out.print("Verteidigungsnummer des Verteidigers: ");
                int verteidigungNummer = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
                mannschaft.addSpieler(new Verteidiger(name, verteidigungNummer));

            } else if (choice.equals("4")) {
                System.out.println("\nMannschaftszusammenstellung abgeschlossen.\n");
                break;

            } else {
                System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
            }
        }

        scanner.close();
    }

    public void showMannschaft() {
        System.out.println("\nMannschaft:");
        mannschaft.showTeam();
    }
}
