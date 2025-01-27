package Entities.Media;

import Exceptions.MediaAvailabilityException;

public interface Borrowable {
    void borrow(String memberId) throws MediaAvailabilityException;
    void returnItem() throws MediaAvailabilityException;

}
