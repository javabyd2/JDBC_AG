package com.sda.projekt;

import java.sql.*;
import java.util.Scanner;

public class CommandOnDB {

    static Connection connection = DBConnector.connection();
    static Statement statement = null;
    
    public static void addCustommer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj imie: ");
        String first_name = scanner.next();
        System.out.print("Podaj nazwisko: ");
        String last_name = scanner.next();
        System.out.print("Podaj adres: ");
        String address = scanner.next();
        System.out.print("Podaj kod pocztowy: ");
        String postal_code = scanner.next();
        System.out.print("Podaj maila: ");
        String email = scanner.next();
        try {
            String insertInto = "INSERT INTO customer (first_name, last_name, address, postal_code, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertInto);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, postal_code);
            preparedStatement.setString(5, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void showCustommers() {
        try {
            statement = connection.createStatement();
            String selectAllFromCustomer = "SELECT * FROM customer";
            ResultSet resultSetSelectAllFromCustomer = statement.executeQuery(selectAllFromCustomer);
            while (resultSetSelectAllFromCustomer.next()) {
                String first_name = resultSetSelectAllFromCustomer.getString("first_name");
                String last_name = resultSetSelectAllFromCustomer.getString("last_name");
                String address = resultSetSelectAllFromCustomer.getString("address");
                String postal_code = resultSetSelectAllFromCustomer.getString("postal_code");
                System.out.format("%1$-10s|%2$-10s|%3$-20s|", first_name, last_name, address);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editCustomer() {

    }

}