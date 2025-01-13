package ch.tbz.m320;

import java.util.ArrayList;
import java.util.Scanner;

public class List {
    private ArrayList<Media> allMedia;
    private ArrayList<Media> mediaList;

    public List() {
        allMedia = new ArrayList<>();
        mediaList = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        this.allMedia.add(new Book("The Great Gatsby", 1925, 10.99, 9780743273565L));
        this.allMedia.add(new Book("Twilight", 2007, 39.90, 9781904233657L));
        this.allMedia.add(new DVD("The Little Mermaid", 1989, 9.25, 83));
        this.allMedia.add(new DVD("The Lion King", 1994, 7.25, 88));
        this.allMedia.add(new CD("Dead Again", 2007, 24.90, "Type O Negative"));
        this.allMedia.add(new CD("Meteora - 20th Anniversary", 2023, 61.10, "Linkin Park"));

        while (true) {
            System.out.println("\nWhat do you want to do?\n" +
                    "1. See all media\n" +
                    "2. Add media to your list\n" +
                    "3. Remove media from your list\n" +
                    "4. See your list\n" +
                    "5. Exit");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> {
                    for (Media media : this.allMedia) {
                        System.out.println(media.toString());
                    }
                }
                case 2 -> {
                    Media media = getByTitle();
                    if (media == null) {
                        System.out.println("This media can't be found.");
                    } else {
                        this.mediaList.add(media);
                        System.out.println("Media added to your list.");
                    }
                }
                case 3 -> {
                    Media media = getByTitle();
                    if (media == null) {
                        System.out.println("This media can't be found.");
                    } else {
                        this.mediaList.removeIf(m -> m.getTitle().equalsIgnoreCase(media.getTitle()));
                        System.out.println("Media removed from your list.");
                    }
                }
                case 4 -> {
                    if (mediaList.isEmpty()) {
                        System.out.println("Your list is empty.");
                    } else {
                        for (Media media : mediaList) {
                            System.out.println(media.toString());
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private Media getByTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's the title?");
        String input = scanner.nextLine();

        for (Media media : allMedia) {
            if (media.getTitle().equalsIgnoreCase(input)) {
                return media;
            }
        }

        return null;
    }
}
