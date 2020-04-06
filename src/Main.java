//import persistence.NewsDao;
import persistence.ReporterDao;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        //1-Lecteur reporters
        ReporterDao reporterDao = new ReporterDao();
        //for (int i = 1; i <= 3; i++) {}
        reporterDao.getReporterById(1);


       /*//2-Lecture d'une news  avec son reporter avec la liste de ces tags
        NewsDao newsDao = new NewsDao();
        //newsDao.getNews();

        //3-Ecriture d'une news avec gestion des id reporters ainsi que la liste des tags.
        newsDao.setGetNews();*/
        }

}
