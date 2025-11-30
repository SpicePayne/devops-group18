package com.napier.app;

import com.napier.app.Sql.*;

import java.sql.*;
import java.util.*;

public class Dao {
    private final Connection conn;
    public Dao(Connection conn) { this.conn = conn; }

    public List<String> continents() throws Exception {
        return distinctList("SELECT DISTINCT Continent FROM country ORDER BY Continent");
    }

    public List<String> regions() throws Exception {
        return distinctList("SELECT DISTINCT Region FROM country ORDER BY Region");
    }

    public List<String> countryNames() throws Exception {
        return distinctList("SELECT Name FROM country ORDER BY Name");
    }

    public List<String> districts() throws Exception {
        return distinctList("SELECT DISTINCT District FROM city ORDER BY District");
    }

    private List<String> distinctList(String sql, Object... args) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, args);
            try (ResultSet rs = ps.executeQuery()) {
                List<String> out = new ArrayList<>();
                while (rs.next()) out.add(rs.getString(1));
                return out;
            }
        }
    }

    // ----- Countries -----
    public List<Country> countriesWorld() throws Exception {
        return countriesQuery("""
            SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, city.Name AS Capital
            FROM country c LEFT JOIN city ON c.Capital = city.ID
            ORDER BY c.Population DESC
        """);
    }

    public List<Country> countriesContinent(String continent) throws Exception {
        return countriesQuery("""
            SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, city.Name AS Capital
            FROM country c LEFT JOIN city ON c.Capital = city.ID
            WHERE c.Continent=? ORDER BY c.Population DESC
        """, continent);
    }

    public List<Country> countriesRegion(String region) throws Exception {
        return countriesQuery("""
            SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, city.Name AS Capital
            FROM country c LEFT JOIN city ON c.Capital = city.ID
            WHERE c.Region=? ORDER BY c.Population DESC
        """, region);
    }

    public List<Country> topCountriesWorld(int n) throws Exception {
        return countriesQuery("""
            SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, city.Name AS Capital
            FROM country c LEFT JOIN city ON c.Capital = city.ID
            ORDER BY c.Population DESC LIMIT ?
        """, n);
    }

    public List<Country> topCountriesContinent(String continent, int n) throws Exception {
        return countriesQuery("""
            SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, city.Name AS Capital
            FROM country c LEFT JOIN city ON c.Capital = city.ID
            WHERE c.Continent=? ORDER BY c.Population DESC LIMIT ?
        """, continent, n);
    }

    public List<Country> topCountriesRegion(String region, int n) throws Exception {
        return countriesQuery("""
            SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, city.Name AS Capital
            FROM country c LEFT JOIN city ON c.Capital = city.ID
            WHERE c.Region=? ORDER BY c.Population DESC LIMIT ?
        """, region, n);
    }

    // ----- Cities -----
    public List<City> citiesWorld() throws Exception {
        return citiesQuery("""
            SELECT city.Name, country.Name AS Country, city.District, city.Population
            FROM city JOIN country ON city.CountryCode=country.Code
            ORDER BY city.Population DESC
        """);
    }

    public List<City> citiesContinent(String continent) throws Exception {
        return citiesQuery("""
            SELECT city.Name, country.Name AS Country, city.District, city.Population
            FROM city JOIN country ON city.CountryCode=country.Code
            WHERE country.Continent=? ORDER BY city.Population DESC
        """, continent);
    }

    public List<City> citiesRegion(String region) throws Exception {
        return citiesQuery("""
            SELECT city.Name, country.Name AS Country, city.District, city.Population
            FROM city JOIN country ON city.CountryCode=country.Code
            WHERE country.Region=? ORDER BY city.Population DESC
        """, region);
    }

    public List<City> citiesCountry(String country) throws Exception {
        return citiesQuery("""
            SELECT city.Name, country.Name AS Country, city.District, city.Population
            FROM city JOIN country ON city.CountryCode=country.Code
            WHERE country.Name=? ORDER BY city.Population DESC
        """, country);
    }

    public List<City> citiesDistrict(String district) throws Exception {
        return citiesQuery("""
            SELECT city.Name, country.Name AS Country, city.District, city.Population
            FROM city JOIN country ON city.CountryCode=country.Code
            WHERE city.District=? ORDER BY city.Population DESC
        """, district);
    }

    public List<City> topCitiesWorld(int n) throws Exception { return citiesQuery(baseCities()+" LIMIT ?", n); }
    public List<City> topCitiesContinent(String c, int n) throws Exception { return citiesQuery(baseCities()+" WHERE country.Continent=? LIMIT ?", c, n); }
    public List<City> topCitiesRegion(String r, int n) throws Exception { return citiesQuery(baseCities()+" WHERE country.Region=? LIMIT ?", r, n); }
    public List<City> topCitiesCountry(String c, int n) throws Exception { return citiesQuery(baseCities()+" WHERE country.Name=? LIMIT ?", c, n); }
    public List<City> topCitiesDistrict(String d, int n) throws Exception { return citiesQuery(baseCities()+" WHERE city.District=? LIMIT ?", d, n); }

    private String baseCities() {
        return """
            SELECT city.Name, country.Name AS Country, city.District, city.Population
            FROM city JOIN country ON city.CountryCode=country.Code
            ORDER BY city.Population DESC
        """;
    }

    // ----- Capitals -----
    public List<CapitalCity> capitalsWorld() throws Exception {
        return capitalsQuery("""
            SELECT city.Name, country.Name AS Country, city.Population
            FROM country JOIN city ON country.Capital=city.ID
            ORDER BY city.Population DESC
        """);
    }

    public List<CapitalCity> capitalsContinent(String continent) throws Exception {
        return capitalsQuery("""
            SELECT city.Name, country.Name AS Country, city.Population
            FROM country JOIN city ON country.Capital=city.ID
            WHERE country.Continent=? ORDER BY city.Population DESC
        """, continent);
    }

    public List<CapitalCity> capitalsRegion(String region) throws Exception {
        return capitalsQuery("""
            SELECT city.Name, country.Name AS Country, city.Population
            FROM country JOIN city ON country.Capital=city.ID
            WHERE country.Region=? ORDER BY city.Population DESC
        """, region);
    }

    public List<CapitalCity> topCapitalsWorld(int n) throws Exception {
        return capitalsQuery("""
            SELECT city.Name, country.Name AS Country, city.Population
            FROM country JOIN city ON country.Capital=city.ID
            ORDER BY city.Population DESC LIMIT ?
        """, n);
    }

    public List<CapitalCity> topCapitalsContinent(String c, int n) throws Exception {
        return capitalsQuery("""
            SELECT city.Name, country.Name AS Country, city.Population
            FROM country JOIN city ON country.Capital=city.ID
            WHERE country.Continent=? ORDER BY city.Population DESC LIMIT ?
        """, c, n);
    }

    public List<CapitalCity> topCapitalsRegion(String r, int n) throws Exception {
        return capitalsQuery("""
            SELECT city.Name, country.Name AS Country, city.Population
            FROM country JOIN city ON country.Capital=city.ID
            WHERE country.Region=? ORDER BY city.Population DESC LIMIT ?
        """, r, n);
    }

    // ----- Population totals -----
    public long worldPopulation() throws Exception { return scalar("SELECT SUM(Population) FROM country"); }
    public long continentPopulation(String c) throws Exception { return scalar("SELECT SUM(Population) FROM country WHERE Continent=?", c); }
    public long regionPopulation(String r) throws Exception { return scalar("SELECT SUM(Population) FROM country WHERE Region=?", r); }
    public long countryPopulation(String c) throws Exception { return scalar("SELECT Population FROM country WHERE Name=?", c); }
    public long districtPopulation(String d) throws Exception { return scalar("SELECT SUM(Population) FROM city WHERE District=?", d); }
    public long cityPopulation(String c) throws Exception { return scalar("SELECT Population FROM city WHERE Name=? LIMIT 1", c); }

    // ----- City vs Non-City reports -----
    public List<PopulationReport> populationByContinent() throws Exception {
        return popReport("""
            SELECT c.Continent AS Name, SUM(c.Population) AS TotalPop, SUM(city.Population) AS CityPop
            FROM country c LEFT JOIN city ON city.CountryCode=c.Code
            GROUP BY c.Continent
        """);
    }

    public List<PopulationReport> populationByRegion() throws Exception {
        return popReport("""
            SELECT c.Region AS Name, SUM(c.Population) AS TotalPop, SUM(city.Population) AS CityPop
            FROM country c LEFT JOIN city ON city.CountryCode=c.Code
            GROUP BY c.Region
        """);
    }

    public List<PopulationReport> populationByCountry() throws Exception {
        return popReport("""
            SELECT c.Name AS Name, c.Population AS TotalPop, SUM(city.Population) AS CityPop
            FROM country c LEFT JOIN city ON city.CountryCode=c.Code
            GROUP BY c.Name, c.Population
        """);
    }

    // ----- Languages -----
    public List<LanguageReport> languageReport() throws Exception {
        String sql = """
            SELECT cl.Language,
                   SUM(c.Population*cl.Percentage/100) AS Speakers,
                   (SUM(c.Population*cl.Percentage/100)/(SELECT SUM(Population) FROM country))*100 AS WorldPct
            FROM countrylanguage cl JOIN country c ON cl.CountryCode=c.Code
            WHERE cl.Language IN ('Chinese','English','Hindi','Spanish','Arabic')
            GROUP BY cl.Language
            ORDER BY Speakers DESC
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<LanguageReport> out = new ArrayList<>();
            while (rs.next()) {
                out.add(new LanguageReport(
                        rs.getString("Language"),
                        rs.getLong("Speakers"),
                        rs.getDouble("WorldPct")
                ));
            }
            return out;
        }
    }

    // ===== helpers =====
    private long scalar(String sql, Object... args) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, args);
            try (ResultSet rs = ps.executeQuery()) { rs.next(); return rs.getLong(1); }
        }
    }

    private List<Country> countriesQuery(String sql, Object... args) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, args);
            try (ResultSet rs = ps.executeQuery()) {
                List<Country> out = new ArrayList<>();
                while (rs.next()) {
                    out.add(new Country(
                            rs.getString("Code"),
                            rs.getString("Name"),
                            rs.getString("Continent"),
                            rs.getString("Region"),
                            rs.getLong("Population"),
                            rs.getString("Capital")));
                }
                return out;
            }
        }
    }

    private List<City> citiesQuery(String sql, Object... args) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, args);
            try (ResultSet rs = ps.executeQuery()) {
                List<City> out = new ArrayList<>();
                while (rs.next()) {
                    out.add(new City(
                            rs.getString("Name"),
                            rs.getString("Country"),
                            rs.getString("District"),
                            rs.getLong("Population")));
                }
                return out;
            }
        }
    }

    private List<CapitalCity> capitalsQuery(String sql, Object... args) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, args);
            try (ResultSet rs = ps.executeQuery()) {
                List<CapitalCity> out = new ArrayList<>();
                while (rs.next()) {
                    out.add(new CapitalCity(
                            rs.getString("Name"),
                            rs.getString("Country"),
                            rs.getLong("Population")));
                }
                return out;
            }
        }
    }

    private List<PopulationReport> popReport(String sql) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<PopulationReport> out = new ArrayList<>();
            while (rs.next()) {
                long total = rs.getLong("TotalPop");
                long city = rs.getLong("CityPop");
                long nonCity = total - city;
                double cityPct = total == 0 ? 0 : city * 100.0 / total;
                double nonPct = total == 0 ? 0 : nonCity * 100.0 / total;
                out.add(new PopulationReport(
                        rs.getString("Name"), total, city, cityPct, nonCity, nonPct));
            }
            return out;
        }
    }

    private void bind(PreparedStatement ps, Object... args) throws Exception {
        for (int i=0;i<args.length;i++) ps.setObject(i+1, args[i]);
    }
}
