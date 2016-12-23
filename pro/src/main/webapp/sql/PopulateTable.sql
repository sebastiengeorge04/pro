
INSERT INTO `filmssite`(`id`,`name`, `release_date`,`director`, `duration`, `note`, `summary`,`acteur`) VALUES (1, 'Expandables', '2010-11-01','Stallone', 103, 3, 'Unite spéciale qui tire sur tout ce qui bouge et sort des blagues beaufs',5);
INSERT INTO `filmssite`(`id`,`name`, `release_date`,`director`, `duration`, `note`, `summary`,`acteur`) VALUES (2, 'Rocky', '1976-10-12', 'Avildsen', 118, 5,'Unknown guy from Phili who becomes a famous boxer',1);
INSERT INTO `filmssite`(`id`,`name`, `release_date`,`director`, `duration`, `note`, `summary`,`acteur`) VALUES (3, 'Piège de cristal', '1988-10-05', 'Mctiernan', 132, 4,'Bruce est coincé dans une tour qui est (comme par hasard) attaquée ce jour-là par des méchants',2);
INSERT INTO `filmssite`(`id`,`name`, `release_date`,`director`, `duration`, `note`, `summary`,`acteur`) VALUES (4, 'Predator', '1987-10-26', 'Mctiernan', 107, 4, 'Des aliens attaquent schwarzy, mais le gaillard est coriace',2);
INSERT INTO `filmssite`(`id`,`name`, `release_date`,`director`, `duration`, `note`, `summary`,`acteur`) VALUES (5, 'Bloodsport', '1988-10-26', 'Newt Arnold', 88, 5, 'Van Damme part bastonner des chinois à un tournoi',4);


INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES(1,'Stallone','Sylvester','6 juillet 1946','Americaine');
INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES(2,'Schwarzennegger','Arnold','30 juillet 1947','Americaine');
INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES(3,'Willis','Bruce','19 mars 1955','Americaine');
INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES(4,'Van-Damme','Jean Claude','18 octobre 1960','Belge');
INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES(5,'Plusieurs de ces acteurs','','','');

INSERT INTO `siteweb`.`bonussite` (`id_bonus`, `description`, `lien_youtube`) VALUES ('1', 'Une bonne baston comme on les aime', 'https://www.youtube.com/embed/aLBX68_Lqyo');