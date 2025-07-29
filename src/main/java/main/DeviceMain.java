/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 28-07-2025
Time: 10:39 AM
File: DeviceMain.java */
package main;

import database.DatabaseConnection;
import model.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.CrudOperations;
import services.DeviceCRUD;

import java.util.Scanner;

public class DeviceMain {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        DatabaseConnection connection = new DatabaseConnection();
        CrudOperations<Device> deviceCrudOperations = new DeviceCRUD(connection.createConnection());
        if (connection.createConnection() != null) {
            Device device = new Device();
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            while (choice != 5) {
                System.out.println("Welcome to Device Management System");
                System.out.println("1. Create Device");
                System.out.println("2. Read Device");
                System.out.println("3. Update Device");
                System.out.println("4. Delete Device");
                System.out.println("5. Exit");
                choice = scanner.nextInt();
                if (choice > 5) {
                    logger.error("Invalid choice...//");
                }
                switch (choice) {
                    case 1: {
                        System.out.println("Enter device name, manufacturer_name");
                        device.setName(scanner.next());
                        device.setManufacturer(scanner.next());
                        deviceCrudOperations.create(device);
                        break;
                    }
                    case 2: {
                        System.out.print("Enter device id to read: ");
                        deviceCrudOperations.read(scanner.nextInt());
                        break;
                    }
                    case 3: {
                        System.out.print("Enter device id to update: ");
                        int id = scanner.nextInt();
                        System.out.println("Enter device name, type, manufacturer: ");
                        device.setName(scanner.next());
                        device.setManufacturer(scanner.next());
                        deviceCrudOperations.update(id, device);
                        break;
                    }
                    case 4: {
                        System.out.print("Enter device id to delete: ");
                        int id = scanner.nextInt();
                        deviceCrudOperations.delete(id);
                    }
                }
            }
        } else {
            logger.error("Database Connection failed: {}", connection.toString());
        }
    }
}