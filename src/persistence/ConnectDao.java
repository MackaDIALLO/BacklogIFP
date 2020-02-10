package persistence;

import java.sql.*;

public class ConnectDao {

    public Connection getConnectDB() {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Driver O.K.");

            String url = "jdbc:derby:db/ifp_db";

            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connexion effective !");
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(-1);
            //System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return null;
    }
}
