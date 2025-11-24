package com.napier.app;

import java.sql.*;

public class ReportsApp

{
    public static void main(String[] args) throws Exception {
        try (Connection conn = Db.connect()) {
            Dao dao = new Dao(conn);

            int N = readTopN();

            System.out.println("=====================================================");
            System.out.println("                 POPULATION REPORTS");
            System.out.println("=====================================================");
            System.out.println("TOP_N = " + N);
            System.out.println();

            header("All countries in the world (largest -> smallest)");
            Printer.countries(dao.countriesWorld());

            for (String continent : dao.continents()) {
                header("All countries in continent: " + continent);
                Printer.countries(dao.countriesContinent(continent));
            }

            for (String region : dao.regions()) {
                header("All countries in region: " + region);
                Printer.countries(dao.countriesRegion(region));
            }

            header("Top " + N + " populated countries in the world");
            Printer.countries(dao.topCountriesWorld(N));

            for (String continent : dao.continents()) {
                header("Top " + N + " populated countries in continent: " + continent);
                Printer.countries(dao.topCountriesContinent(continent, N));
            }

            for (String region : dao.regions()) {
                header("Top " + N + " populated countries in region: " + region);
                Printer.countries(dao.topCountriesRegion(region, N));
            }

            header("All cities in the world (largest -> smallest)");
            Printer.cities(dao.citiesWorld());

            for (String continent : dao.continents()) {
                header("All cities in continent: " + continent);
                Printer.cities(dao.citiesContinent(continent));
            }

            for (String region : dao.regions()) {
                header("All cities in region: " + region);
                Printer.cities(dao.citiesRegion(region));
            }

            for (String country : dao.countryNames()) {
                header("All cities in country: " + country);
                Printer.cities(dao.citiesCountry(country));
            }

            header("Cities in districts (first " + N + " districts)");
            for (String district : dao.districts().stream().limit(N).toList()) {
                System.out.println("District: " + district);
                Printer.cities(dao.citiesDistrict(district));
            }

            header("Top " + N + " populated cities in the world");
            Printer.cities(dao.topCitiesWorld(N));

            for (String continent : dao.continents()) {
                header("Top " + N + " populated cities in continent: " + continent);
                Printer.cities(dao.topCitiesContinent(continent, N));
            }

            for (String region : dao.regions()) {
                header("Top " + N + " populated cities in region: " + region);
                Printer.cities(dao.topCitiesRegion(region, N));
            }

            for (String country : dao.countryNames()) {
                header("Top " + N + " populated cities in country: " + country);
                Printer.cities(dao.topCitiesCountry(country, N));
            }

            header("All capital cities in the world (largest -> smallest)");
            Printer.capitals(dao.capitalsWorld());

            for (String continent : dao.continents()) {
                header("All capital cities in continent: " + continent);
                Printer.capitals(dao.capitalsContinent(continent));
            }

            for (String region : dao.regions()) {
                header("All capital cities in region: " + region);
                Printer.capitals(dao.capitalsRegion(region));
            }

            header("Top " + N + " populated capital cities in the world");
            Printer.capitals(dao.topCapitalsWorld(N));

            for (String continent : dao.continents()) {
                header("Top " + N + " populated capital cities in continent: " + continent);
                Printer.capitals(dao.topCapitalsContinent(continent, N));
            }

            for (String region : dao.regions()) {
                header("Top " + N + " populated capital cities in region: " + region);
                Printer.capitals(dao.topCapitalsRegion(region, N));
            }

            header("Population totals");
            System.out.printf("World population: %,d%n%n", dao.worldPopulation());

            for (String continent : dao.continents()) {
                System.out.printf("Continent %-20s : %,d%n", continent, dao.continentPopulation(continent));
            }
            System.out.println();

            for (String region : dao.regions()) {
                System.out.printf("Region %-30s : %,d%n", region, dao.regionPopulation(region));
            }

            header("Population report by continent (city vs non-city)");
            Printer.popReports(dao.populationByContinent());

            header("Population report by region (city vs non-city)");
            Printer.popReports(dao.populationByRegion());

            header("Population report by country (city vs non-city)");
            Printer.popReports(dao.populationByCountry());

            header("Language report (Chinese, English, Hindi, Spanish, Arabic)");
            Printer.languages(dao.languageReport());

            System.out.println();
            System.out.println("=====================================================");
            System.out.println("All required reports generated. Exiting.");
            System.out.println("=====================================================");
        }
    }

    private static void header(String title) {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println(title);
        System.out.println("-----------------------------------------------------");
    }

    private static int readTopN() {
        try {
            String env = System.getenv("TOP_N");
            if (env != null && !env.isBlank()) return Integer.parseInt(env.trim());
        } catch (Exception ignored) {}
        return 10;
    }
}
