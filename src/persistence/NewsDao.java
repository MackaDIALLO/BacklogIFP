package persistence;

import services.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


/**public class NewsDao {

   /** ConnectionManager connectDao = new ConnectionManager();
   /** ReporterDao reporterDao = new ReporterDao();
    //public void getNewsById (int id) {
    /**public void getNews () {

        try {
            //2- lire la table news avec son reporter avec la liste de ces tags

            //Création d'un objet Statement
            Connection conn = connectDao.getConnectDB();
            Statement statement = conn.createStatement();

            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = statement.executeQuery("SELECT * FROM reporter where id =" +id);
            //ResultSet result = statement.executeQuery("SELECT pseudo,titre,contenu, date FROM reporter, news WHERE reporter.id = news.idreporter");
            ResultSet result = statement.executeQuery("select reporter.pseudo, tag.nametag, news.titre, news.contenu, news.date from ((news  join reporter on reporter.id = news.idreporter) join tag on news.id = tag.id)");
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");

            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t\t\t\t   *");

            System.out.println("\n**********************************");

            while(result.next()){
                //System.out.println("\n");
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t\t\t |");

                System.out.println("\n---------------------------------");

            }

            result.close();
            statement.close();

        }catch(Exception e){

        }
    }*/
    //3- Ecriture d'une news avec gestion des id reporters ainsi que la liste des tags.
    //public void getNews () {}
   /** public void setGetNews () {

        try {
            //2- lire la table news avec son reporter avec la liste de ces tags

            //Création d'un objet Statement
          /*-------  Connection conn = connectDao.getConnectDB();
            Statement statement = conn.createStatement();


            /* Exécution d'une requête d'écriture */
            //int statut = statement.executeUpdate( "INSERT INTO News (titre, contenu, date, idreporter) VALUES ('CHARLIE HEBDO', 'Libérons la parole', CURRENT_TIMESTAMP, 1)");

            /* Formatage pour affichage dans la JSP finale. */
            //System.out.println( "Résultat de la requête d'insertion : " + statut + "." );

            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = statement.executeQuery("SELECT * FROM reporter where id =" +id);
            //ResultSet result = statement.executeQuery("SELECT pseudo,titre,contenu, date FROM reporter, news WHERE reporter.id = news.idreporter");
            /*--ResultSet result = statement.executeQuery("SELECT reporter.pseudo, tag.nametag, news.titre, news.contenu, news.date FROM ((news  JOIN reporter ON reporter.id = news.idreporter) JOIN tag ON news.id = tag.id)");
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");

            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t\t\t\t   *");

            System.out.println("\n**********************************");

            while(result.next()){
                //System.out.println("\n");
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t\t\t |");

                System.out.println("\n---------------------------------");

            }

            result.close();
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());

        }
    }
}*/

