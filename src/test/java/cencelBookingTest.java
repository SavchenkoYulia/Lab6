import org.example.Cinema;
import org.example.SelectingSeatsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class cencelBookingTest {
    Cinema cinema = new Cinema();
    int[] canceledSeats;

    @BeforeEach
    public void setUp() throws SelectingSeatsException {
        // Define an array of seats to be booked
        int[] orderSeats = new int[]{3, 4, 5};
        // Book seats for a specific row in the cinema using the defined array
        cinema.bookSeats(3, 2, orderSeats);
    }

    @Test
    void testCancelBookingIsSuccessful() throws SelectingSeatsException {
        // Define an array of seats to be canceled
        canceledSeats = new int[]{3, 4, 5};
        // Attempt to cancel the specified seats and assert no exceptions are thrown
        Assertions.assertDoesNotThrow(() -> {
            cinema.cancelBooking(3, 2, canceledSeats);
        }, "The selected places are free");
    }

    @Test
    void testCancelBookingUnsuccessful() throws SelectingSeatsException {
        // Define an array of invalid seats to be canceled
        canceledSeats = new int[]{6, 7, 8};
        // Attempt to cancel the specified seats and assert a SelectingSeatsException is thrown
        assertThrows(SelectingSeatsException.class, () -> {
            cinema.cancelBooking(3, 2, canceledSeats);
        }, "The selected places are free");
    }

    @Test
    void testCancelBookingNotAllSeats() throws SelectingSeatsException {
        // Define an array of seats to be partially canceled
        canceledSeats = new int[]{5, 7};
        // Attempt to cancel the specified seats and assert no exceptions are thrown
        Assertions.assertDoesNotThrow(() -> {
            cinema.cancelBooking(3, 2, canceledSeats);
        }, "All selected seats is not busy");
    }
}