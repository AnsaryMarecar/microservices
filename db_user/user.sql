--
-- Base de données :  `db_user`
--

CREATE DATABASE db_user;

USE db_user;
-- --------------------------------------------------------
--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_surname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_mail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_adress` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_cp` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
COMMIT;

INSERT INTO `user` (`user_id`, `user_name`, `user_surname`, `user_mail`, `user_phone`, `user_adress`,`user_cp`,`user_city`,`user_country`) VALUES
(1, 'ansary', 'marecar', 'ansary.marecar@edu.esiee.fr','+33649853808','16, rue de la humette','95400','Arnouville','FRANCE');

-- --------------------------------------------------------