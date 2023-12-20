import org.example.Cinema;
import org.example.SelectingSeatsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bookSeatsTest {
    private Cinema cinema;

    @BeforeEach
    public void setUp ()
    {
        cinema= new Cinema();
    }
    @Test
    void testBookIsAvailable() throws SelectingSeatsException {
        // Define the first order of seats to be booked
        int [] numberOfSeats= {3,4};
        Assertions.assertDoesNotThrow(() -> {
            cinema.bookSeats(3, 2, numberOfSeats);
        }, "Places are already reserved");
    }
    @Test
    void testBookIsNotAvailable() throws SelectingSeatsException {
        // Define the first order of seats to be booked
        int [] firstOrder= {3,4,6};
        // Book the first order of seats
        cinema.bookSeats(3,2,firstOrder);
        // Define the second order of seats to be booked, including an already taken seat
        int [] secondOrder= {3,4,5};
        // Attempt to book the second order of seats and assert a SelectingSeatsException is thrown
        assertThrows(SelectingSeatsException.class, () -> {
            cinema.bookSeats(3,2,secondOrder);
        },"Places are already reserved");
    }
}