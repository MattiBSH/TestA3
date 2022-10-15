package datalayer.customer;

import dto.Employee;
import dto.EmployeeCreation;

import java.sql.SQLException;

public class EmployeeServiceImpl {
    private final EmployeeStorage employeeStorage;

    public EmployeeServiceImpl(EmployeeStorage employeeStorage) {
        this.employeeStorage = employeeStorage;
    }

    public Employee getEmployeeWithId(int employeeId) throws SQLException {
        return employeeStorage.getEmployeeWithId(employeeId);
    }

    public int createEmployee(EmployeeCreation employeeToCreate) throws SQLException {
        return employeeStorage.createEmployee(employeeToCreate);
    }
}
