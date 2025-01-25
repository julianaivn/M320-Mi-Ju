import Entities.Book;
import Entities.Member;
import Exceptions.BookAvailabilityException;
import Exceptions.MemberException;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

class Library implements LibraryOperations {
    private static Library instance; // Singleton instance
    private List<Book> books;
    private List<Member> members;

    private Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Singleton Pattern
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    @Override
    public void deleteBook(String bookId) {
        books.removeIf(book -> book.getId().equals(bookId));
        System.out.println("Book deleted with ID: " + bookId);
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }

    @Override
    public void deleteMember(String memberId) {
        members.removeIf(member -> member.getId().equals(memberId));
        System.out.println("Member deleted with ID: " + memberId);
    }

    public void borrowBook(String memberId, String bookId) throws BookAvailabilityException, MemberException {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (!book.isAvailable()) {
            throw new BookAvailabilityException("Book with ID " + bookId + " is not available.");
        }

        member.borrowBook(book);
    }

    public void returnBook(String memberId, String bookId) throws MemberException {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        member.returnBook(book);
    }

    private Member findMemberById(String memberId) throws MemberException {
        Optional<Member> member = members.stream().filter(m -> m.getId().equals(memberId)).findFirst();
        if (member.isEmpty()) {
            throw new MemberException("Member with ID " + memberId + " not found.");
        }
        return member.get();
    }

    private Book findBookById(String bookId) {
        return books.stream().filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
    }
}
