/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-07-2025
Time: 4:08 PM
File: DatabaseConnection.java */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "123";
    private static Connection connection;

    public Connection createConnection()  {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Connected to database successfully");
            } else {
                System.out.println("Couldn't connect to database");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}