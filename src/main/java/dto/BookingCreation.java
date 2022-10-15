package dto;

public class BookingCreation {
    public final String date, start, end;
    public final int id, customerId, employeeId, serviceId;

    public BookingCreation(int id, int customerId, int employeeId, int serviceId, String date, String start, String end) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.serviceId = serviceId;
        this.date = date;
        this.start= start;
        this.end= end;
    }

}
