package Entities;

import Entities.Media.Media;
import Exceptions.MediaAvailabilityException;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
    private List<Media> borrowedMedia;

    public Member(String name, String id) {
        super(name, id);
        borrowedMedia = new ArrayList<>();
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
}
