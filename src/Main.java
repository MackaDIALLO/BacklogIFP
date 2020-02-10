import persistence.NewsDao;
import persistence.ReporterDao;

public class Main {

    public static void main(String[] args) {
        /*//1-Lecteur reporters
        ReporterDao reporterDao = new ReporterDao();
        //for (int i = 1; i <= 3; i++) {}
            //reporterDao.getReporterById(1);
            reporterDao.getReporter();*/

        //2.1-Lecture d'une news
        NewsDao newsDao = new NewsDao();
        newsDao.getNews();
        }

}
