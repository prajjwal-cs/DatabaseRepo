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

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}