import Entities.Library;
import Entities.Media.Book;
import Entities.Media.Media;
import Entities.Media.Movie;
import Entities.Member;
import Exceptions.MediaAvailabilityException;
import Exceptions.MemberException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryOperations {
    private Library library = new Library();

    public void createMedia() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("creating new media type \n-----------------------");
        System.out.println("what type of media are you wanting to create? \n- book\n- movie");
        String mediaType = scanner.nextLine();

        Media media = new Media();
        if (mediaType.equals("book")){
            media = new Book();
        } else if (mediaType.equals("movie")) {
            media = new Movie();
        } else{
            System.out.println("that's not an option - book chosen as default :P");
            media= new Book();
            mediaType = "book";
        }

        System.out.println( mediaType + " title:");
        media.setTitle(scanner.nextLine());

        media.setMediaID(generateID(library.getMedias().size() + 1));

        if (mediaType.equals("book")){
            System.out.println("book author:");
            ((Book) media).setAuthor(scanner.nextLine());
        } else {
            System.out.println("movie duration");
            ((Movie) media).setDuration(scanner.nextInt());
        }

        library.addMedia(media);

    }
    public void createMember() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        Member member = new Member(generateID(library.getMembers().size() + 1));

        System.out.println("Person name:");
        member.setName(scanner.nextLine());

        library.addMember(member);
    }
    private String generateID(int spot) throws NoSuchAlgorithmException {
        String numberAsString = String.valueOf(spot);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(numberAsString.getBytes());

        StringBuilder hexHash = new StringBuilder();
        for (byte b : hashBytes) {
            hexHash.append(String.format("%02x", b));
        }

        return hexHash.toString();
    }
    public void borrowMedia() throws MediaAvailabilityException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title of the media you want to borrow: ");
        Media media = findMediaByName(scanner.nextLine());

        System.out.println("Member name:");
        Member member = findMemberByName(scanner.nextLine());

        if(media == null){
            throw new MediaAvailabilityException("media doesnt exist");
        }
        if(member == null){
            throw new MemberException("person doesnt exist");
        }

        System.out.println("borrowing media...");
        member.borrowMedia(media);
        System.out.println("success!");
    }
    public void deleteMember(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("id of member you want to delete: ");
        Member member = findMemberByID(scanner.nextLine());

        System.out.println("are you sure you want to delete this user:");
        System.out.println(member.toString());
        String userInput = scanner.nextLine();

        if(userInput.equals("yes") || userInput.equals("y")){
            library.deleteMember(member.getId());
            System.out.println("member has been deleted");
        }

    }
    public void deleteMedia(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("id of media you want to delete: ");
        Media media = findMediaByID(scanner.nextLine());

        System.out.print("are you sure you want to delete this ");
        System.out.println(media.toString());
        String userInput = scanner.nextLine();

        if(userInput.equals("yes") || userInput.equals("y")){
            library.deleteMedia(media.getMediaID());
            System.out.println("media has been deleted");
        }

    }
    public void returnMedia() throws MediaAvailabilityException, MemberException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title of the media you want to return: ");
        Media media = findMediaByName(scanner.nextLine());

        System.out.println("Member name:");
        Member member = findMemberByName(scanner.nextLine());
        if(media == null){
            throw new MediaAvailabilityException("media doesnt exist");
        }
        if(member == null){
            throw new MemberException("person doesnt exist");
        }
        System.out.println("returning media...");
        member.returnMedia(media);
        System.out.println("success!");
    }
    private Media findMediaByName(String title) {
        Scanner scanner = new Scanner(System.in);
        Media foundMedia = library.getMedias().stream().filter(media -> media.getTitle().equals(title)).findFirst().orElse(null);

        String userInput = "";

        if(foundMedia == null){
            System.out.println(title + " could not be found");
        } else{
            System.out.print("is this the right ");
            System.out.println(foundMedia.toString());
            userInput = scanner.nextLine();
        }

        if(!userInput.equals("yes") && !userInput.equals("y")){
            System.out.println("searching media by id instead...");
            foundMedia = findMediaByID(scanner.nextLine());
        }

        return foundMedia;

    }
    private Media findMediaByID(String id) {
        return library.getMedias().stream().filter(media -> media.getMediaID().equals(id)).findFirst().orElse(null);
    }
    private Member findMemberByName(String name) {
        Scanner scanner = new Scanner(System.in);
        Member foundMember = library.getMembers().stream().filter(member -> member.getName().equals(name)).findFirst().orElse(null);
        String userInput = "";

        if(foundMember == null){
            System.out.println(name + " could not be found");
        } else{
            System.out.print("is this the right person:");
            System.out.println(foundMember.toString());
            userInput = scanner.nextLine();
        }
        if(!userInput.equals("yes") && !userInput.equals("y")){
            System.out.println("searching member by id instead...");
            foundMember = findMemberByID(scanner.nextLine());
        }

        return foundMember;
    }
    private Member findMemberByID(String id) {
        return library.getMembers().stream().filter(member -> member.getId().equals(id)).findFirst().orElse(null);
    }
    public void setDefaultData() throws NoSuchAlgorithmException {
        ArrayList<Media> media = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        media.add(new Book(generateID(1), "magic book", true, null, null, "peter"));
        media.add(new Book(generateID(media.size() + 1), "funny book", true, null, null, "steve"));
        media.add(new Book(generateID(media.size() + 1), "silly book", true, null, null, "cristina"));
        media.add(new Book(generateID(media.size() + 1), "The Hidden World", true, null, null, "John Doe"));
        media.add(new Book(generateID(media.size() + 1), "Chronicles of Time", true, null, null, "Jane Austen"));
        media.add(new Book(generateID(media.size() + 1), "Lunar Tales", true, null, null, "Isaac Newton"));
        media.add(new Book(generateID(media.size() + 1), "Galaxy Quest", true, null, null, "Carl Sagan"));
        media.add(new Book(generateID(media.size() + 1), "The Mystery Forest", true, null, null, "Agatha Christie"));
        media.add(new Book(generateID(media.size() + 1), "Artificial Minds", true, null, null, "Alan Turing"));

        media.add(new Movie(generateID(media.size() + 1), "super cool movie", true, null, null, 69));
        media.add(new Movie(generateID(media.size() + 1), "best movie", true, null, null, 120));
        media.add(new Movie(generateID(media.size() + 1), "cat movie", true, null, null, 360));
        media.add(new Movie(generateID(media.size() + 1), "Time Travelers", true, null, null, 95));
        media.add(new Movie(generateID(media.size() + 1), "Space Odyssey", true, null, null, 150));
        media.add(new Movie(generateID(media.size() + 1), "The Robot's Revenge", true, null, null, 120));
        media.add(new Movie(generateID(media.size() + 1), "The Endless Journey", true, null, null, 180));
        media.add(new Movie(generateID(media.size() + 1), "Code of Destiny", true, null, null, 140));
        media.add(new Movie(generateID(media.size() + 1), "Eclipse of the Heart", true, null, null, 110));

        members.add(new Member("Alice", generateID(0)));
        members.add(new Member("Bob", generateID(members.size() + 1)));
        members.add(new Member("Charlie", generateID(members.size() + 1)));
        members.add(new Member("Diana", generateID(members.size() + 1)));
        members.add(new Member("Eve", generateID(members.size() + 1)));
        members.add(new Member("Frank", generateID(members.size() + 1)));

        library.setMedias(media);
        library.setMembers(members);
    }
    public void seeAllMedia(){
        System.out.println("========== ALL MEDIA ==========");
        for (Media item : library.getMedias()) {
            System.out.println(item.toString() + '\n');
        }
        System.out.println("===============================");
    }
    public void seeAllMembers(){
        System.out.println("========= ALL MEMBERS =========");
        for (Member item : library.getMembers()) {
            System.out.println(item.toString());
        }
        System.out.println("===============================");
    }

}
