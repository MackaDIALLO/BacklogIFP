package persistence;

import domain.Reporter;
import services.ConnectionManager;

import java.sql.*;

public class ReporterDao {

    ConnectionManager connectionManager;

    public ReporterDao() {
        connectionManager = new ConnectionManager();
    }

 /**Lecture Avec Statement*/

    //public void readReporterByIdWithStatement (int id) {
    public void readReporterWithStatement() {

        try {
            //1- lire la table reporter à partir de son id

            //Création d'un objet Statement
            Connection connection = connectionManager.getConnection();

            Statement statement = connection.createStatement();

            /**L'objet ResultSet contient le résultat de la requête SQL*/

            //ResultSet reporter = statement.executeQuery("SELECT * FROM reporter");
            ResultSet reporter = statement.executeQuery("SELECT id, pseudo, credit FROM reporter");
            System.out.println( "Requête \"SELECT id, pseudo, credit FROM reporter;\" effectuée !" );


           /* //On récupère les MetaData
            ResultSetMetaData resultMeta = reporter.getMetaData();

            System.out.println("\n**********************************");

            //On affiche le nom des colonnes
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t  *");

            System.out.println("\n**********************************");

            while (reporter.next()) {
                //System.out.println("\n");
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + reporter.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------");

            }*/

            /** Récupération des données du résultat de la requête de lecture*/
            while ( reporter.next() ) {
                int reporterId = reporter.getInt( "id" );
                String reporterPseudo = reporter.getString( "pseudo" );
                int reporterCredit = reporter.getInt( "credit" );

                /** Traitement des valeurs récupérées.*/

                System.out.println( "Données retournées par la requête : id = " + reporterId + ", pseudo = " + reporterPseudo + ", credit= "
                        + reporterCredit +  "." );
            }


            reporter.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        }
    }


    /**Lecture Avec PreparedStatement*/

    //public void readReporterById (int id) {
    public void readReporter() {


        try {
            //1- lire la table reporter à partir de son id

            /**Création d'un objet PreparedStatement*/
            Connection connection = connectionManager.getConnection();
            //String sql = "SELECT * FROM reporter where id = ?";
            //String sql = "SELECT id, pseudo, credit FROM reporter where id = ?";
            //PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, pseudo, credit FROM reporter where id = ?");

            /**L'objet ResultSet contient le résultat de la requête SQL*/
            //ResultSet reporter = statement.executeQuery(sql);
            //ResultSet reporter = statement.executeQuery("SELECT * FROM reporter");
            //ResultSet reporter = statement.executeQuery("SELECT id, pseudo, credit FROM reporter");
            ResultSet reporter = preparedStatement.executeQuery();
            System.out.println( "Requête \"SELECT id, pseudo, credit FROM reporter;\" effectuée !" );


            /* //On récupère les MetaData
             ResultSetMetaData resultMeta = reporter.getMetaData();

             System.out.println("\n**********************************");

             //On affiche le nom des colonnes
             for (int i = 1; i <= resultMeta.getColumnCount(); i++)
             System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t  *");

             System.out.println("\n**********************************");

             while (reporter.next()) {
             //System.out.println("\n");
             for (int i = 1; i <= resultMeta.getColumnCount(); i++)
             System.out.print("\t" + reporter.getObject(i).toString() + "\t |");

             System.out.println("\n---------------------------------");

             }*/

            /** Récupération des données du résultat de la requête de lecture*/
            while ( reporter.next() ) {
                int reporterId = reporter.getInt( "id" );
                String reporterPseudo = reporter.getString( "pseudo" );
                int reporterCredit = reporter.getInt( "credit" );

                /** Traiter ici les valeurs récupérées.*/
                System.out.println( "Données retournées par la requête : id = " + reporterId + ", pseudo = " + reporterPseudo + ", credit= "
                        + reporterCredit +  "." );
            }


            reporter.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        }
    }


/** Création avec Statement*/
    public int createWithStatement(Reporter reporter) throws SQLException {


        int statut = 0;
        try {
            //1- lire la table reporter à partir de son id

            /**Création d'un objet Statement et connexion à la base*/
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();

            /**L'objet ResultSet contient le résultat de la requête SQL*/
            statut = statement.executeUpdate("INSERT INTO Reporter (pseudo, credit)\n" +
                    "VALUES ('AISSATOU', 4);", Statement.RETURN_GENERATED_KEYS);

            /** Récupération de l'id auto-généré par la requête d'insertion. */
            ResultSet reporterId = statement.getGeneratedKeys();

            /** Parcours du ResultSet et formatage pour affichage de la valeur qu'il contient dans la JSP finale. */
            while ( reporterId.next() ) {
                System.out.println( "ID retourné lors de la requête d'insertion :" + reporterId.getInt( 1 ) );
            }

            reporterId.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statut;
    }


/**Creation avec PreparedStatement*/
    public int create(Reporter reporter) throws SQLException {

        int statut = 0;
        try {
            /**1- lire la table reporter à partir de son id*/

            /**Création d'un objet Statement*/
            Connection connection = connectionManager.getConnection();
            //String sql = "INSERT INTO reporter (pseudo, credit) VALUES(?,?)";
            //PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reporter (pseudo, credit) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);

            /* Récupération des paramètres d'URL saisis par l'utilisateur /
            String paramEmail = request.getParameter( "email" );
            String paramMotDePasse = request.getParameter( "motdepasse" );
            String paramNom = request.getParameter( "nom" );*/

            /**
             * Remplissage des paramètres de la requête grâce aux méthodes setXXX() mises à disposition par l'objet PreparedStatement.
             */
            preparedStatement.setString( 1, "pseudo" );
            preparedStatement.setInt( 2, Integer.parseInt("credit"));

            /** Exécution de la requête */
            statut = preparedStatement.executeUpdate();

            /** Récupération de l'id auto-généré par la requête d'insertion. */
            ResultSet reporterId = preparedStatement.getGeneratedKeys();

            /** Parcours du ResultSet et formatage pour affichage de la valeur qu'il contient dans la JSP finale. */
            while ( reporterId.next() ) {
                System.out.println( "ID retourné lors de la requête d'insertion :" + reporterId.getInt( 1 ) );
            }

            reporterId.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statut;
    }

}
