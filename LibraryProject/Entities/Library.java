package Entities;

import Entities.Media.Media;
import Entities.Media.Media;
import Exceptions.MediaAvailabilityException;
import Exceptions.MemberException;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

public class Library {
    public static Library instance; // Singleton instance
    private List<Media> medias;
    private List<Member> members;

    public Library() {
        this.medias = new ArrayList<>();
        this.members = new ArrayList<>();
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


    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
