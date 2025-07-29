/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 28-07-2025
Time: 10:41 AM
File: DeviceCRUD.java */
package services;

import model.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceCRUD implements CrudOperations<Device> {
    private static final Logger logger = LogManager.getLogger();
    private final Connection connection;
    public DeviceCRUD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Device device) {
        String query = "INSERT INTO device (name, manufacture) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, device.getName());
            statement.setString(2, device.getManufacturer());
            int row = statement.executeUpdate();
            if (row > 0) {
                logger.info("Device created successfully.");
            } else  {
                logger.error("Failed to create customer.");
            }
        } catch (SQLException e) {
            logger.debug("Error while inserting device: {}", e.getMessage());
        }
    }

    @Override
    public void read(int id) {
        String query = "SELECT * FROM device WHERE device_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int device_id = resultSet.getInt("device_id");
                String name = resultSet.getString("name");
                String manufacturer = resultSet.getString("manufacturer");
                Device device = new Device(device_id, name, manufacturer);
                System.out.println(device);
            }
            System.out.println("Reading device: " + resultSet.toString());
        } catch (SQLException e) {
            logger.debug("SQL exception when reading device: {}", e.getMessage());
        }
    }

    @Override
    public void update(int id, Device device) {
        String query = "UPDATE device SET name = ?, manufacturer = ? WHERE device_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, device.getName());
            statement.setString(2, device.getManufacturer());
            statement.setInt(4, id);
            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                logger.info("Device updated successfully.");
            } else   {
                logger.error("Failed to update customer.");
            }
        } catch (Exception e) {
            logger.debug("Exception when executing update query in device: {}", e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM device WHERE device_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                logger.info("Device deleted successfully.");
            } else   {
                logger.error("Failed to delete device.");
            }
        } catch (Exception e) {
            logger.debug("Exception when executing delete Query in device: {}", e.getMessage());
        }
    }
}