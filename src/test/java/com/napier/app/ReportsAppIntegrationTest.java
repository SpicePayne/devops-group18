package com.napier.app;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Testcontainers
class ReportsAppIntegrationTest {

    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:latest")
            .withDatabaseName("world")
            .withUsername("root")
            .withPassword("password");

    private static Connection conn;

    @BeforeAll
    static void setup() throws Exception {
        mysql.start();
        conn = DriverManager.getConnection(mysql.getJdbcUrl(), mysql.getUsername(), mysql.getPassword());

        conn.createStatement().execute("""
            CREATE TABLE country (Code CHAR(3) PRIMARY KEY, Name VARCHAR(50),
              Continent VARCHAR(50), Region VARCHAR(50),
              Population INT, Capital INT);
            CREATE TABLE city (ID INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(50),
              CountryCode CHAR(3), District VARCHAR(50), Population INT);
            INSERT INTO country VALUES ('AAA','Aland','Europe','Test',1000,NULL);
        """);
    }

    @AfterAll
    static void tearDown() throws Exception {
        conn.close();
        mysql.stop();
    }

    @Test
    void countriesWorld_returnsData() throws Exception {
        Dao dao = new Dao(conn);
        assertFalse(dao.countriesWorld().isEmpty());
    }
}
