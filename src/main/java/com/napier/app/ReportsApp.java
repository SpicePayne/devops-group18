package com.napier.app;

import java.sql.*;


public class ReportsApp {

    // Connection object
    private static Connection connection = null;

    // Method 1: Connect to Database
    public static void connectToDatabase() {
        try {
            // Retrieve credentials securely from environment variables
            String url = System.getenv("DB_URL");        // stored in environment variable
            String user = System.getenv("DB_USER");      // stored in environment variable
            String password = System.getenv("DB_PASS");  // stored in environment variable

            if (url == null || user == null || password == null) {
                System.err.println("Missing database environment variables (DB_URL, DB_USER, DB_PASS).");
                return;
            }

            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to the database.");

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        }
    }

    //  Method 2: Disconnect from Database
    public static void disconnectDatabase() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔌 Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }

    //  Method 3: Display countries sorted by population (ascending)
    public static void displayCountriesAscending() {
        if (connection == null) {
            System.err.println("Please connect to the database first.");
            return;
        }

        String query = "SELECT name, population FROM country ORDER BY population ASC";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n Countries sorted by population (smallest → largest):");
            System.out.println("---------------------------------------------------------");
            System.out.printf("%-40s %s%n", "Country", "Population");
            System.out.println("---------------------------------------------------------");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                long population = resultSet.getLong("population");
                System.out.printf("%-40s %d%n", name, population);
            }

        } catch (SQLException e) {
            System.err.println("Query error: " + e.getMessage());
        }
    }

    //  Main method
    public static void main(String[] args) {
        connectToDatabase();          // Connect
        displayCountriesAscending();  // Display results
        disconnectDatabase();         // Disconnect
    }
}
