package main;

import dto.Customer;
import datalayer.customer.CustomerStorageImpl;
import dto.CustomerCreation;

import java.sql.SQLException;

public class Main {

    private static final String conStr = "jdbc:mysql://127.0.0.1:3306/DemoApplication";
    private static final String user = "root";
    private static final String pass = "password";

    public static void main(String[] args) throws SQLException {
        CustomerStorageImpl storage = new CustomerStorageImpl(conStr, user, pass);

        System.out.println("Got customers: ");
        //storage.createCustomer(new CustomerCreation("Dr", "Bryde"));
        for(Customer c : storage.getCustomers()) {
            System.out.println(toString(c));
        }
        System.out.println("The end.");
    }

    public static String toString(Customer c) {
        return "{" + c.getId() + ", " + c.getFirstname() + ", " + c.getLastname() + "}";
    }
}
