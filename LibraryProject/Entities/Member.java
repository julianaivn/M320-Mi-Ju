package Entities;

import Entities.Media.Media;
import Exceptions.MediaAvailabilityException;

import java.util.ArrayList;
import java.util.List;

public class Member  {
    private String name;
    private String id;
    private List<Media> borrowedMedia;

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedMedia = new ArrayList<>();
    }

    public Member(String id){
        this.id = id;
    }

    public List<Media> getBorrowedMedia() {
        return borrowedMedia;
    }

    public void borrowMedia(Media media) throws MediaAvailabilityException {
        borrowedMedia.add(media);
        media.borrow(this.getId());
        System.out.println(getName() + " borrowed: " + media.getTitle());
    }

    public void returnMedia(Media media) throws MediaAvailabilityException {
        borrowedMedia.remove(media);
        media.returnItem();
        System.out.println(getName() + " returned: " + media.getTitle());
    }

    @Override
    public String toString() {
        return "name: " + name + '\n' +
                "id: " + id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
