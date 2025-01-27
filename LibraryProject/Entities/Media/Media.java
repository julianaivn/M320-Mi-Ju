package Entities.Media;

import Exceptions.MediaAvailabilityException;

import java.time.LocalDate;

public class Media implements Borrowable{

    private String mediaID;
    private String title;
    private boolean isAvailable;
    private LocalDate borrowedSince;
    private String borrowedById;

    public Media (String mediaID, String title, boolean isAvailable, LocalDate borrowedSince,
                  String borrowedById ){
        this.mediaID = mediaID;
        this.title = title;
        this.isAvailable = isAvailable;
        this.borrowedSince = borrowedSince;
        this.borrowedById = borrowedById;
    }
    public Media(){
        this.isAvailable = true;
        this.borrowedSince = null;
        this.borrowedById = null;
    }

    public void borrow(String memberId) throws MediaAvailabilityException {
        if(isAvailable){
            isAvailable = false;
            borrowedSince = LocalDate.now();
        }else throw new MediaAvailabilityException("Media is unavailable");

    };
    public void returnItem() throws MediaAvailabilityException {
        if(!isAvailable){
            isAvailable = true;
            borrowedSince = null;
        } else throw new MediaAvailabilityException("Media isn't borrowed");
    };

    @Override
    public String toString() {
        if(isAvailable){
            return "mediaID: '" + mediaID + '\n' +
                    "title: " + title + '\n' +
                    "isAvailable: " + isAvailable + '\n';
        } else {
            return "mediaID: '" + mediaID + '\n' +
                    "title: " + title + '\n' +
                    "isAvailable: " + isAvailable + '\n' +
                    "borrowedSince: " + borrowedSince + '\n' +
                    "borrowedById: " + borrowedById + '\n';
        }
    }

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDate getBorrowedSince() {
        return borrowedSince;
    }

    public void setBorrowedSince(LocalDate borrowedSince) {
        this.borrowedSince = borrowedSince;
    }

    public String getBorrowedById() {
        return borrowedById;
    }

    public void setBorrowedById(String borrowedById) {
        this.borrowedById = borrowedById;
    }
}
