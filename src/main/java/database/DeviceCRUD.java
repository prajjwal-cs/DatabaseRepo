/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 28-07-2025
Time: 10:41 AM
File: DeviceCRUD.java */
package database;

import model.Device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceCRUD implements CrudOperations<Device> {

    private Connection connection;

    public DeviceCRUD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Device device) {
        String query = "INSERT INTO device (name, type, manufacturer) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, device.getName());
            statement.setString(2, device.getType());
            statement.setString(3, device.getManufacturer());
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("Device created successfully.");
            } else  {
                System.out.println("Failed to create customer.");
            }
        } catch (SQLException e) {
            System.out.println("Error while inserting device");
        }
    }

    @Override
    public void read(int id) {
        String query = "SELECT * FROM device WHERE device_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Reading device: " + resultSet.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, Device device) {
        String query = "UPDATE device SET name = ?, type = ?, manufacturer = ? WHERE device_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, device.getName());
            statement.setString(2, device.getType());
            statement.setString(3, device.getManufacturer());
            statement.setInt(4, id);
            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Device updated successfully.");
            } else   {
                System.out.println("Failed to update customer.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM device WHERE device_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Device deleted successfully.");
            } else   {
                System.out.println("Failed to delete device.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}