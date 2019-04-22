-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 22 avr. 2019 à 12:52
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mariateam`
--

-- --------------------------------------------------------

--
-- Structure de la table `bateau`
--

DROP TABLE IF EXISTS `bateau`;
CREATE TABLE IF NOT EXISTS `bateau` (
  `idBateau` int(11) NOT NULL AUTO_INCREMENT,
  `NomBateau` varchar(50) NOT NULL,
  `VitesseMaxEnNoeud` double NOT NULL,
  `LongueurEnMetre` double NOT NULL,
  `LargeurEnMetre` double NOT NULL,
  `NbPlacesMaxPassager` int(11) DEFAULT '100',
  `NbPlacesMaxVInf2` int(11) DEFAULT '50',
  `NbPlacesMaxVSup2` int(11) DEFAULT '25',
  `PathImage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idBateau`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bateau`
--

INSERT INTO `bateau` (`idBateau`, `NomBateau`, `VitesseMaxEnNoeud`, `LongueurEnMetre`, `LargeurEnMetre`, `NbPlacesMaxPassager`, `NbPlacesMaxVInf2`, `NbPlacesMaxVSup2`, `PathImage`) VALUES
(1, 'Titanic', 30, 40, 10, 150, 40, 20, 'image/Titanic.jpg'),
(3, 'Adonia', 15, 20, 7, 14, 12, 15, 'image/Ardonia.jpg'),
(4, 'Balatik', 5.5, 15, 18, 100, 50, 25, 'image/Balatik.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `bateauequipe`
--

DROP TABLE IF EXISTS `bateauequipe`;
CREATE TABLE IF NOT EXISTS `bateauequipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idBateau` int(11) NOT NULL,
  `idEquipement` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ct_equipement` (`idEquipement`),
  KEY `ct_bateau` (`idBateau`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bateauequipe`
--

INSERT INTO `bateauequipe` (`id`, `idBateau`, `idEquipement`) VALUES
(1, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `LettreCategorie` varchar(5) NOT NULL,
  `libelleCategorie` varchar(50) NOT NULL,
  PRIMARY KEY (`LettreCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`LettreCategorie`, `libelleCategorie`) VALUES
('A', 'Passager'),
('B', 'Véh.inf.2m'),
('C', 'véh.sup.2m');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idClient` varchar(50) NOT NULL,
  `Role` varchar(254) NOT NULL,
  `NomClient` varchar(50) NOT NULL,
  `PrenomClient` varchar(50) NOT NULL,
  `CodePostal` varchar(5) NOT NULL,
  `Ville` varchar(50) NOT NULL,
  `Adresse` varchar(50) NOT NULL,
  `Mail` varchar(50) NOT NULL,
  `NbAchatsFidelisant` int(11) NOT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `idClient`, `Role`, `NomClient`, `PrenomClient`, `CodePostal`, `Ville`, `Adresse`, `Mail`, `NbAchatsFidelisant`, `mdp`) VALUES
(1, 'admin', 'admin', 'Administrateur', 'admin', '59000', 'Douai', 'marie team', 'admin@marieteam.fr', 0, 'admin'),
(2, 'client', 'user', 'NomClient', 'PrenomClient', '59000', 'Ville', 'Adresse', 'Mail@test.fr', 0, 'mdp'),
(7, 'M.Bedard', 'user', 'Bédard', 'Martin', '06600', 'ANTIBES', '83 Avenue De Marlioz', 'MartinBedard@Orange.fr', 0, 'Bedovitch06600'),
(5, 'O.Corbin', 'user', 'Corbin', 'Oliver', '37200', 'Tours', '67, avenue Jean Portalis', 'OliverCorbin@gmail.com', 0, '00000000'),
(6, 'S.Trudeau', 'user', 'Trudeau', 'Sophie', '92390', 'VILLENEUVE-LA-GARENNE', '60 place de Miremont', 'SophieTrudeau@gmail.com', 0, 'Praline62');

-- --------------------------------------------------------

--
-- Structure de la table `croisiere`
--

DROP TABLE IF EXISTS `croisiere`;
CREATE TABLE IF NOT EXISTS `croisiere` (
  `codeCroisiere` int(11) NOT NULL,
  `nomVoyage` varchar(50) NOT NULL,
  `NomBateau` varchar(50) NOT NULL,
  PRIMARY KEY (`codeCroisiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `equipementbateau`
--

DROP TABLE IF EXISTS `equipementbateau`;
CREATE TABLE IF NOT EXISTS `equipementbateau` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `equipementbateau`
--

INSERT INTO `equipementbateau` (`id`, `Libelle`) VALUES
(1, 'Gps marine'),
(2, 'Pare-battage'),
(3, 'Antifouling'),
(4, 'Radeaux De Survie'),
(5, 'Tableaux Electriques'),
(6, 'Porte-cannes');

-- --------------------------------------------------------

--
-- Structure de la table `fret`
--

DROP TABLE IF EXISTS `fret`;
CREATE TABLE IF NOT EXISTS `fret` (
  `codeFret` int(11) NOT NULL,
  `nomFret` varchar(50) NOT NULL,
  `NomBateau` varchar(50) NOT NULL,
  PRIMARY KEY (`codeFret`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `liaison`
--

DROP TABLE IF EXISTS `liaison`;
CREATE TABLE IF NOT EXISTS `liaison` (
  `codeLiaison` int(11) NOT NULL AUTO_INCREMENT,
  `distanceEnMiles` float NOT NULL,
  `codePort` int(5) NOT NULL,
  `codePort_Ports` int(5) NOT NULL,
  `NomSecteur` varchar(50) NOT NULL,
  PRIMARY KEY (`codeLiaison`),
  KEY `Liaison_Ports_FK` (`codePort`),
  KEY `Liaison_Ports0_FK` (`codePort_Ports`),
  KEY `Liaison_secteur1_FK` (`NomSecteur`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `liaison`
--

INSERT INTO `liaison` (`codeLiaison`, `distanceEnMiles`, `codePort`, `codePort_Ports`, `NomSecteur`) VALUES
(11, 25.1, 2, 4, 'Belle-Ile-en-mer'),
(15, 8.3, 1, 2, 'Belle-Ile-en-mer'),
(16, 8, 1, 3, 'Belle-Ile-en-mer'),
(17, 7.9, 3, 1, 'Belle-Ile-en-mer'),
(19, 23.7, 4, 2, 'Belle-Ile-en-mer'),
(21, 7.7, 6, 7, 'Ile de Groix'),
(22, 7.4, 7, 6, 'Ile de Groix'),
(24, 9, 2, 1, 'Belle-Ile-en-mer'),
(25, 8.8, 1, 5, 'Houat'),
(30, 8.8, 5, 1, 'Houat');

-- --------------------------------------------------------

--
-- Structure de la table `periode`
--

DROP TABLE IF EXISTS `periode`;
CREATE TABLE IF NOT EXISTS `periode` (
  `idPeriode` int(11) NOT NULL AUTO_INCREMENT,
  `saison` varchar(255) DEFAULT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `prixAdulte` float NOT NULL,
  `prixJunior` float NOT NULL,
  `prixEnfants` float NOT NULL,
  `prixVinf4m` float NOT NULL,
  `prixVinf5m` float NOT NULL,
  `prixFourgon` float NOT NULL,
  `prixCamping` float NOT NULL,
  `prixCamion` float NOT NULL,
  `idLiaison` int(11) NOT NULL,
  PRIMARY KEY (`idPeriode`),
  KEY `idLiaison` (`idLiaison`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `periode`
--

INSERT INTO `periode` (`idPeriode`, `saison`, `dateDebut`, `dateFin`, `prixAdulte`, `prixJunior`, `prixEnfants`, `prixVinf4m`, `prixVinf5m`, `prixFourgon`, `prixCamping`, `prixCamion`, `idLiaison`) VALUES
(1, 'Ete', '2019-06-03', '2019-09-01', 18, 11.1, 5.6, 86, 129, 189, 268, 205, 15),
(2, 'Hiver', '2019-09-02', '2020-05-31', 20, 13.1, 7, 95, 142, 208, 295, 226, 15),
(3, 'Ete', '2020-06-01', '2020-09-06', 19, 12.1, 6.4, 91, 136, 199, 282, 216, 15),
(4, 'Hiver', '2019-06-03', '2019-09-02', 27.2, 17.3, 9.8, 129, 194, 284, 402, 308, 19),
(5, 'Hiver', '2019-09-02', '2020-05-31', 29.3, 29.3, 10.6, 139, 209, 306, 434, 332, 19),
(6, 'Ete', '2020-06-01', '2020-09-06', 28.5, 18.1, 10.2, 135, 203, 298, 422, 323, 19),
(7, 'Hiver', '2019-04-01', '2019-09-02', 15, 9, 4.5, 79, 112, 147, 234, 189, 30),
(8, 'Hiver', '2019-09-02', '2020-05-31', 17.5, 10, 5, 82, 134, 181, 257, 202, 30),
(9, 'Ete', '2020-06-01', '2020-09-06', 16.5, 9.5, 4.25, 80, 123, 167, 246, 194, 30),
(10, 'Ete', '2019-06-03', '2019-09-02', 12.5, 7.5, 2.5, 75, 125, 175, 250, 200, 21),
(11, 'Hiver', '2019-09-02', '2020-05-31', 14.5, 8.75, 4.5, 82, 127, 186, 249, 204, 21),
(12, 'Ete', '2020-06-01', '2020-09-06', 13, 7.5, 2.5, 77, 124, 186, 258, 202, 21),
(13, 'Ete', '2019-06-03', '2019-09-00', 15, 8.5, 4.5, 82, 127, 186, 248, 197, 16),
(14, 'Hiver', '2019-09-02', '2020-05-31', 16, 9, 5, 84, 129, 189, 253, 202, 16),
(15, 'Ete', '2020-06-01', '2020-09-06', 15.5, 8.75, 4, 78, 122, 178, 241, 200, 16),
(16, 'printemps', '2019-04-10', '2019-06-05', 15, 14, 10, 150, 120, 200, 300, 350, 30);

-- --------------------------------------------------------

--
-- Structure de la table `ports`
--

DROP TABLE IF EXISTS `ports`;
CREATE TABLE IF NOT EXISTS `ports` (
  `codePort` int(5) NOT NULL AUTO_INCREMENT,
  `nomPort` varchar(50) NOT NULL,
  PRIMARY KEY (`codePort`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ports`
--

INSERT INTO `ports` (`codePort`, `nomPort`) VALUES
(1, 'Quiberon'),
(2, 'Le Palais'),
(3, 'Sauzon'),
(4, 'Vannes'),
(5, 'Port St Gildas'),
(6, 'Lorient'),
(7, 'Port-Tudy');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `NumReservation` int(50) NOT NULL AUTO_INCREMENT,
  `MontantARegler` float NOT NULL,
  `date` date NOT NULL,
  `Heure` varchar(50) NOT NULL,
  `numeroIdentifiant` int(11) NOT NULL,
  `idClient` varchar(50) NOT NULL,
  `PlacesA1` int(11) NOT NULL DEFAULT '0',
  `PlacesA2` int(11) NOT NULL DEFAULT '0',
  `PlacesA3` int(11) NOT NULL DEFAULT '0',
  `PlacesB1` int(11) NOT NULL DEFAULT '0',
  `PlacesB2` int(11) NOT NULL DEFAULT '0',
  `PlacesC1` int(11) NOT NULL DEFAULT '0',
  `PlacesC2` int(11) NOT NULL DEFAULT '0',
  `PlacesC3` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`NumReservation`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`NumReservation`, `MontantARegler`, `date`, `Heure`, `numeroIdentifiant`, `idClient`, `PlacesA1`, `PlacesA2`, `PlacesA3`, `PlacesB1`, `PlacesB2`, `PlacesC1`, `PlacesC2`, `PlacesC3`) VALUES
(1, 45, '2019-03-25', '9:25', 12345, '12345', 0, 0, 0, 0, 0, 0, 0, 0),
(2, 72, '2019-03-25', '9:52', 12345, '17349', 2, 1, 0, 0, 0, 1, 0, 0),
(3, 243, '2019-03-25', '10:54', 12345, '2497', 4, 3, 1, 1, 0, 1, 0, 0),
(5, 0, '2019-04-01', '10:52', 541197, 'S.Trudeau', 2, 1, 0, 1, 0, 0, 0, 0),
(7, 15, '2019-04-12', '13:14', 1685429, 'admin', 1, 0, 0, 0, 0, 0, 0, 0);

--
-- Déclencheurs `reservation`
--
DROP TRIGGER IF EXISTS `points_fidelite`;
DELIMITER $$
CREATE TRIGGER `points_fidelite` BEFORE INSERT ON `reservation` FOR EACH ROW BEGIN
IF(SELECT idClient FROM Client WHERE NbAchatsFidelisant >= 100 and idClient = NEW.idClient) IS NOT NULL THEN
	SET NEW.MontantARegler = NEW.MontantARegler*0.80;
    UPDATE Client SET NbAchatsFidelisant = NbAchatsFidelisant-100 WHERE idClient = NEW.idClient;

ELSEIF(SELECT numeroIdentifiant FROM traversee WHERE numeroIdentifiant = NEW.numeroIdentifiant AND DATEDIFF(curdate(),NEW.date) >= 60) IS NOT NULL THEN 
       UPDATE Client SET NbAchatsFidelisant = NbAchatsFidelisant+25 WHERE idClient = NEW.idClient;
	END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `secteur`
--

DROP TABLE IF EXISTS `secteur`;
CREATE TABLE IF NOT EXISTS `secteur` (
  `idSecteur` int(5) NOT NULL AUTO_INCREMENT,
  `NomSecteur` varchar(50) NOT NULL,
  PRIMARY KEY (`idSecteur`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `secteur`
--

INSERT INTO `secteur` (`idSecteur`, `NomSecteur`) VALUES
(1, 'Belle-Ile-en-mer'),
(2, 'Houat'),
(3, 'Ile de Groix');

-- --------------------------------------------------------

--
-- Structure de la table `traversee`
--

DROP TABLE IF EXISTS `traversee`;
CREATE TABLE IF NOT EXISTS `traversee` (
  `numeroIdentifiant` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `heureDeDepart` varchar(5) NOT NULL,
  `NomBateau` varchar(50) NOT NULL,
  `codeLiaison` int(11) NOT NULL,
  `idPeriode` int(255) NOT NULL,
  `PassagerRestant` int(11) NOT NULL,
  `VehInf2mRestant` int(11) NOT NULL,
  `VehSup2mRestant` int(11) NOT NULL,
  PRIMARY KEY (`numeroIdentifiant`)
) ENGINE=InnoDB AUTO_INCREMENT=1685430 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `traversee`
--

INSERT INTO `traversee` (`numeroIdentifiant`, `date`, `heureDeDepart`, `NomBateau`, `codeLiaison`, `idPeriode`, `PassagerRestant`, `VehInf2mRestant`, `VehSup2mRestant`) VALUES
(168427, '2020-03-27', '14:50', 'Aret\' Drop', 30, 8, 159, 8, 1),
(381947, '2020-08-24', '10:30', 'Lek\' Tep', 21, 12, 167, 6, 1),
(381949, '2020-08-24', '15:10', 'Cerjupt', 21, 12, 196, 3, 0),
(541197, '2019-07-10', '07:45', 'Kor\' Ant', 15, 1, 235, 10, 2),
(541198, '2019-07-10', '09:15', 'Ar Solen', 15, 1, 276, 5, 1),
(1685429, '2019-04-24', '17:30', 'Vreh Lokt', 30, 16, 139, 50, 50);

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `codeType` varchar(10) NOT NULL,
  `LibelleType` varchar(50) NOT NULL,
  `LettreCategorie` varchar(5) NOT NULL,
  PRIMARY KEY (`codeType`),
  KEY `Type_Categorie_FK` (`LettreCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`codeType`, `LibelleType`, `LettreCategorie`) VALUES
('A1', 'Adulte', 'A'),
('A2', 'Junior', 'A'),
('A3', 'Enfant', 'A'),
('B1', 'Voitureinf2m', 'B'),
('B2', 'Voituresup2m', 'B'),
('C1', 'Fourgon', 'C'),
('C2', 'Camping', 'C'),
('C3', 'Camion', 'C');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bateauequipe`
--
ALTER TABLE `bateauequipe`
  ADD CONSTRAINT `ct_bateau` FOREIGN KEY (`idBateau`) REFERENCES `bateau` (`idBateau`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ct_equipement` FOREIGN KEY (`idEquipement`) REFERENCES `equipementbateau` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `type`
--
ALTER TABLE `type`
  ADD CONSTRAINT `Type_Categorie_FK` FOREIGN KEY (`LettreCategorie`) REFERENCES `categorie` (`LettreCategorie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
