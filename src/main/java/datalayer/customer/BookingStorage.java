package datalayer.customer;

import dto.Booking;
import dto.BookingStorageException;

import java.util.List;

public interface BookingStorage {
    public void createBooking(int customerId, int employeeId, String date, String time,String end) throws BookingStorageException;
    public List<Booking> getBookingsForCustomer(int customerId) throws BookingStorageException;
    public List<Booking> getBookingsForEmployee(int employeeId) throws BookingStorageException;
}
