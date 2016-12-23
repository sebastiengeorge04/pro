CREATE SCHEMA `siteweb`;

CREATE TABLE `acteurssite` (
`id_acteur` INT(2) NOT NULL AUTO_INCREMENT,
`nom` VARCHAR(100),
`prenom` VARCHAR(100),
`date_naissance` VARCHAR(20),
`nationalite` VARCHAR(25),
PRIMARY KEY(`id_acteur`)
);

CREATE TABLE `filmssite` (
`id` INT(2) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100),
`release_date` VARCHAR(20),
`director` VARCHAR(50),
`duration` INT(11),
`note` INT(11),
`summary` VARCHAR(500),
`acteur` INT(2),
PRIMARY KEY (`id`),
FOREIGN KEY(`acteur`) REFERENCES `acteurssite`(`id_acteur`)
);

CREATE TABLE `siteweb`.`bonussite` (
  `id_bonus` INT(2) NOT NULL,
  `description` VARCHAR(500) NULL,
  `lien_youtube` VARCHAR(500) NULL,
  PRIMARY KEY (`id_bonus`)
  );
