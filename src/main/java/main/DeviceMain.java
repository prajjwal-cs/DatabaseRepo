/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 28-07-2025
Time: 10:39 AM
File: DeviceMain.java */
package main;

import database.CrudOperations;
import database.DatabaseConnection;
import database.DeviceCRUD;
import model.Device;

import java.util.Scanner;

public class DeviceMain {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
        CrudOperations<Device> deviceCrudOperations =  new DeviceCRUD(connection.createConnection());
        Device device = new Device();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to Device Management System");
        System.out.println("1. Create Device");
        System.out.println("2. Read Device");
        System.out.println("3. Update Device");
        System.out.println("4. Delete Device");
        System.out.println("5. Exit");
        choice = scanner.nextInt();
        try {
            switch (choice) {
                 case 1: {
                     System.out.println("Enter device name, type, manufacturer_name");
                     device.setName(scanner.next());
                     device.setType(scanner.next());
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
                     device.setType(scanner.next());
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
        } catch (Exception e) {
            System.out.println("Invalid input Please try again...");
        }
    }
}