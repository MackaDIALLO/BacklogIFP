package services;

import java.sql.*;

public class ConnectionManager {

    public Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Driver O.K.");

            String url = "jdbc:derby:db/ifp_db";

            connection = DriverManager.getConnection(url);
            System.out.println("Connexion effective !");
            return connection;

        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(-1);
            //System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        } finally {
            if (connection != null)
                try {
                    // Fermeture de la connexion
                    connection.close();
                } catch (SQLException ignore) {
                    // S'il y a une erreur , on l'ignore
                }
        }
        return connection;
    }
}
