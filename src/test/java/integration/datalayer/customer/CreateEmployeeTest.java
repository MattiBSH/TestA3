package integration.datalayer.customer;

import datalayer.customer.EmployeeStorage;
import datalayer.customer.EmployeeStorageImpl;
import integration.ContainerizedDbIntegrationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.employee.EmployeeServiceException;
import servicelayer.employee.EmployeeServiceImpl;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
public class CreateEmployeeTest extends ContainerizedDbIntegrationTest {
    private EmployeeStorage employeeStorage;

    @BeforeAll
    public void Setup() throws SQLException {

        runMigration(3);
        employeeStorage = new EmployeeStorageImpl(getConnectionString(), "root", getDbPassword());
    }

    @Test
    public void mustSaveEmployeeInDatabaseWhenCallingCreateEmployee() throws SQLException, EmployeeServiceException {
        // Arrange
        var employeeService = new EmployeeServiceImpl(employeeStorage);
        // Act
        int employeeId=employeeService.employeeCreation("John","Carlssonn");
        // Assert
        var employee = employeeStorage.getEmployeeWithId(employeeId);
        assertTrue(employee!=null);
    }

    @Test
    public void mustReturnLatestId() throws SQLException, EmployeeServiceException {
        // Arrange
        var employeeService = new EmployeeServiceImpl(employeeStorage);
        // Act
        var id1 = employeeService.employeeCreation("John","Carlssonn");
        var id2 = employeeService.employeeCreation("Matti","Hansen");
        // Assert
        assertEquals(1, id2 - id1);
    }

}
