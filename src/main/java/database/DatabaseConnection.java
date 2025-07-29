/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-07-2025
Time: 4:08 PM
File: DatabaseConnection.java */
package database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final Logger logger = LogManager.getLogger();
    private static Connection connection;
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "123";

    public Connection createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                logger.info("Connected to database successfully");
            } else {
                logger.error("Couldn't connect to database");
            }
        } catch (SQLException e) {
            logger.debug("SQL Error while connecting to database: {}", e.getMessage());
        }
        return connection;
    }
}