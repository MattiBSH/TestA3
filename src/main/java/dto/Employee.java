package dto;

import java.time.LocalDateTime;
import java.util.Date;

public class Employee {
    private final int id;
    private final String firstname, lastname;
    private final LocalDateTime birthdate;
    public Employee(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
