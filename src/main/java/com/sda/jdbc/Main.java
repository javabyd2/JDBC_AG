package com.sda.jdbc;

import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Connection connection = DBConnector.getConnection();
        Statement statement = null;

        try {

            statement = connection.createStatement();

            String selectAllFromCustomer = "SELECT * FROM customer";
            ResultSet resultSelectAllFromCustomer = statement.executeQuery(selectAllFromCustomer);
            while (resultSelectAllFromCustomer.next()) {
                System.out.println("Imie: " + resultSelectAllFromCustomer.getString("first_name"));
            }

            String selectAllFromRent = "SELECT * FROM rent";
            ResultSet resultSelectAllFromRent = statement.executeQuery(selectAllFromRent);
            while (resultSelectAllFromRent.next()) {
                System.out.println("Numer rejestracyjny: " + resultSelectAllFromRent.getString("reg_number"));
            }


            String insertInto1 = "insert into customer (first_name, last_name, address, postal_code) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insertInto1);
            preparedStatement1.setString(1, "Adrian");
            preparedStatement1.setString(2, "Gielzak");
            preparedStatement1.setString(3, "Tucholkowej");
            preparedStatement1.setString(4, "85-795");
            preparedStatement1.executeUpdate();

            resultSelectAllFromCustomer = statement.executeQuery(selectAllFromCustomer);
            while (resultSelectAllFromCustomer.next()) {
                System.out.print("Imię i nazwisko: " + resultSelectAllFromCustomer.getString("first_name"));
                System.out.println(resultSelectAllFromCustomer.getString("last_name"));
            }

            String insertInto2 = "INSERT INTO rent (cust_id, reg_number, rent_date) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(insertInto2);
            preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(2, "SK 12345");
            preparedStatement2.setDate(3, Date.valueOf("2017-02-21"));
            preparedStatement2.executeUpdate();

//            String deleteAdrianGielzak = "DELETE FROM customer " +
//                                        "WHERE first_name = \"Adrian\" and last_name = \"Gielzak\"";
//            PreparedStatement statementDeleteAdrianGielzak = connection.prepareStatement(deleteAdrianGielzak);
//            statementDeleteAdrianGielzak.executeUpdate();

            String instertInto3 = "INSERT INTO rent (cust_id, reg_number, rent_date) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement3 = connection.prepareStatement(instertInto3);
            preparedStatement3.setInt(1, 11);
            preparedStatement3.setString(2, "SK 12345");
            preparedStatement3.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatement3.executeUpdate();

            String update1 = "UPDATE rent SET cust_id = 1 WHERE cust_id = 10";
            PreparedStatement preparedStatement4 = connection.prepareStatement(update1);
            preparedStatement4.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}