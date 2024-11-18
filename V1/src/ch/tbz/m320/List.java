package ch.tbz.m320;

import ch.tbz.m320.media.Media;
import ch.tbz.m320.media.Book;
import ch.tbz.m320.media.CD;
import ch.tbz.m320.media.DVD;

import java.util.ArrayList;
import java.util.Scanner;

public class List {
    private ArrayList<Media> allMedia;
    private ArrayList<Media> mediaList;

    public void List(){
        Scanner scanner = new Scanner(System.in);
        allMedia.add(new Book("The Great Gatsby", 1925, 10.99, 9780743273565L));
        allMedia.add(new Book("Twilight", 2007, 39.90, 9781904233657L));
        allMedia.add(new DVD("The Little Mermaid", 1989, 9.25,83));
        allMedia.add(new DVD("the lion king", 1994, 7.25, 88));
        allMedia.add(new CD("dead again", 2007,24.90,"Type o Negative"));
        allMedia.add(new CD("Meteora - 20th anniversary", 2023, 61.10,"Linkin park"));


        System.out.println("what do you want to do?\n " +
                "1. see all media\n " +
                "2. add media to your list\n " +
                "3. remove media from your list\n " +
                "4. see your list");

        int userChoise = scanner.nextInt();

        switch (userChoise) {
            case 1 -> {
                for (Media media : allMedia) {
                    System.out.println(media.toString());
                }
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {
                for (Media media : mediaList) {
                    System.out.println(media.toString());
                }
            }

        };
    }


}
