package com.napier.app;

import com.napier.app.Sql.*;

import java.util.List;

public class Printer {
    public static void countries(List<Country> list) {
        System.out.printf("%-5s %-35s %-12s %-25s %12s %-25s%n",
                "Code","Name","Continent","Region","Population","Capital");
        for (Country c: list)
            System.out.printf("%-5s %-35s %-12s %-25s %,12d %-25s%n",
                    c.code(), c.name(), c.continent(), c.region(), c.population(), c.capital());
    }

    public static void cities(List<City> list) {
        System.out.printf("%-30s %-30s %-20s %12s%n",
                "Name", "Country", "District", "Population");
        for (City c: list)
            System.out.printf("%-30s %-30s %-20s %,12d%n",
                    c.name(), c.country(), c.district(), c.population());
    }

    public static void capitals(List<CapitalCity> list) {
        System.out.printf("%-30s %-30s %12s%n", "Capital", "Country", "Population");
        for (CapitalCity c: list)
            System.out.printf("%-30s %-30s %,12d%n",
                    c.name(), c.country(), c.population());
    }

    public static void popReports(List<PopulationReport> list) {
        System.out.printf("%-25s %15s %15s %8s %15s %8s%n",
                "Name","Total","CityPop","%City","NonCity","%Non");
        for (PopulationReport r: list)
            System.out.printf("%-25s %,15d %,15d %7.2f %,15d %7.2f%n",
                    r.name(), r.total(), r.cityPop(), r.cityPct(), r.nonCityPop(), r.nonCityPct());
    }

    public static void languages(List<LanguageReport> list) {
        System.out.printf("%-10s %15s %10s%n", "Language", "Speakers", "%World");
        for (LanguageReport r : list)
            System.out.printf("%-10s %,15d %9.2f%n",
                    r.language(), r.speakers(), r.worldPct());
    }
}