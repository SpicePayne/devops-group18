package com.napier.app;

import java.sql.*;

/*
 * Database Schema Reference:
 * country (Code, Name, Continent, Region, Population, Capital, ...)
 * city (ID, Name, CountryCode, District, Population, ...)
 * countrylanguage (CountryCode, Language, IsOfficial, Percentage, ...)
 */

public class ReportsApp
{
    public static void main(String[] args)  // Keep 'public' - it's required for main method
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(1000);
                // Connect to database - NOW USING OUR METHOD
                con = getDatabaseConnection();
                System.out.println("Successfully connected");

                // 🎯 EXECUTE REPORTS - Release 1.0
                System.out.println("\n=== RELEASE 1.0 - COUNTRY REPORTS ===");

                // Use Case #1: All countries in world by population
                getAllCountriesByPopulation(con);

                // Use Case #2: All countries in continent by population
                getCountriesInContinentByPopulation(con, "Asia");

                // Use Case #3: All countries in region by population
                getCountriesInRegionByPopulation(con, "Caribbean");

                // Wait a bit
                Thread.sleep(1000);
                // Exit for loop
                break;
            }
            catch (SQLException sqlException)
            {
                // Fixed: Use string concatenation instead of Integer.toString()
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqlException.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }

        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
                System.out.println("Database connection closed.");
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Creates and returns a database connection
     */
    private static Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://db:3306/world?useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "password"
        );
    }

    // 🎯 USE CASE #1: View all Countries in the world by population
    /**
     * Gets all countries in the world sorted by population (largest to smallest)
     * @param con Database connection
     */
    public static void getAllCountriesByPopulation(Connection con) {
        System.out.println("\n--- USE CASE #1: All Countries in World by Population ---");

        try {
            // Create statement for executing the SQL query
            Statement stmt = con.createStatement();

            // SQL query to get all countries sorted by population
            String sql = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "ORDER BY Population DESC";

            // Execute query
            ResultSet rs = stmt.executeQuery(sql);

            // Print header
            System.out.println("Code | Name | Continent | Region | Population | Capital");
            System.out.println("-------------------------------------------------------------------------------");

            // Process results
            int count = 0;
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                int population = rs.getInt("Population");
                int capital = rs.getInt("Capital");

                System.out.printf("%-4s | %-30s | %-10s | %-20s | %,11d | %d%n",
                        code, name, continent, region, population, capital);
                count++;
            }

            // Check if no results found
            if (count == 0) {
                System.out.println("No country data available.");
            } else {
                System.out.println("Total countries: " + count);
            }

            // Clean up
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🎯 USE CASE #2: View all countries in a continent by population
    /**
     * Gets all countries in a specific continent sorted by population
     * @param con Database connection
     * @param continent The continent name (e.g., "Asia", "Europe")
     */
    public static void getCountriesInContinentByPopulation(Connection con, String continent) {
        System.out.println("\n--- USE CASE #2: Countries in Continent by Population ---");
        System.out.println("Continent: " + continent);

        // Validate input
        if (continent == null || continent.trim().isEmpty()) {
            System.out.println("Invalid continent. Try again.");
            return;
        }

        try {
            // Use prepared statement to prevent SQL injection
            String sql = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "WHERE Continent = ? " +
                    "ORDER BY Population DESC";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, continent);

            // Execute query
            ResultSet rs = preparedStatement.executeQuery();

            // Print header
            System.out.println("Code | Name | Continent | Region | Population | Capital");
            System.out.println("-------------------------------------------------------------------------------");

            // Process results
            int count = 0;
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                String cont = rs.getString("Continent");
                String region = rs.getString("Region");
                int population = rs.getInt("Population");
                int capital = rs.getInt("Capital");

                System.out.printf("%-4s | %-30s | %-10s | %-20s | %,11d | %d%n",
                        code, name, cont, region, population, capital);
                count++;
            }

            // Check if no results found
            if (count == 0) {
                System.out.println("No data available for this continent.");
            } else {
                System.out.println("Total countries in " + continent + ": " + count);
            }

            // Clean up
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🎯 USE CASE #3: View all countries in a region by population
    /**
     * Gets all countries in a specific region sorted by population
     * @param con Database connection
     * @param region The region name (e.g., "Caribbean", "Southern Europe")
     */
    public static void getCountriesInRegionByPopulation(Connection con, String region) {
        System.out.println("\n--- USE CASE #3: Countries in Region by Population ---");
        System.out.println("Region: " + region);

        // Validate input
        if (region == null || region.trim().isEmpty()) {
            System.out.println("Invalid region. Try again.");
            return;
        }

        try {
            // Use prepared statement to prevent SQL injection
            String sql = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "WHERE Region = ? " +
                    "ORDER BY Population DESC";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, region);

            // Execute query
            ResultSet rs = preparedStatement.executeQuery();

            // Print header
            System.out.println("Code | Name | Continent | Region | Population | Capital");
            System.out.println("-------------------------------------------------------------------------------");

            // Process results
            int count = 0;
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                String continent = rs.getString("Continent");
                String reg = rs.getString("Region");
                int population = rs.getInt("Population");
                int capital = rs.getInt("Capital");

                System.out.printf("%-4s | %-30s | %-10s | %-20s | %,11d | %d%n",
                        code, name, continent, reg, population, capital);
                count++;
            }

            // Check if no results found
            if (count == 0) {
                System.out.println("No data available for this region.");
            } else {
                System.out.println("Total countries in " + region + ": " + count);
            }

            // Clean up
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}