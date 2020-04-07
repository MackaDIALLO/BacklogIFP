package services;

import java.sql.*;

public class ConnectionManager {

    public Connection getConnection() throws SQLException {

        Connection connection = null;

        //Chargement du Driver
        try {

            System.out.println("Chargement du driver...");

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            System.out.println("Driver O.K.");

        } catch (ClassNotFoundException e) {

            throw new SQLException();
        }


            String url = "jdbc:derby:db/ifp_db";

            connection = DriverManager.getConnection(url);

            System.out.println("Connexion effective !");

            return connection;

        }
}
