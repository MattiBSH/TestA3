package integration.datalayer.customer;

import datalayer.customer.BookingStorage;
import datalayer.customer.BookingStorageImpl;
import dto.BookingStorageException;
import dto.CustomerCreation;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
public class CreateBookingTest extends ContainerizedDbIntegrationTest {
    private BookingStorage bookingStorage;

    @BeforeAll
    public void Setup() throws SQLException {
        runMigration(2);
        bookingStorage = new BookingStorageImpl(getConnectionString(), "root", getDbPassword());
    }

    @Test
    public void mustSaveBooking() throws SQLException, BookingStorageException {
        int bookingId=bookingStorage.createBooking(1, 1, "2021-01-02","16","17");
        var bookings = bookingStorage.getBookingsForCustomer(1);
        assertTrue(bookings.stream().anyMatch(x -> x.getId() == bookingId));
    }

    @Test
    public void mustReturnLatestId() throws SQLException, BookingStorageException {
        // Arrange
        // Act
        var id1 = bookingStorage.createBooking(1, 1, "2021-01-02","16","17");
        var id2 = bookingStorage.createBooking(1, 1, "2021-01-02","16","17");

        // Assert
        assertEquals(1, id2 - id1);
    }
}
