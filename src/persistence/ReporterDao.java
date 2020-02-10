package persistence;

import java.sql.*;

public class ReporterDao {

    ConnectDao connectDao = new ConnectDao();
    //public void getReporterById (int id) {
    public void getReporter () {

        try {
            //1- lire la table reporter à partir de son id

            //Création d'un objet Statement
            Connection conn = connectDao.getConnectDB();
            Statement statement = conn.createStatement();

            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = statement.executeQuery("SELECT * FROM reporter where id =" +id);
            ResultSet result = statement.executeQuery("SELECT * FROM reporter");

            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");

            //On affiche le nom des colonnes
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t  *");

            System.out.println("\n**********************************");

            while(result.next()){
                //System.out.println("\n");
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------");

            }

            result.close();
            statement.close();

        }catch(Exception e){

        }
    }
}
