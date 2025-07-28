/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-07-2025
Time: 4:45 PM
File: CustomerCRUD.java */
package services;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCRUD implements CrudOperations<Customer> {
    private final Connection connection;

    public CustomerCRUD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Customer customer) {
        String query = "INSERT INTO customer (name, email, phone) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setLong(3, customer.getPhone());
            int rowInserted = statement.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("Customer created successfully...");
            } else {
                System.out.println("Failed to create customer.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void read(int id) {
        String query = "SELECT * FROM customer WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                long phone = resultSet.getLong("phone");
                Customer customer = new Customer(customer_id, name, email, phone);
                System.out.println(customer);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, Customer customer) {
        String query = "UPDATE customer SET name = ?, email = ?, phone = ? WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setLong(3, customer.getPhone());
            statement.setInt(4, id);

            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Customer updated successfully...");
            } else {
                System.out.println("Failed to update customer.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM customer WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Customer deleted successfully...");
            } else {
                System.out.println("Failed to delete customer.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}