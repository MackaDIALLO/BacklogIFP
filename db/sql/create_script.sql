/* debut de d'accès et/ou de creation de la base
-ij
- >connect 'jdbc:derby:ifp_db;create=true';
-show tables; (montrer les tables)
-describe ; (voir les lignes de la table)
-select * from "nom_de_la_table" (pour voir le contenu de la table)

url-> 'jdbc:derby:db/ifp-deb'

class.forName("org.apage.derby.jdbc.Embedded Driver");
var cx = Driver Manager.getconnexion(url);
	cx.

run '..\sql\create_script.sql';
 */

/* exemple Clemens

DROP DATABASE ifp_db;
CREATE DATABASE ifp_db;
use ifp_db;


 */

-- Drop de la base

DROP DATABASE ipf_db;

-- Connexion à la base

connect 'jdbc:derby:ifp_db';


-- Creation des tables

CREATE TABLE Reporter
     (Id  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL, Pseudo VARCHAR(30) NOT NULL, Credit INT NOT NULL);

CREATE TABLE News
     (Id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
     Titre VARCHAR(30) NOT NULL,
     Contenu VARCHAR(100) NOT NULL,
     Date TIMESTAMP,
     IdReporter INTEGER);


CREATE TABLE Rating
     (Id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL, Commentary VARCHAR(100) NOT NULL, Valid BOOLEAN NOT NULL, Note INTEGER, IdNews INTEGER,
      IdReporter INTEGER);

CREATE TABLE Tag
     (Id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL, NameTag VARCHAR(30) NOT NULL);


CREATE TABLE NewsTag
     (Id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
      IdNews INTEGER,
      IdTag INTEGER);



-- Ajout des clés étrangères

ALTER TABLE News
ADD CONSTRAINT FK_news_reporter_id
FOREIGN KEY (IdReporter) REFERENCES Reporter(Id);

ALTER TABLE Rating
ADD CONSTRAINT FK_rating_news_id
FOREIGN KEY (IdNews) REFERENCES News(Id);

ALTER TABLE Rating
ADD CONSTRAINT FK_rating_reporter_id
FOREIGN KEY (IdReporter) REFERENCES Reporter(Id);



ALTER TABLE NewsTag
ADD CONSTRAINT FK_newsTag_news_id
FOREIGN KEY (IdNews) REFERENCES News(Id);

ALTER TABLE NewsTag
ADD CONSTRAINT FK_newsTag_tag_id
FOREIGN KEY (IdTag) REFERENCES Tag(Id);












