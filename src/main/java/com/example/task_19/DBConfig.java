package com.example.task_19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;
    private static final String ENV_PATH = ".env"; // change
    public static Connection connection;

    public static void init() {
        try {
            env_load();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void env_load() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(ENV_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("=");
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "DB_URL":
                        DB_URL = value;
                        break;
                    case "DB_USER":
                        DB_USER = value;
                        break;
                    case "DB_PASSWORD":
                        DB_PASSWORD = value;
                        break;
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading .env file: " + e.getMessage());
        }
    }
}
