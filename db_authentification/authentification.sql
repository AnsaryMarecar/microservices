--
-- Base de données :  `db_authentification`
--

CREATE DATABASE db_authentification;

USE db_authentification;
--
-- Structure de la table `authentification`
--

DROP TABLE IF EXISTS `authentification`;
CREATE TABLE IF NOT EXISTS `authentification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `token` varchar(350) COLLATE utf8_unicode_ci DEFAULT NULL,
  `auth_date` datetime COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
COMMIT;

INSERT INTO `authentification` (`id`,`user_id`, `username`, `password`) VALUES
(1, 1, 'marecar', 'password');