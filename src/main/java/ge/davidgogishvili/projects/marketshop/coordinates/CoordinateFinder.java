package ge.davidgogishvili.projects.marketshop.coordinates;//package ge.davidgogishvili.projects.marketshop.coordinates;//package ge.davidgogishvili.projects.marketshop.coordinates;
//
//import java.sql.*;
//
//public class CoordinateFinder {
//
//    public static void main(String[] args) {
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String username = "dav";
//        String password = "Aa123123";
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            Statement statement = connection.createStatement();
//            String query = "SELECT latitude, longtitude FROM coordinate";
//
//            ResultSet resultSet = statement.executeQuery(query);
//
//            double longtitude1 = 0;
//            double longtitude2 = 0;
//            double latitude1 = 0;
//            double latitude2 = 0;
//
//            boolean firstRow = true;
//
//            while (resultSet.next()) {
//                if (firstRow) {
//                    longtitude1 = Math.toRadians(resultSet.getDouble("longtitude"));
//                    latitude1 = Math.toRadians(resultSet.getDouble("latitude"));
//                    firstRow = false;
//                } else {
//                    longtitude2 = Math.toRadians(resultSet.getDouble("longtitude"));
//                    latitude2 = Math.toRadians(resultSet.getDouble("latitude"));
//                }
//            }
//
//            double dlon = longtitude2 - longtitude1;
//            double dlat = latitude2 - latitude1;
//            double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(dlon / 2), 2);
//
//            double c = 2 * Math.asin(Math.sqrt(a));
//            double r = 6371;
//
//            double result = (c * r);
//
//            System.out.println("The result is: " + result + " Km");
//
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class CoordinateFinder {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("/home/david/Projects/IdeaProjects/marketshop/src/main/java/ge/davidgogishvili/projects/marketshop/coordinates/config.properties");
            properties.load(input);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                String query = "SELECT latitude, longtitude FROM coordinate";

                ResultSet resultSet = statement.executeQuery(query);

                double longtitude1 = 0;
                double longtitude2 = 0;
                double latitude1 = 0;
                double latitude2 = 0;

                boolean firstRow = true;

                while (resultSet.next()) {
                    if (firstRow) {
                        longtitude1 = Math.toRadians(resultSet.getDouble("longtitude"));
                        latitude1 = Math.toRadians(resultSet.getDouble("latitude"));
                        firstRow = false;
                    } else {
                        longtitude2 = Math.toRadians(resultSet.getDouble("longtitude"));
                        latitude2 = Math.toRadians(resultSet.getDouble("latitude"));
                    }
                }

                double dlon = longtitude2 - longtitude1;
                double dlat = latitude2 - latitude1;
                double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(dlon / 2), 2);

                double c = 2 * Math.asin(Math.sqrt(a));
                double r = 6371;

                double result = (c * r);

                System.out.println("The result is: " + result + " Km");

                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

