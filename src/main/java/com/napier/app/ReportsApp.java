package com.napier.app;

import java.sql.*;
import java.util.Scanner;

/*
 * Database Schema Reference: city, country and countrylanguage
 */
public class ReportsApp
{
    //Database connection method
    private static Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://db:3306/world?useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "password"
        );
    }

    /**
     * Displays the main menu
     */
    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("      WORLD POPULATION REPORTING SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Country Reports");
        System.out.println("2. City Reports");
        System.out.println("3. Capital City Reports");
        System.out.println("4. Population Reports");
        System.out.println("5. Language Reports");
        System.out.println("6. Exit");
        System.out.println("=".repeat(60));
    }

    /**
     * Country Reports Submenu
     */
    private static void countryReportsMenu(Connection con, Scanner scanner) {
        boolean inSubmenu = true;

        while (inSubmenu) {
            System.out.println("\n--- COUNTRY REPORTS ---");
            System.out.println("1. All Countries in World");
            System.out.println("2. Countries in Continent");
            System.out.println("3. Countries in Region");
            System.out.println("4. Top N Countries in World");
            System.out.println("5. Top N Countries in Continent");
            System.out.println("6. Top N Countries in Region");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice (1-7): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        getAllCountriesByPopulation(con);
                        break;
                    case 2:
                        System.out.print("Enter continent name: ");
                        String continent = scanner.nextLine();
                        getCountriesInContinentByPopulation(con, continent);
                        break;
                    case 3:
                        System.out.print("Enter region name: ");
                        String region = scanner.nextLine();
                        getCountriesInRegionByPopulation(con, region);
                        break;
                    case 4:
                        System.out.print("Enter number of countries (N): ");
                        int nWorld = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCountriesInWorld(con, nWorld);
                        break;
                    case 5:
                        System.out.print("Enter continent name: ");
                        String continentTopN = scanner.nextLine();
                        System.out.print("Enter number of countries (N): ");
                        int nContinent = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCountriesInContinent(con, continentTopN, nContinent);
                        break;
                    case 6:
                        System.out.print("Enter region name: ");
                        String regionTopN = scanner.nextLine();
                        System.out.print("Enter number of countries (N): ");
                        int nRegion = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCountriesInRegion(con, regionTopN, nRegion);
                        break;
                    case 7:
                        inSubmenu = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number between 1 and 7.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * City Reports Submenu - Release 3.0 & 4.0
     */
    private static void cityReportsMenu(Connection con, Scanner scanner) {
        boolean inSubmenu = true;

        while (inSubmenu) {
            System.out.println("\n--- CITY REPORTS ---");
            System.out.println("1. All Cities in World");
            System.out.println("2. Cities in Continent");
            System.out.println("3. Cities in Region");
            System.out.println("4. Cities in Country");
            System.out.println("5. Cities in District");
            System.out.println("6. Top N Cities in World");
            System.out.println("7. Top N Cities in Continent");
            System.out.println("8. Top N Cities in Region");
            System.out.println("9. Top N Cities in Country");
            System.out.println("10. Top N Cities in District");
            System.out.println("11. Back to Main Menu");
            System.out.print("Enter your choice (1-11): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        getAllCitiesByPopulation(con);
                        break;
                    case 2:
                        System.out.print("Enter continent name: ");
                        String continent = scanner.nextLine();
                        getCitiesInContinentByPopulation(con, continent);
                        break;
                    case 3:
                        System.out.print("Enter region name: ");
                        String region = scanner.nextLine();
                        getCitiesInRegionByPopulation(con, region);
                        break;
                    case 4:
                        System.out.print("Enter country name: ");
                        String country = scanner.nextLine();
                        getCitiesInCountryByPopulation(con, country);
                        break;
                    case 5:
                        System.out.print("Enter district name: ");
                        String district = scanner.nextLine();
                        getCitiesInDistrictByPopulation(con, district);
                        break;
                    case 6:
                        System.out.print("Enter number of cities (N): ");
                        int nWorld = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCitiesInWorld(con, nWorld);
                        break;
                    case 7:
                        System.out.print("Enter continent name: ");
                        String continentTopN = scanner.nextLine();
                        System.out.print("Enter number of cities (N): ");
                        int nContinent = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCitiesInContinent(con, continentTopN, nContinent);
                        break;
                    case 8:
                        System.out.print("Enter region name: ");
                        String regionTopN = scanner.nextLine();
                        System.out.print("Enter number of cities (N): ");
                        int nRegion = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCitiesInRegion(con, regionTopN, nRegion);
                        break;
                    case 9:
                        System.out.print("Enter country name: ");
                        String countryTopN = scanner.nextLine();
                        System.out.print("Enter number of cities (N): ");
                        int nCountry = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCitiesInCountry(con, countryTopN, nCountry);
                        break;
                    case 10:
                        System.out.print("Enter district name: ");
                        String districtTopN = scanner.nextLine();
                        System.out.print("Enter number of cities (N): ");
                        int nDistrict = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCitiesInDistrict(con, districtTopN, nDistrict);
                        break;
                    case 11:
                        inSubmenu = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 11.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Capital City Reports Submenu - Release 5.0 & 6.0
     */
    private static void capitalCityReportsMenu(Connection con, Scanner scanner) {
        boolean inSubmenu = true;

        while (inSubmenu) {
            System.out.println("\n--- CAPITAL CITY REPORTS ---");
            System.out.println("1. All Capital Cities in World");
            System.out.println("2. Capital Cities in Continent");
            System.out.println("3. Capital Cities in Region");
            System.out.println("4. Top N Capital Cities in World");
            System.out.println("5. Top N Capital Cities in Continent");
            System.out.println("6. Top N Capital Cities in Region");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice (1-7): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        getAllCapitalCitiesByPopulation(con);
                        break;
                    case 2:
                        System.out.print("Enter continent name: ");
                        String continent = scanner.nextLine();
                        getCapitalCitiesInContinentByPopulation(con, continent);
                        break;
                    case 3:
                        System.out.print("Enter region name: ");
                        String region = scanner.nextLine();
                        getCapitalCitiesInRegionByPopulation(con, region);
                        break;
                    case 4:
                        System.out.print("Enter number of capital cities (N): ");
                        int nWorld = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCapitalCitiesInWorld(con, nWorld);
                        break;
                    case 5:
                        System.out.print("Enter continent name: ");
                        String continentTopN = scanner.nextLine();
                        System.out.print("Enter number of capital cities (N): ");
                        int nContinent = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCapitalCitiesInContinent(con, continentTopN, nContinent);
                        break;
                    case 6:
                        System.out.print("Enter region name: ");
                        String regionTopN = scanner.nextLine();
                        System.out.print("Enter number of capital cities (N): ");
                        int nRegion = scanner.nextInt();
                        scanner.nextLine();
                        getTopNCapitalCitiesInRegion(con, regionTopN, nRegion);
                        break;
                    case 7:
                        inSubmenu = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Population Reports Submenu - Release 7.0 & 9.0
     */
    private static void populationReportsMenu(Connection con, Scanner scanner) {
        boolean inSubmenu = true;

        while (inSubmenu) {
            System.out.println("\n--- POPULATION REPORTS ---");
            System.out.println("1. Population Report by Continent");
            System.out.println("2. Population Report by Region");
            System.out.println("3. Population Report by Country");
            System.out.println("4. Overall World Population Summary");
            System.out.println("5. Population Summary by Continent");
            System.out.println("6. Population Summary by Region");
            System.out.println("7. Population Summary by Country");
            System.out.println("8. Population Summary by District");
            System.out.println("9. Population Summary by City");
            System.out.println("10. Back to Main Menu");
            System.out.print("Enter your choice (1-10): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        getPopulationReportByContinent(con);
                        break;
                    case 2:
                        System.out.print("Enter region name: ");
                        String region = scanner.nextLine();
                        getPopulationReportByRegion(con, region);
                        break;
                    case 3:
                        System.out.print("Enter country name: ");
                        String country = scanner.nextLine();
                        getPopulationReportByCountry(con, country);
                        break;
                    case 4:
                        getWorldPopulationSummary(con);
                        break;
                    case 5:
                        System.out.print("Enter continent name: ");
                        String continentSummary = scanner.nextLine();
                        getPopulationSummaryByContinent(con, continentSummary);
                        break;
                    case 6:
                        System.out.print("Enter region name: ");
                        String regionSummary = scanner.nextLine();
                        getPopulationSummaryByRegion(con, regionSummary);
                        break;
                    case 7:
                        System.out.print("Enter country name: ");
                        String countrySummary = scanner.nextLine();
                        getPopulationSummaryByCountry(con, countrySummary);
                        break;
                    case 8:
                        System.out.print("Enter district name: ");
                        String districtSummary = scanner.nextLine();
                        getPopulationSummaryByDistrict(con, districtSummary);
                        break;
                    case 9:
                        System.out.print("Enter city name: ");
                        String citySummary = scanner.nextLine();
                        getPopulationSummaryByCity(con, citySummary);
                        break;
                    case 10:
                        inSubmenu = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Language Reports Submenu - Release 8.0
     */
    private static void languageReportsMenu(Connection con, Scanner scanner) {
        boolean inSubmenu = true;

        while (inSubmenu) {
            System.out.println("\n--- LANGUAGE REPORTS ---");
            System.out.println("1. Key Languages Report (Chinese, English, Hindi, Spanish, Arabic)");
            System.out.println("2. Custom Languages Report");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice (1-3): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Default key languages as specified in use case
                        String[] keyLanguages = {"Chinese", "English", "Hindi", "Spanish", "Arabic"};
                        getLanguageReport(con, keyLanguages);
                        break;
                    case 2:
                        System.out.print("Enter languages (comma-separated, e.g., French,German,Japanese): ");
                        String input = scanner.nextLine();
                        String[] customLanguages = input.split(",");
                        // Trim whitespace from each language
                        for (int i = 0; i < customLanguages.length; i++) {
                            customLanguages[i] = customLanguages[i].trim();
                        }
                        getLanguageReport(con, customLanguages);
                        break;
                    case 3:
                        inSubmenu = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Establishes database connection with retry logic
     */
    private static Connection establishDatabaseConnection() {
        Connection con = null;
        int retries = 100;

        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                Thread.sleep(1000);
                con = getDatabaseConnection();
                System.out.println("Successfully connected to database!");
                return con;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        // Use args parameter to eliminate warning
        if (args.length > 0) {
            System.out.println("Application started with " + args.length + " arguments");
        }

        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }

        catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Establish database connection
        Connection con = establishDatabaseConnection();
        if (con == null) {
            System.out.println("Failed to connect to database after multiple attempts. Exiting.");
            return;
        }

        // Main menu loop
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        //Main Menu
        while (running) {
            displayMainMenu();
            System.out.print("Please, Choose a Report Option from the menu (1-6): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        countryReportsMenu(con, scanner);
                        break;
                    case 2:
                        cityReportsMenu(con, scanner);
                        break;
                    case 3:
                        capitalCityReportsMenu(con, scanner);
                        break;
                    case 4:
                        populationReportsMenu(con, scanner);
                        break;
                    case 5:
                        languageReportsMenu(con, scanner);
                        break;
                    case 6:
                        running = false;
                        System.out.println("Thank you for using the World Population Reporting System!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 to 6.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number between 1 to 6 .");
                scanner.nextLine(); // Clears the invalid input
            }
        }

        // Close resources
        try {
            if (con != null) con.close();
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }

    // COUNTRY USE CASE #1: View all Countries in the world by population
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

    // COUNTRY USE CASE #2: View all countries in a continent by population
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

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, continent);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

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
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // COUNTRY USE CASE #3: View all countries in a region by population
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

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, region);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

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
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    //COUNTRY  USE CASE #4: View the top N most populated countries in the world
    /**
     * Gets the top N most populated countries in the world
     * @param con Database connection
     * @param n The number of countries to return
     */
    public static void getTopNCountriesInWorld(Connection con, int n) {
        System.out.println("\n--- USE CASE #4: Top " + n + " Most Populated Countries in World ---");

        // Validate input
        if (n <= 0) {
            System.out.println("Invalid entry. Please enter a positive whole number.");
            return;
        }

        try {
            // Use prepared statement with LIMIT for top N
            String sql = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "ORDER BY Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, n);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

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
                System.out.println("Total countries displayed: " + count);
            }

            // Clean up
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // COUNTRY USE CASE #5: View the top N most populated countries in a continent
    /**
     * Gets the top N most populated countries in a specific continent
     * @param con Database connection
     * @param continent The continent name
     * @param n The number of countries to return
     */
    public static void getTopNCountriesInContinent(Connection con, String continent, int n) {
        System.out.println("\n--- USE CASE #5: Top " + n + " Most Populated Countries in " + continent + " ---");

        // Validate inputs
        if (continent == null || continent.trim().isEmpty()) {
            System.out.println("Invalid continent. Please check the spelling or try again.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid entry. Please enter a positive whole number.");
            return;
        }

        try {
            // Use prepared statement with continent filter and LIMIT
            String sql = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "WHERE Continent = ? " +
                    "ORDER BY Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, continent);
            pstmt.setInt(2, n);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

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
                System.out.println("Total countries displayed: " + count);
            }

            // Clean up
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // COUNTRY USE CASE #6: View the top N most populated countries in a region
    /**
     * Gets the top N most populated countries in a specific region
     * @param con Database connection
     * @param region The region name
     * @param n The number of countries to return
     */
    public static void getTopNCountriesInRegion(Connection con, String region, int n) {
        System.out.println("\n--- USE CASE #6: Top " + n + " Most Populated Countries in " + region + " ---");

        // Validate inputs
        if (region == null || region.trim().isEmpty()) {
            System.out.println("Invalid region. Please check the spelling or try again.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid entry. Please enter a positive whole number.");
            return;
        }

        try {
            // Use prepared statement with region filter and LIMIT
            String sql = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "WHERE Region = ? " +
                    "ORDER BY Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, region);
            pstmt.setInt(2, n);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

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
                System.out.println("Total countries displayed: " + count);
            }

            // Clean up
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #7: All Cities in World by population
    /**
     * Gets all cities in the world sorted by population (largest to smallest)
     * @param con Database connection
     */
    public static void getAllCitiesByPopulation(Connection con) {
        System.out.println("\n--- All Cities in World by Population ---");

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "ORDER BY city.Population DESC";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Print header
            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, continent, region, district, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No city data available.");
            } else {
                System.out.println("Total cities: " + count);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #8: Cities in Continent by population
    /**
     * Gets all cities in a specific continent sorted by population
     * @param con Database connection
     * @param continent The continent name
     */
    public static void getCitiesInContinentByPopulation(Connection con, String continent) {
        System.out.println("\n--- Cities in " + continent + " by Population ---");

        if (continent == null || continent.trim().isEmpty()) {
            System.out.println("Invalid continent. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Continent = ? " +
                    "ORDER BY city.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, continent);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String cont = rs.getString("Continent");
                String region = rs.getString("Region");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, cont, region, district, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No data available for this continent.");
            } else {
                System.out.println("Total cities in " + continent + ": " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #9: Cities in Region by population
    /**
     * Gets all cities in a specific region sorted by population
     * @param con Database connection
     * @param region The region name
     */
    public static void getCitiesInRegionByPopulation(Connection con, String region) {
        System.out.println("\n--- Cities in " + region + " by Population ---");

        if (region == null || region.trim().isEmpty()) {
            System.out.println("Invalid region. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region = ? " +
                    "ORDER BY city.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, region);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String reg = rs.getString("Region");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, continent, reg, district, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No data available for this region.");
            } else {
                System.out.println("Total cities in " + region + ": " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #10: Cities in Country by population
    /**
     * Gets all cities in a specific country sorted by population
     * @param con Database connection
     * @param country The country name
     */
    public static void getCitiesInCountryByPopulation(Connection con, String country) {
        System.out.println("\n--- Cities in " + country + " by Population ---");

        if (country == null || country.trim().isEmpty()) {
            System.out.println("Invalid country. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Name = ? " +
                    "ORDER BY city.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, country);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, continent, region, district, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No data available for this country.");
            } else {
                System.out.println("Total cities in " + country + ": " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #11: Cities in District by population
    /**
     * Gets all cities in a specific district sorted by population
     * @param con Database connection
     * @param district The district name
     */
    public static void getCitiesInDistrictByPopulation(Connection con, String district) {
        System.out.println("\n--- Cities in " + district + " District by Population ---");

        if (district == null || district.trim().isEmpty()) {
            System.out.println("Invalid district. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.District = ? " +
                    "ORDER BY city.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, district);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                String dist = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, continent, region, dist, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No data available for this district.");
            } else {
                System.out.println("Total cities in " + district + " district: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #12: Top N Cities in World
    /**
     * Gets the top N most populated cities in the world
     * @param con Database connection
     * @param n The number of cities to return
     */
    public static void getTopNCitiesInWorld(Connection con, int n) {
        System.out.println("\n--- Top " + n + " Most Populated Cities in World ---");

        if (n <= 0) {
            System.out.println("Invalid value. Please enter a positive whole number.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, n);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, continent, region, district, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No city data available.");
            } else {
                System.out.println("Total cities displayed: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #13: Top N Cities in Continent
    /**
     * Gets the top N most populated cities in a continent
     * @param con Database connection
     * @param continent The continent name
     * @param n The number of cities to return
     */
    public static void getTopNCitiesInContinent(Connection con, String continent, int n) {
        System.out.println("\n--- Top " + n + " Most Populated Cities in " + continent + " ---");

        if (continent == null || continent.trim().isEmpty()) {
            System.out.println("Invalid continent. Please check the spelling or try again.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid value. Please enter a positive whole number.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Continent = ? " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, continent);
            pstmt.setInt(2, n);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String cont = rs.getString("Continent");
                String region = rs.getString("Region");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, cont, region, district, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No data available for this continent.");
            } else {
                System.out.println("Total cities displayed: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #14: Top N Cities in Region
    /**
     * Gets the top N most populated cities in a region
     * @param con Database connection
     * @param region The region name
     * @param n The number of cities to return
     */
    public static void getTopNCitiesInRegion(Connection con, String region, int n) {
        System.out.println("\n--- Top " + n + " Most Populated Cities in " + region + " ---");

        if (region == null || region.trim().isEmpty()) {
            System.out.println("Invalid region. Please check the spelling or try again.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid value. Please enter a positive whole number.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region = ? " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, region);
            pstmt.setInt(2, n);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String reg = rs.getString("Region");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, continent, reg, district, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No data available for this region.");
            } else {
                System.out.println("Total cities displayed: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #15: Top N Cities in Country
    /**
     * Gets the top N most populated cities in a country
     * @param con Database connection
     * @param country The country name
     * @param n The number of cities to return
     */
    public static void getTopNCitiesInCountry(Connection con, String country, int n) {
        System.out.println("\n--- Top " + n + " Most Populated Cities in " + country + " ---");

        if (country == null || country.trim().isEmpty()) {
            System.out.println("Invalid country. Please check the spelling or try again.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid value. Please enter a positive whole number.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Name = ? " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, country);
            pstmt.setInt(2, n);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                String district = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, continent, region, district, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No data available for this country.");
            } else {
                System.out.println("Total cities displayed: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CITY USE CASE #16: Top N Cities in District
    /**
     * Gets the top N most populated cities in a district
     * @param con Database connection
     * @param district The district name
     * @param n The number of cities to return
     */
    public static void getTopNCitiesInDistrict(Connection con, String district, int n) {
        System.out.println("\n--- Top " + n + " Most Populated Cities in " + district + " District ---");

        if (district == null || district.trim().isEmpty()) {
            System.out.println("Invalid district. Please check the spelling or try again.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid value. Please enter a positive whole number.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.District = ? " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, district);
            pstmt.setInt(2, n);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City Name | Country | Continent | Region | District | Population");
            System.out.println("---------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                String dist = rs.getString("District");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %-15s | %,11d%n",
                        cityName, countryName, continent, region, dist, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No data available for this district.");
            } else {
                System.out.println("Total cities displayed: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CAPITAL CITY USE CASE #17: All Capital Cities in World
    /**
     * Gets all capital cities in the world sorted by population (largest to smallest)
     * @param con Database connection
     */
    public static void getAllCapitalCitiesByPopulation(Connection con) {
        System.out.println("\n--- All Capital Cities in World by Population ---");

        try {
            // Join country with city to get capital city details
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.Population " +
                    "FROM country " +
                    "JOIN city ON country.Capital = city.ID " +
                    "ORDER BY city.Population DESC";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Print header
            System.out.println("Capital City | Country | Continent | Region | Population");
            System.out.println("----------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %,11d%n",
                        cityName, countryName, continent, region, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No capital city data available.");
            } else {
                System.out.println("Total capital cities: " + count);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CAPITAL CITY USE CASE #18: Capital Cities in Continent
    /**
     * Gets all capital cities in a specific continent sorted by population
     * @param con Database connection
     * @param continent The continent name
     */
    public static void getCapitalCitiesInContinentByPopulation(Connection con, String continent) {
        System.out.println("\n--- Capital Cities in " + continent + " by Population ---");

        if (continent == null || continent.trim().isEmpty()) {
            System.out.println("Invalid continent. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.Population " +
                    "FROM country " +
                    "JOIN city ON country.Capital = city.ID " +
                    "WHERE country.Continent = ? " +
                    "ORDER BY city.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, continent);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Capital City | Country | Continent | Region | Population");
            System.out.println("----------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String cont = rs.getString("Continent");
                String region = rs.getString("Region");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %,11d%n",
                        cityName, countryName, cont, region, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No capital city data available for this continent.");
            } else {
                System.out.println("Total capital cities in " + continent + ": " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CAPITAL CITY USE CASE #19: Capital Cities in Region
    /**
     * Gets all capital cities in a specific region sorted by population
     * @param con Database connection
     * @param region The region name
     */
    public static void getCapitalCitiesInRegionByPopulation(Connection con, String region) {
        System.out.println("\n--- Capital Cities in " + region + " by Population ---");

        if (region == null || region.trim().isEmpty()) {
            System.out.println("Invalid region. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.Population " +
                    "FROM country " +
                    "JOIN city ON country.Capital = city.ID " +
                    "WHERE country.Region = ? " +
                    "ORDER BY city.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, region);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Capital City | Country | Continent | Region | Population");
            System.out.println("----------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String reg = rs.getString("Region");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %,11d%n",
                        cityName, countryName, continent, reg, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No capital city data available for this region.");
            } else {
                System.out.println("Total capital cities in " + region + ": " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CAPITAL CITY USE CASE #20: Top N Capital Cities in World
    /**
     * Gets the top N most populated capital cities in the world
     * @param con Database connection
     * @param n The number of capital cities to return
     */
    public static void getTopNCapitalCitiesInWorld(Connection con, int n) {
        System.out.println("\n--- Top " + n + " Most Populated Capital Cities in World ---");

        if (n <= 0) {
            System.out.println("Invalid value. Please enter a positive whole number.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.Population " +
                    "FROM country " +
                    "JOIN city ON country.Capital = city.ID " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, n);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Capital City | Country | Continent | Region | Population");
            System.out.println("----------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String region = rs.getString("Region");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %,11d%n",
                        cityName, countryName, continent, region, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No capital city data available.");
            } else {
                System.out.println("Total capital cities displayed: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CAPITAL CITY USE CASE #21: Top N Capital Cities in Continent
    /**
     * Gets the top N most populated capital cities in a continent
     * @param con Database connection
     * @param continent The continent name
     * @param n The number of capital cities to return
     */
    public static void getTopNCapitalCitiesInContinent(Connection con, String continent, int n) {
        System.out.println("\n--- Top " + n + " Most Populated Capital Cities in " + continent + " ---");

        if (continent == null || continent.trim().isEmpty()) {
            System.out.println("Invalid continent. Please check the spelling or try again.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid value. Please enter a positive whole number.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.Population " +
                    "FROM country " +
                    "JOIN city ON country.Capital = city.ID " +
                    "WHERE country.Continent = ? " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, continent);
            pstmt.setInt(2, n);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Capital City | Country | Continent | Region | Population");
            System.out.println("----------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String cont = rs.getString("Continent");
                String region = rs.getString("Region");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %,11d%n",
                        cityName, countryName, cont, region, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No capital city data available for this continent.");
            } else {
                System.out.println("Total capital cities displayed: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // CAPITAL CITY USE CASE #22: Top N Capital Cities in Region
    /**
     * Gets the top N most populated capital cities in a region
     * @param con Database connection
     * @param region The region name
     * @param n The number of capital cities to return
     */
    public static void getTopNCapitalCitiesInRegion(Connection con, String region, int n) {
        System.out.println("\n--- Top " + n + " Most Populated Capital Cities in " + region + " ---");

        if (region == null || region.trim().isEmpty()) {
            System.out.println("Invalid region. Please check the spelling or try again.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid value. Please enter a positive whole number.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as CountryName, " +
                    "country.Continent, country.Region, city.Population " +
                    "FROM country " +
                    "JOIN city ON country.Capital = city.ID " +
                    "WHERE country.Region = ? " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, region);
            pstmt.setInt(2, n);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Capital City | Country | Continent | Region | Population");
            System.out.println("----------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String cityName = rs.getString("CityName");
                String countryName = rs.getString("CountryName");
                String continent = rs.getString("Continent");
                String reg = rs.getString("Region");
                int population = rs.getInt("Population");

                System.out.printf("%-20s | %-20s | %-10s | %-15s | %,11d%n",
                        cityName, countryName, continent, reg, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No capital city data available for this region.");
            } else {
                System.out.println("Total capital cities displayed: " + count);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

// POPULATION USE CASE #23: Population Report by Continent
    /**
     * Gets population report for all continents (total, urban, non-urban populations and percentages)
     * @param con Database connection
     */
    public static void getPopulationReportByContinent(Connection con) {
        System.out.println("\n--- Population Report by Continent ---");

        try {
            // Calculate total population living in cities per continent
            String sql = "SELECT country.Continent, " +
                    "SUM(country.Population) as TotalPopulation, " +
                    "SUM(city.Population) as PopulationInCities, " +
                    "ROUND((SUM(city.Population) / SUM(country.Population)) * 100, 2) as PercentInCities, " +
                    "SUM(country.Population) - SUM(city.Population) as PopulationNotInCities, " +
                    "ROUND(((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100, 2) as PercentNotInCities " +
                    "FROM country " +
                    "LEFT JOIN city ON country.Code = city.CountryCode " +
                    "GROUP BY country.Continent " +
                    "ORDER BY TotalPopulation DESC";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Print header
            System.out.println("Continent | Total Population | In Cities | % in Cities | Not in Cities | % Not in Cities");
            System.out.println("---------------------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String continent = rs.getString("Continent");
                long totalPopulation = rs.getLong("TotalPopulation");
                long inCities = rs.getLong("PopulationInCities");
                double percentInCities = rs.getDouble("PercentInCities");
                long notInCities = rs.getLong("PopulationNotInCities");
                double percentNotInCities = rs.getDouble("PercentNotInCities");

                System.out.printf("%-10s | %,15d | %,10d | %11.2f%% | %,13d | %15.2f%%%n",
                        continent, totalPopulation, inCities, percentInCities,
                        notInCities, percentNotInCities);
                count++;
            }

            if (count == 0) {
                System.out.println("No population data available.");
            } else {
                System.out.println("Total continents: " + count);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // POPULATION USE CASE #24: Population Report by Region
    /**
     * Gets population report for a specific region (total, urban, non-urban populations and percentages)
     * @param con Database connection
     * @param region The region name
     */
    public static void getPopulationReportByRegion(Connection con, String region) {
        System.out.println("\n--- Population Report for " + region + " Region ---");

        if (region == null || region.trim().isEmpty()) {
            System.out.println("Invalid region. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT country.Region, " +
                    "SUM(country.Population) as TotalPopulation, " +
                    "SUM(city.Population) as PopulationInCities, " +
                    "ROUND((SUM(city.Population) / SUM(country.Population)) * 100, 2) as PercentInCities, " +
                    "SUM(country.Population) - SUM(city.Population) as PopulationNotInCities, " +
                    "ROUND(((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100, 2) as PercentNotInCities " +
                    "FROM country " +
                    "LEFT JOIN city ON country.Code = city.CountryCode " +
                    "WHERE country.Region = ? " +
                    "GROUP BY country.Region";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, region);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Region | Total Population | In Cities | % in Cities | Not in Cities | % Not in Cities");
            System.out.println("-----------------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String reg = rs.getString("Region");
                long totalPopulation = rs.getLong("TotalPopulation");
                long inCities = rs.getLong("PopulationInCities");
                double percentInCities = rs.getDouble("PercentInCities");
                long notInCities = rs.getLong("PopulationNotInCities");
                double percentNotInCities = rs.getDouble("PercentNotInCities");

                System.out.printf("%-15s | %,15d | %,10d | %11.2f%% | %,13d | %15.2f%%%n",
                        reg, totalPopulation, inCities, percentInCities,
                        notInCities, percentNotInCities);
                count++;
            }

            if (count == 0) {
                System.out.println("No population data available for this region.");
            } else {
                System.out.println("Report generated for region: " + region);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // POPULATION USE CASE #25: Population Report by Country
    /**
     * Gets population report for a specific country (total, urban, non-urban populations and percentages)
     * @param con Database connection
     * @param country The country name
     */
    public static void getPopulationReportByCountry(Connection con, String country) {
        System.out.println("\n--- Population Report for " + country + " ---");

        if (country == null || country.trim().isEmpty()) {
            System.out.println("Invalid country. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT country.Name, " +
                    "country.Population as TotalPopulation, " +
                    "SUM(city.Population) as PopulationInCities, " +
                    "ROUND((SUM(city.Population) / country.Population) * 100, 2) as PercentInCities, " +
                    "country.Population - SUM(city.Population) as PopulationNotInCities, " +
                    "ROUND(((country.Population - SUM(city.Population)) / country.Population) * 100, 2) as PercentNotInCities " +
                    "FROM country " +
                    "LEFT JOIN city ON country.Code = city.CountryCode " +
                    "WHERE country.Name = ? " +
                    "GROUP BY country.Name, country.Population";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, country);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Country | Total Population | In Cities | % in Cities | Not in Cities | % Not in Cities");
            System.out.println("-------------------------------------------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                String countryName = rs.getString("Name");
                long totalPopulation = rs.getLong("TotalPopulation");
                long inCities = rs.getLong("PopulationInCities");
                double percentInCities = rs.getDouble("PercentInCities");
                long notInCities = rs.getLong("PopulationNotInCities");
                double percentNotInCities = rs.getDouble("PercentNotInCities");

                System.out.printf("%-20s | %,15d | %,10d | %11.2f%% | %,13d | %15.2f%%%n",
                        countryName, totalPopulation, inCities, percentInCities,
                        notInCities, percentNotInCities);
                count++;
            }

            if (count == 0) {
                System.out.println("No population data available for this country.");
            } else {
                System.out.println("Report generated for country: " + country);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // POPULATION USE CASE #26: Overall World Population Summary
    /**
     * Gets the total world population
     * @param con Database connection
     */
    public static void getWorldPopulationSummary(Connection con) {
        System.out.println("\n--- World Population Summary ---");

        try {
            String sql = "SELECT 'World' as Description, SUM(Population) as TotalPopulation FROM country";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Description | Total Population");
            System.out.println("-------------------------------");

            if (rs.next()) {
                String description = rs.getString("Description");
                long totalPopulation = rs.getLong("TotalPopulation");

                System.out.printf("%-11s | %,15d%n", description, totalPopulation);
                System.out.println("World population: " + String.format("%,d", totalPopulation) + " people");
            } else {
                System.out.println("No world population data available.");
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // POPULATION USE CASE #27: Population Summary by Continent
    /**
     * Gets population summary for a specific continent
     * @param con Database connection
     * @param continent The continent name
     */
    public static void getPopulationSummaryByContinent(Connection con, String continent) {
        System.out.println("\n--- Population Summary for " + continent + " ---");

        if (continent == null || continent.trim().isEmpty()) {
            System.out.println("Invalid continent. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT Continent as Name, SUM(Population) as TotalPopulation " +
                    "FROM country " +
                    "WHERE Continent = ? " +
                    "GROUP BY Continent";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, continent);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Continent | Total Population");
            System.out.println("----------------------------");

            int count = 0;
            while (rs.next()) {
                String cont = rs.getString("Name");
                long totalPopulation = rs.getLong("TotalPopulation");

                System.out.printf("%-10s | %,15d%n", cont, totalPopulation);
                count++;
            }

            if (count == 0) {
                System.out.println("No population data available for this continent.");
            } else {
                System.out.println("Population summary for continent: " + continent);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // POPULATION USE CASE #28: Population Summary by Region
    /**
     * Gets population summary for a specific region
     * @param con Database connection
     * @param region The region name
     */
    public static void getPopulationSummaryByRegion(Connection con, String region) {
        System.out.println("\n--- Population Summary for " + region + " Region ---");

        if (region == null || region.trim().isEmpty()) {
            System.out.println("Invalid region. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT Region as Name, SUM(Population) as TotalPopulation " +
                    "FROM country " +
                    "WHERE Region = ? " +
                    "GROUP BY Region";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, region);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Region | Total Population");
            System.out.println("--------------------------");

            int count = 0;
            while (rs.next()) {
                String reg = rs.getString("Name");
                long totalPopulation = rs.getLong("TotalPopulation");

                System.out.printf("%-15s | %,15d%n", reg, totalPopulation);
                count++;
            }

            if (count == 0) {
                System.out.println("No population data available for this region.");
            } else {
                System.out.println("Population summary for region: " + region);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // POPULATION USE CASE #29: Population Summary by Country
    /**
     * Gets population summary for a specific country
     * @param con Database connection
     * @param country The country name
     */
    public static void getPopulationSummaryByCountry(Connection con, String country) {
        System.out.println("\n--- Population Summary for " + country + " ---");

        if (country == null || country.trim().isEmpty()) {
            System.out.println("Invalid country. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT Name, Population as TotalPopulation " +
                    "FROM country " +
                    "WHERE Name = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, country);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Country | Total Population");
            System.out.println("---------------------------");

            int count = 0;
            while (rs.next()) {
                String countryName = rs.getString("Name");
                long totalPopulation = rs.getLong("TotalPopulation");

                System.out.printf("%-20s | %,15d%n", countryName, totalPopulation);
                count++;
            }

            if (count == 0) {
                System.out.println("No population data available for this country.");
            } else {
                System.out.println("Population summary for country: " + country);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // POPULATION USE CASE #30: Population Summary by District
    /**
     * Gets population summary for a specific district
     * @param con Database connection
     * @param district The district name
     */
    public static void getPopulationSummaryByDistrict(Connection con, String district) {
        System.out.println("\n--- Population Summary for " + district + " District ---");

        if (district == null || district.trim().isEmpty()) {
            System.out.println("Invalid district. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT city.District as Name, country.Name as Country, SUM(city.Population) as TotalPopulation " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.District = ? " +
                    "GROUP BY city.District, country.Name";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, district);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("District | Country | Total Population");
            System.out.println("--------------------------------------");

            int count = 0;
            while (rs.next()) {
                String districtName = rs.getString("Name");
                String country = rs.getString("Country");
                long totalPopulation = rs.getLong("TotalPopulation");

                System.out.printf("%-15s | %-20s | %,15d%n", districtName, country, totalPopulation);
                count++;
            }

            if (count == 0) {
                System.out.println("No population data available for this district.");
            } else {
                System.out.println("Population summary for district: " + district);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // POPULATION USE CASE #31: Population Summary by City
    /**
     * Gets population summary for a specific city
     * @param con Database connection
     * @param cityName The city name
     */
    public static void getPopulationSummaryByCity(Connection con, String cityName) {
        System.out.println("\n--- Population Summary for " + cityName + " ---");

        if (cityName == null || cityName.trim().isEmpty()) {
            System.out.println("Invalid city name. Please check the spelling or try again.");
            return;
        }

        try {
            String sql = "SELECT city.Name as CityName, country.Name as Country, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.Name = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cityName);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("City | Country | Population");
            System.out.println("----------------------------");

            int count = 0;
            while (rs.next()) {
                String city = rs.getString("CityName");
                String country = rs.getString("Country");
                long population = rs.getLong("Population");

                System.out.printf("%-20s | %-20s | %,15d%n", city, country, population);
                count++;
            }

            if (count == 0) {
                System.out.println("No population data available for this city.");
            } else {
                System.out.println("Population summary for city: " + cityName);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // LANGUAGE USE CASE #32: Language Report
    /**
     * Gets language report showing total speakers and percentage of world population
     * @param con Database connection
     * @param languages Array of language names to report on
     */
    public static void getLanguageReport(Connection con, String[] languages) {
        System.out.println("\n--- Language Report ---");

        if (languages == null || languages.length == 0) {
            System.out.println("No languages specified for the report.");
            return;
        }

        try {
            // First, get total world population
            long worldPopulation = getWorldPopulation(con);
            if (worldPopulation == 0) {
                System.out.println("Unable to compute percentages: world population unavailable.");
                return;
            }

            System.out.println("World Population: " + String.format("%,d", worldPopulation));
            System.out.println("\nLanguage | Number of Speakers | % of World Population");
            System.out.println("------------------------------------------------------");

            // Process each language
            for (String language : languages) {
                if (language != null && !language.trim().isEmpty()) {
                    getLanguageSpeakers(con, language.trim(), worldPopulation);
                }
            }

            System.out.println("Note: Values rounded to two decimal places.");

        } catch (SQLException e) {
            System.out.println("Unable to retrieve language/population data. Please check database connection.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Gets the total world population
     * @param con Database connection
     * @return Total world population
     * @throws SQLException if database error occurs
     */
    private static long getWorldPopulation(Connection con) throws SQLException {
        String sql = "SELECT SUM(Population) as WorldPopulation FROM country";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        long worldPopulation = 0;
        if (rs.next()) {
            worldPopulation = rs.getLong("WorldPopulation");
        }

        rs.close();
        stmt.close();
        return worldPopulation;
    }

    /**
     * Gets the number of speakers for a specific language and calculates percentage of world population
     * @param con Database connection
     * @param language The language name
     * @param worldPopulation Total world population for percentage calculation
     * @throws SQLException if database error occurs
     */
    private static void getLanguageSpeakers(Connection con, String language, long worldPopulation) throws SQLException {
        // Calculate total speakers for this language
        // For each country, multiply country population by language percentage
        String sql = "SELECT SUM(country.Population * (cl.Percentage / 100)) as TotalSpeakers " +
                "FROM countrylanguage cl " +
                "JOIN country ON cl.CountryCode = country.Code " +
                "WHERE cl.Language = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, language);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            double totalSpeakers = rs.getDouble("TotalSpeakers");

            if (!rs.wasNull()) {
                // Calculate percentage of world population
                double percentage = (totalSpeakers / worldPopulation) * 100;

                System.out.printf("%-15s | %,17.0f | %21.2f%%%n",
                        language, totalSpeakers, percentage);
            } else {
                System.out.printf("%-15s | %17s | %21s%n",
                        language, "No data", "N/A");
                System.out.println("  Language data not available for: " + language);
            }
        } else {
            System.out.printf("%-15s | %17s | %21s%n",
                    language, "No data", "N/A");
            System.out.println("  Language data not available for: " + language);
        }

        rs.close();
        pstmt.close();
    }
}