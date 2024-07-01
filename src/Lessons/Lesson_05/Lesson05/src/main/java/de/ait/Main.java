package de.ait;

import java.sql.*;

public class Main {


    public static void main(String[] args) {


        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/";
        String db = "ait41_1";
        String userName = "postgres";
        String password = "Tumagedyb";

        Connection connection = getConnection(driver, url, db, userName, password);
        findAllUsers(connection);


    }


    public static Connection getConnection(String driver, String url, String db, String userName, String password) {
        try {
            String connectString = String.format("%s%s?user=%s&password=%s", url, db, userName, password);
            Connection connection1 = DriverManager.getConnection(connectString);
            Class.forName(driver);
            return connection1;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findAllUsers(Connection connection) {

        try {
            String sql = "select * from users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String pass = resultSet.getString(4);
                System.out.printf("%d %s %s %s", id, name, email, pass);
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}