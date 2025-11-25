package com.napier.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection utility.
 *
 * <p>Builds a MySQL JDBC connection using environment variables
 * and provides a retrying connect method for Docker startup.</p>
 */
public  class Db {

    // Prevent instantiation (utility class)
    private Db() {}

    /**
     * Creates a single JDBC connection to MySQL.
     *
     * @return open JDBC connection
     * @throws SQLException if connection fails
     * @throws ClassNotFoundException if MySQL driver is missing
     */
    public static Connection connect() throws SQLException, ClassNotFoundException {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        String host = env("DB_HOST", "db");
        String port = env("DB_PORT", "3306");
        String name = env("DB_NAME", "world");
        String user = env("DB_USER", "root");
        String pass = env("DB_PASS", "password");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + name +
                "?useSSL=false&allowPublicKeyRetrieval=true";

        return DriverManager.getConnection(url, user, pass);
    }

    /**
     * Attempts to connect multiple times before giving up.
     *
     * <p>Used to handle Docker Compose where MySQL might not be ready
     * the moment the app container starts.</p>
     *
     * @return open JDBC connection
     * @throws Exception if retries are exhausted
     */
    public static Connection connectWithRetry() throws Exception {
        int retries = Integer.parseInt(env("DB_RETRIES", "100"));
        int delayMs = Integer.parseInt(env("DB_RETRY_DELAY_MS", "1000"));

        SQLException last = null;

        for (int attempt = 1; attempt <= retries; attempt++) {
            try {
                System.out.println("Connecting to database (attempt " + attempt + ")...");
                return connect();
            } catch (SQLException e) {
                last = e;
                System.out.println("Connection failed: " + e.getMessage());
                Thread.sleep(delayMs);
            }
        }

        // If we get here, all retries failed
        throw new SQLException("Could not connect after " + retries + " attempts.", last);
    }

    /**
     * Reads an environment variable or returns a default.
     *
     * @param key environment variable name
     * @param def default value if missing/blank
     * @return environment value or default
     */
    private static String env(String key, String def) {
        String val = System.getenv(key);
        return (val == null || val.isBlank()) ? def : val.trim();
    }
}
