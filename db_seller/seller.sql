--
-- Base de données :  `db_seller`
--

CREATE DATABASE db_seller;

USE db_seller;
-- --------------------------------------------------------
--
-- Structure de la table `seller`
--

DROP TABLE IF EXISTS `seller`;
CREATE TABLE IF NOT EXISTS `seller` (
  `seller_id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`seller_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `seller`
--

INSERT INTO `seller` (`seller_id`, `seller_name`, `user_id`) VALUES
(1, 'Chez Marc BIO Attainville', 1),
(2, 'Chez Marc BIO Ecouen', 1),
(3, 'Chez Marc BIO Ezzanville', 1),
(4, 'Chez Marc BIO Roissy', 1),
(5, 'Chez Marc BIO Domont', 1),
(6, 'Chez Marc BIO Montmorency', 1);