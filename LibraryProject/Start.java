import Exceptions.MediaAvailabilityException;
import Exceptions.MemberException;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws NoSuchAlgorithmException, MediaAvailabilityException, MemberException {
        Scanner scanner = new Scanner(System.in);
        LibraryOperations library = new LibraryOperations();
        library.setDefaultData();
        String input = "";
        while (!input.equals("exit")) {
            System.out.println("what would you like to do?");
            input = scanner.nextLine();

            try {
                switch (input) {
                    case "help": {
                        System.out.println("""
                                options:
                                - see media
                                - see members
                                - create media
                                - create member
                                - borrow media
                                - return media
                                - delete media
                                - delete member
                                """);
                        break;
                    }
                    case "see media":
                        library.seeAllMedia();
                        break;
                    case "see members":
                        library.seeAllMembers();
                        break;
                    case "create media":
                        library.createMedia();
                        break;
                    case "create member":
                        library.createMember();
                        break;
                    case "borrow media":
                        library.borrowMedia();
                        break;
                    case "return media":
                        library.returnMedia();
                        break;
                    case "delete media":
                        library.deleteMedia();
                        break;
                    case "delete member":
                        library.deleteMember();
                        break;
                    case "exit":
                        System.out.println("bye lol");
                        break;
                    default:
                        System.out.println("Invalid option. Type 'help' to see available commands.");
                        break;
                }
            } catch (NoSuchAlgorithmException | MediaAvailabilityException | MemberException e) {
                System.out.println("error " + e);
            }

        }
    }
}
