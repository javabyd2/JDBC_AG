package com.sda.projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection connection = null;
    private static final String ADDRESS = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "rental_db";
    private static final String USER = "root";
    private static final String PASS = "sdapass";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PARAMS = "useSSL=false&serverTimezone=UTC";

    private static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadConnection() {
        try {
            connection = DriverManager.getConnection(getFormatedURL(), USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getFormatedURL() {
        return "jdbc:mysql://" + ADDRESS + ":" + PORT + "/" + DATABASE + "?" + PARAMS;
    }

    public static Connection connection() {
        if (connection == null) {
            loadDriver();
            loadConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection == null) {
            System.out.println("Nie ma co zamykać");
        } else {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}