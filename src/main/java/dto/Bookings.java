package dto;

public class Bookings {
    private final int id;
    private final int customerId;
    private final int employeeId;
    private final int serviceId;
    private final String date;
    private final String start;
    private final String end;

    public Bookings(int id, int customerId, int employeeId, int serviceId, String date, String start,String end) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.serviceId = serviceId;
        this.date = date;
        this.start= start;
        this.end= end;
    }
}
