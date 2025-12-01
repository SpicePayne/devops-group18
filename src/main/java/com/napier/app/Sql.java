package com.napier.app;

public class Sql {
    public record Country(String code, String name, String continent, String region, long population, String capital) {}
    public record City(String name, String country, String district, long population) {}
    public record CapitalCity(String name, String country, long population) {}
    public record PopulationReport(String name, long total, long cityPop, double cityPct, long nonCityPop, double nonCityPct) {}
    public record LanguageReport(String language, long speakers, double worldPct) {}
}
