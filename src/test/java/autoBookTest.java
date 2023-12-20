import org.example.Cinema;
import org.example.SelectingSeatsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class autoBookTest {

    Cinema cinema = new Cinema();
    @BeforeEach
    void setUp() throws SelectingSeatsException
    {
        int [] seats = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        // Book seats for each row in the cinema using the defined array
        for (int i = 1; i<=cinema.get_rowsAmount();i++)
        {
            cinema.bookSeats(2,i,seats);
        }
        cinema.printSeatingArrangement(2);
    }
    @Test
    void testAutoBookIsSuccessful()throws SelectingSeatsException {
        cinema.cancelBooking(2,5,new int [] {11,12,13,14});
        cinema.printSeatingArrangement(2);
        cinema.autoBook(2,4);
        cinema.printSeatingArrangement(2);
        assertFalse(cinema.checkAvailability(2,1));
    }
    @Test
    void testAutoBookIsUnsuccessful()throws SelectingSeatsException
    {
        // Attempt to auto-book seats for a specific row when there are no free seats
        assertThrows(SelectingSeatsException.class, () -> {
            cinema.autoBook(2,4);
        },"There are no seats for you");
    }
}