package com.napier.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {

    public static Connection connect() throws Exception {

        String host = env("DB_HOST", "db");
        String port = env("DB_PORT", "3306");
        String name = env("DB_NAME", "world");
        String user = env("DB_USER", "root");
        String pass = env("DB_PASS", "password");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + name +
                "?useSSL=false&allowPublicKeyRetrieval=true";


        return DriverManager.getConnection(url, user, pass);
    }

    private static String env(String k, String d) {
        String v = System.getenv(k);
        return (v == null || v.isBlank()) ? d : v;
    }
}
