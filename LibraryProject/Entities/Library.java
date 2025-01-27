package Entities;

import Entities.Media.Media;
import Entities.Media.Media;
import Exceptions.MediaAvailabilityException;
import Exceptions.MemberException;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

class Library {
    private static Library instance; // Singleton instance
    private List<Media> medias;
    private List<Member> members;

    private Library() {
        this.medias = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    private Library(ArrayList<Media> media, ArrayList<Member> members) {
        this.medias = media;
        this.members = members;
    }

    // Singleton Pattern
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addMedia(Media media) {
        medias.add(media);
        System.out.println("Media added: " + media.getTitle());
    }


    public void deleteMedia(String Id) {
        medias.removeIf(media -> media.getMediaID().equals(Id));
        System.out.println("Media deleted with ID: " + Id);
    }


    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }


    public void deleteMember(String memberId) {
        members.removeIf(member -> member.getId().equals(memberId));
        System.out.println("Member deleted with ID: " + memberId);
    }

    public void borrowMedia(String memberId, String mediaId) throws MediaAvailabilityException, MemberException {
        Member member = findMemberById(memberId);
        Media media = findMediaById(mediaId);

        if (!media.isAvailable()) {
            throw new MediaAvailabilityException("Media with ID " + mediaId + " is not available.");
        }

        member.borrowMedia(media);
    }

    public void returnMedia(String memberId, String mediaId) throws MemberException, MediaAvailabilityException {
        Member member = findMemberById(memberId);
        Media media = findMediaById(mediaId);

        member.returnMedia(media);
    }

    private Member findMemberById(String memberId) throws MemberException {
        Optional<Member> member = members.stream().filter(m -> m.getId().equals(memberId)).findFirst();
        if (member.isEmpty()) {
            throw new MemberException("Member with ID " + memberId + " not found.");
        }
        return member.get();
    }

    private Media findMediaById(String mediaId) {
        return medias.stream().filter(media -> media.getMediaID().equals(mediaId)).findFirst().orElse(null);
    }
}
