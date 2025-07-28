/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-07-2025
Time: 6:27 PM
File: MainClass.java */
package main;

import database.DatabaseConnection;
import model.Customer;
import services.CrudOperations;
import services.CustomerCRUD;

import java.util.Scanner;

public class CustomerMain {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
        CrudOperations<Customer> customerCrudOperations = new CustomerCRUD(connection.createConnection());
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        int choice = 0;

        while (choice != 5) {
            System.out.println("Welcome to Customer Management System");
            System.out.println("1. Create Customer");
            System.out.println("2. Read Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            if (choice > 5) {
                System.out.println("Invalid choice");
            }
            switch (choice) {
                case 1: {
                    System.out.println("Enter Customer name, email, phone");
                    customer.setName(scanner.next());
                    customer.setEmail(scanner.next());
                    customer.setPhone(scanner.nextLong());
                    customerCrudOperations.create(customer);
                    break;
                }
                case 2: {
                    System.out.print("Enter Customer id to read: ");
                    customerCrudOperations.read(scanner.nextInt());
                    break;
                }
                case 3: {
                    System.out.println("Enter Customer id to update customer");
                    int id = scanner.nextInt();
                    System.out.println("Enter customer name, email, phone for update customer");
                    customer.setName(scanner.next());
                    customer.setEmail(scanner.next());
                    customer.setPhone(scanner.nextLong());
                    customerCrudOperations.update(id, customer);
                    break;
                }
                case 4: {
                    System.out.println("Enter customer id to delete: ");
                    customerCrudOperations.delete(scanner.nextInt());
                }
            }
        }
    }
}