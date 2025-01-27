package Entities.Media;

import java.time.LocalDate;

public class Movie extends Media{

    private int duration;

    public Movie(String mediaID, String title, boolean isAvailable, LocalDate borrowedSince,
                String borrowedById,  int duration) {
        super(mediaID, title, isAvailable, borrowedSince, borrowedById);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
