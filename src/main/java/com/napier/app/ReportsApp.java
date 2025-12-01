package com.napier.app;

import com.napier.app.Sql.*;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class ReportsApp {

    public static void main(String[] args) throws Exception {
        try (Connection conn = Db.connectWithRetry();
             Scanner scanner = new Scanner(System.in)) {

            Dao dao = new Dao(conn);

            boolean running = true;
            while (running) {
                printMenu();

                String input = scanner.nextLine().trim();

                switch (input) {

                    // -------------------------
                    // COUNTRY REPORTS
                    // -------------------------
                    case "1" -> reportCountriesWorld(dao);
                    case "2" -> reportCountriesByContinent(scanner, dao);
                    case "3" -> reportCountriesByRegion(scanner, dao);
                    case "4" -> reportTopCountriesWorld(scanner, dao);
                    case "5" -> reportTopCountriesContinent(scanner, dao);
                    case "6" -> reportTopCountriesRegion(scanner, dao);

                    // -------------------------
                    // CITY REPORTS
                    // -------------------------
                    case "7" -> reportCitiesWorld(dao);
                    case "8" -> reportCitiesByContinent(scanner, dao);
                    case "9" -> reportCitiesByRegion(scanner, dao);
                    case "10" -> reportCitiesByCountry(scanner, dao);
                    case "11" -> reportCitiesByDistrict(scanner, dao);
                    case "12" -> reportTopCitiesWorld(scanner, dao);
                    case "13" -> reportTopCitiesContinent(scanner, dao);
                    case "14" -> reportTopCitiesRegion(scanner, dao);
                    case "15" -> reportTopCitiesCountry(scanner, dao);
                    case "16" -> reportTopCitiesDistrict(scanner, dao);

                    // -------------------------
                    // CAPITAL CITY REPORTS
                    // -------------------------
                    case "17" -> reportCapitalsWorld(dao);
                    case "18" -> reportCapitalsByContinent(scanner, dao);
                    case "19" -> reportCapitalsByRegion(scanner, dao);
                    case "20" -> reportTopCapitalsWorld(scanner, dao);
                    case "21" -> reportTopCapitalsContinent(scanner, dao);
                    case "22" -> reportTopCapitalsRegion(scanner, dao);

                    // -------------------------
                    // POPULATION REPORTS
                    // -------------------------
                    case "23" -> reportPopulationByContinent(dao);
                    case "24" -> reportPopulationByRegion(dao);
                    case "25" -> reportPopulationByCountry(dao);

                    // -------------------------
                    // POPULATION LOOKUPS
                    // -------------------------
                    case "26" -> System.out.printf("World population: %,d%n", dao.worldPopulation());
                    case "27" -> lookupContinentPopulation(scanner, dao);
                    case "28" -> lookupRegionPopulation(scanner, dao);
                    case "29" -> lookupCountryPopulation(scanner, dao);
                    case "30" -> lookupDistrictPopulation(scanner, dao);
                    case "31" -> lookupCityPopulation(scanner, dao);

                    // -------------------------
                    // LANGUAGE REPORT
                    // -------------------------
                    case "32" -> reportLanguages(dao);

                    // -------------------------
                    // EXIT
                    // -------------------------
                    case "Q", "q" -> {
                        running = false;
                        System.out.println("Bye!");
                    }

                    default -> System.out.println("Invalid option. Try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }

    // =========================================================
    // INPUT HELPERS
    // =========================================================

    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(s);
                if (n > 0) return n;
            } catch (Exception ignored) {}
            System.out.println("Please enter a positive integer.");
        }
    }

    private static String readChoice(Scanner sc, String label, List<String> list) {
        while (true) {
            System.out.println(label + " options:");
            for (int i = 0; i < list.size(); i++)
                System.out.printf("  %d) %s%n", i + 1, list.get(i));

            int n = readPositiveInt(sc, "Select " + label + ": ");
            if (n >= 1 && n <= list.size()) return list.get(n - 1);

            System.out.println("Invalid selection.");
        }
    }

    // =========================================================
    // MENU
    // =========================================================

    private static void printMenu() {
        System.out.println();
        System.out.println("=====================================================");
        System.out.println(" POPULATION REPORTS MENU");
        System.out.println("=====================================================");
        System.out.println("Countries:");
        System.out.println("  1) All countries in world");
        System.out.println("  2) All countries in a continent");
        System.out.println("  3) All countries in a region");
        System.out.println("  4) Top N countries in world");
        System.out.println("  5) Top N countries in a continent");
        System.out.println("  6) Top N countries in a region");
        System.out.println();
        System.out.println("Cities:");
        System.out.println("  7) All cities in world");
        System.out.println("  8) All cities in a continent");
        System.out.println("  9) All cities in a region");
        System.out.println(" 10) All cities in a country");
        System.out.println(" 11) All cities in a district");
        System.out.println(" 12) Top N cities in world");
        System.out.println(" 13) Top N cities in a continent");
        System.out.println(" 14) Top N cities in a region");
        System.out.println(" 15) Top N cities in a country");
        System.out.println(" 16) Top N cities in a district");
        System.out.println();
        System.out.println("Capitals:");
        System.out.println(" 17) All capitals in world");
        System.out.println(" 18) All capitals in a continent");
        System.out.println(" 19) All capitals in a region");
        System.out.println(" 20) Top N capitals in world");
        System.out.println(" 21) Top N capitals in continent");
        System.out.println(" 22) Top N capitals in region");
        System.out.println();
        System.out.println("Population Reports:");
        System.out.println(" 23) Population by continent");
        System.out.println(" 24) Population by region");
        System.out.println(" 25) Population by country");
        System.out.println();
        System.out.println("Population Lookups:");
        System.out.println(" 26) World population");
        System.out.println(" 27) Population of a continent");
        System.out.println(" 28) Population of a region");
        System.out.println(" 29) Population of a country");
        System.out.println(" 30) Population of a district");
        System.out.println(" 31) Population of a city");
        System.out.println();
        System.out.println("Languages:");
        System.out.println(" 32) Language population report");
        System.out.println();
        System.out.println(" Q) Quit");
        System.out.print("Choose an option: ");
    }

    // =========================================================
    // REPORT IMPLEMENTATIONS (each one fully SPEC compliant)
    // =========================================================

    private static void reportCountriesWorld(Dao dao) throws Exception {
        Printer.countries(dao.countriesWorld());
    }

    private static void reportCountriesByContinent(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Continent", dao.continents());
        Printer.countries(dao.countriesContinent(c));
    }

    private static void reportCountriesByRegion(Scanner sc, Dao dao) throws Exception {
        String r = readChoice(sc, "Region", dao.regions());
        Printer.countries(dao.countriesRegion(r));
    }

    private static void reportTopCountriesWorld(Scanner sc, Dao dao) throws Exception {
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.countries(dao.topCountriesWorld(n));
    }

    private static void reportTopCountriesContinent(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Continent", dao.continents());
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.countries(dao.topCountriesContinent(c, n));
    }

    private static void reportTopCountriesRegion(Scanner sc, Dao dao) throws Exception {
        String r = readChoice(sc, "Region", dao.regions());
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.countries(dao.topCountriesRegion(r, n));
    }

    // -------------------------
    // CITIES
    // -------------------------

    private static void reportCitiesWorld(Dao dao) throws Exception {
        Printer.cities(dao.citiesWorld());
    }

    private static void reportCitiesByContinent(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Continent", dao.continents());
        Printer.cities(dao.citiesContinent(c));
    }

    private static void reportCitiesByRegion(Scanner sc, Dao dao) throws Exception {
        String r = readChoice(sc, "Region", dao.regions());
        Printer.cities(dao.citiesRegion(r));
    }

    private static void reportCitiesByCountry(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Country", dao.countryNames());
        Printer.cities(dao.citiesCountry(c));
    }

    private static void reportCitiesByDistrict(Scanner sc, Dao dao) throws Exception {
        String d = readChoice(sc, "District", dao.districts());
        Printer.cities(dao.citiesDistrict(d));
    }

    private static void reportTopCitiesWorld(Scanner sc, Dao dao) throws Exception {
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.cities(dao.topCitiesWorld(n));
    }

    private static void reportTopCitiesContinent(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Continent", dao.continents());
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.cities(dao.topCitiesContinent(c, n));
    }

    private static void reportTopCitiesRegion(Scanner sc, Dao dao) throws Exception {
        String r = readChoice(sc, "Region", dao.regions());
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.cities(dao.topCitiesRegion(r, n));
    }

    private static void reportTopCitiesCountry(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Country", dao.countryNames());
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.cities(dao.topCitiesCountry(c, n));
    }

    private static void reportTopCitiesDistrict(Scanner sc, Dao dao) throws Exception {
        String d = readChoice(sc, "District", dao.districts());
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.cities(dao.topCitiesDistrict(d, n));
    }

    // -------------------------
    // CAPITAL CITIES
    // -------------------------

    private static void reportCapitalsWorld(Dao dao) throws Exception {
        Printer.capitals(dao.capitalsWorld());
    }

    private static void reportCapitalsByContinent(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Continent", dao.continents());
        Printer.capitals(dao.capitalsContinent(c));
    }

    private static void reportCapitalsByRegion(Scanner sc, Dao dao) throws Exception {
        String r = readChoice(sc, "Region", dao.regions());
        Printer.capitals(dao.capitalsRegion(r));
    }

    private static void reportTopCapitalsWorld(Scanner sc, Dao dao) throws Exception {
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.capitals(dao.topCapitalsWorld(n));
    }

    private static void reportTopCapitalsContinent(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Continent", dao.continents());
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.capitals(dao.topCapitalsContinent(c, n));
    }

    private static void reportTopCapitalsRegion(Scanner sc, Dao dao) throws Exception {
        String r = readChoice(sc, "Region", dao.regions());
        int n = readPositiveInt(sc, "Enter N: ");
        Printer.capitals(dao.topCapitalsRegion(r, n));
    }

    // -------------------------
    // POPULATION REPORTS
    // -------------------------

    private static void reportPopulationByContinent(Dao dao) throws Exception {
        Printer.popReports(dao.populationByContinent());
    }

    private static void reportPopulationByRegion(Dao dao) throws Exception {
        Printer.popReports(dao.populationByRegion());
    }

    private static void reportPopulationByCountry(Dao dao) throws Exception {
        Printer.popReports(dao.populationByCountry());
    }

    // -------------------------
    // POPULATION LOOKUPS
    // -------------------------

    private static void lookupContinentPopulation(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Continent", dao.continents());
        System.out.printf("%s population: %,d%n", c, dao.continentPopulation(c));
    }

    private static void lookupRegionPopulation(Scanner sc, Dao dao) throws Exception {
        String r = readChoice(sc, "Region", dao.regions());
        System.out.printf("%s population: %,d%n", r, dao.regionPopulation(r));
    }

    private static void lookupCountryPopulation(Scanner sc, Dao dao) throws Exception {
        String c = readChoice(sc, "Country", dao.countryNames());
        System.out.printf("%s population: %,d%n", c, dao.countryPopulation(c));
    }

    private static void lookupDistrictPopulation(Scanner sc, Dao dao) throws Exception {
        String d = readChoice(sc, "District", dao.districts());
        System.out.printf("%s population: %,d%n", d, dao.districtPopulation(d));
    }

    private static void lookupCityPopulation(Scanner sc, Dao dao) throws Exception {
        System.out.print("Enter city name: ");
        String city = sc.nextLine().trim();
        System.out.printf("%s population: %,d%n", city, dao.cityPopulation(city));
    }

    // -------------------------
    // LANGUAGE REPORT
    // -------------------------

    private static void reportLanguages(Dao dao) throws Exception {
        Printer.languages(dao.languageReport());
    }
}
