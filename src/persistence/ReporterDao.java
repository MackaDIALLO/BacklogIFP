package persistence;

import domain.Reporter;
import services.ConnectionManager;

import java.sql.*;

public class ReporterDao {

    ConnectionManager connectionManager;

    public ReporterDao() {
        connectionManager = new ConnectionManager();
    }

    public Reporter getReporterById(int id) throws SQLException {

        try {
            //1- lire la table reporter à partir de son id

            //Création d'un objet Statement
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.createStatement();

            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet resultQuery = preparedStatement.executeQuery("SELECT * FROM reporter where id = ?");
            ResultSet reporterOut = preparedStatement.executeQuery("SELECT * FROM reporter where id = ?");


            //On récupère les MetaData
            ResultSetMetaData resultMeta = reporterOut.getMetaData();

            System.out.println("\n**********************************");

            //On affiche le nom des colonnes
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t  *");

            System.out.println("\n**********************************");

            while (reporterOut.next()) {
                //System.out.println("\n");
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + reporterOut.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------");

            }
            reporterOut.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        }
        return null;
    }

    public Reporter setReporterById(int id) throws SQLException {

        try {


            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement1 = (PreparedStatement) connection.createStatement();
            int reporterIn = preparedStatement1.executeUpdate("INSERT INTO reporter (id, pseudo, credit) VALUES(?,?,?)");

            //reporterIn.close();
            preparedStatement1.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return null;
    }
}
