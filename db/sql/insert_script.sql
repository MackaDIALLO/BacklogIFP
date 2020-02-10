-- ajout de reporters

INSERT INTO Reporter (pseudo, credit)
VALUES ('MACKA', 5);

INSERT INTO Reporter (pseudo, credit)
VALUES ('ETHAN', 3);

INSERT INTO Reporter (pseudo, credit)
VALUES ('SARAH', 5);

/*-- mettre à jour la table reporter pour la colonne credit

UPDATE Reporter
SET credit = 5,
WHERE id = 1;

UPDATE Reporter
SET credit = 2,
WHERE id = 2;

UPDATE Reporter
SET credit = 4,
WHERE id = 3;*/


-- ajout de news

INSERT INTO News (titre, contenu, date, idreporter)
VALUES ('NEW YORK TIME', 'Spiderman est de retour', '2020-02-26 05:18:00', 1),
       ('MIDI LIBRE', 'La mobilisation continue', '2019-07-06 15:38:00', 2),
       ('MORNING VOICE', 'Hello World!', '2010-08-23 05:18:00', 3);


-- ajout de rantings

INSERT INTO Rating (commentary, valid, note, idnews, idreporter)
VALUES ('Genial', true, 5, 1, 1),
       ('Excellent', true, 4, 2, 2),
       ('Extraordinaire',true, 3, 3, 3);


-- ajout de tags

INSERT INTO Tag (nametag)
VALUES ('#NYC'),
       ('#TLS'),
       ('#LNDN');


-- ajout de données newstag

INSERT INTO NewsTag (idnews, idtag)
VALUES (1, 1),
       (2, 2),
       (3, 3);




