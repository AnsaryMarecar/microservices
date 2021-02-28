--
-- Base de données :  `db_product`
--

CREATE DATABASE db_product;

USE db_product;
-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `category_parent` bigint(20) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`category_id`, `category_name`, `category_parent`) VALUES
(1, 'Boisson', 1),
(2, 'Fromager',2),
(3, 'Boucher', 3),
(4, 'Fruit & Légumes', 4);

-- --------------------------------------------------------

--
-- Structure de la table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`country_id`),
  UNIQUE KEY `country_name` (`country_name`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `country`
--

INSERT INTO `country` (`country_id`, `country_name`) VALUES
(1, 'FRANCE'),
(2, 'BELGIQUE');

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
create table product (product_id bigint not null auto_increment, 
category_id bigint not null, 
product_image varchar(255), 
product_name varchar(250) not null, 
product_price double precision not null, 
product_quantity varchar(255) not null, 
product_stock integer, 
seller_id bigint not null, 
primary key (product_id)) engine=InnoDB;

INSERT INTO product (product_name, product_quantity, product_price, category_id, seller_id, product_stock, product_image) VALUES
('Jus de raisin blanc BIO'	, '1.5 L'	, 3.59	, 1, 1,16,'https://www.smartfooding.com/fr/7940-large_default/jus-de-raisin-blanc-bio-200ml.jpg');
INSERT INTO product (product_name, product_quantity, product_price, category_id, seller_id, product_stock, product_image) VALUES
('Jus de pomme BIO', '6 * 1 L', 1.27, 1, 1,14,'https://www.smartfooding.com/fr/16171-large_default/jus-de-pomme-bio-200ml.jpg');
INSERT INTO product (product_name, product_quantity, product_price, category_id, seller_id, product_stock, product_image) VALUES
('Jus avoine BIO', '1.5 L', 3.50, 1, 2,12,'https://media.bio.coop/media/catalog/product/cache/83bd570234efdfaac300e4be6aa3bec2/2/1/2188353514-8023678161363-isola_bio-boisson_avoine_1l_1_2_palette-ab5076.jpeg'),
('Boisson Epautre original', '1 L', 3.20, 1, 2,23,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/4/3/430796419-8023678162209-isola_bio-boisson_epeautre_1l-ab5040.jpeg'),
('Jus de soja BIO', '1 L', 1.12, 1, 2,34,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/2/4/244795063-3273220180259-sojade-boisson_soja_calcium_1l-ti3004.jpeg'),
('Cocktail Orange Mangue', '25 cl', 1.99, 1, 3,26,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/2/8/281069573-4015533025471-voelkel-cocktail_orange_mangue_passion_25cl-na0595.jpeg'),
('Nectar Framboise Fraise', '21 cl', 2.12, 1, 3,23,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/1/4/1459352113-3274490975897--nectar_framboise_fraise_25cl-mb0062.jpeg'),
('Jus de raisin blanc BIO', '1.5 L', 3.52, 1, 6,12,'https://www.smartfooding.com/fr/7940-large_default/jus-de-raisin-blanc-bio-200ml.jpg'),
('Nectar Framboise Fraise', '21 cl', 2.28, 1, 6,65,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/1/4/1459352113-3274490975897--nectar_framboise_fraise_25cl-mb0062.jpeg'),
('Jus de pomme BIO', '6 * 1 L', 1.20, 1, 4,54,'https://www.smartfooding.com/fr/16171-large_default/jus-de-pomme-bio-200ml.jpg'),
('Jus avoine BIO', '1.5 L', 3.32, 1, 4,43,'https://media.bio.coop/media/catalog/product/cache/83bd570234efdfaac300e4be6aa3bec2/2/1/2188353514-8023678161363-isola_bio-boisson_avoine_1l_1_2_palette-ab5076.jpeg'),
('Sirop de menthe au sucre de cannes', '70 cL', 7.62, 1, 4,14,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/5/8/589655001-3217690053101-le_jardin_des_delices-sirop_menthe_70cl-ro6011.jpeg'),
('Eau de coco BIO', '0.75 L', 3.85, 1, 5,30,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/3/9/3955247947-8023678262305-isola_bio-eau_de_coco_tetra_50cl-ab5064.jpeg'),
('Kamboucha Original', '75 cL', 4.39, 1, 5,32,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/1/1/1156604982-4015533028724--kombucha_original_75cl-na0626.jpeg');

INSERT INTO product (product_name, product_quantity, product_price, category_id, seller_id, product_stock, product_image) VALUES
('Risella BIO', '200 g', 4.80, 2, 2,12,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/3/3/3305447995-8032754340851-bio_risella-biorisella_200g-to3052.jpeg'),
('Brie de Meaux AOP BIO au lait cru 20 % MG/PF Lait Plaisirs ', '170g', 5.70, 2, 2,23,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/14475/9ef42bac2681759c6da25622cc96d483.jpg'),
('Camembert de Normandie AOP BIO fermier au lait cru moulé à la louche, 20 % MG/PF', '200 g', 1.72, 2, 2,34,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/9415/8cd366540c6741fd81322459565b4d3e.jpg'),
('Carré au lait pasteurisé BIO 20 % MG/PF Le Montsûrais', '25 cl', 3.99, 2, 3,26,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/7929/d356b8ff21425c40f549b0aae1d84366.jpg'),
('Saint-Marcellin IGP BIO 25 % MG Vercors Lait', '21 cl', 2.72, 2, 3,23,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/6713/4990f73a38e868c43cef0c16c9b17786.jpg'),
('Bleu Auvergne AOP BIO, 29 % MG/PF, Lait Plaisirs', '1.5 L', 5.52, 2, 6,12,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/9434/35cee2513ccec8eea71c2570144ebf66.jpg'),
('Gorgonzola DOP BIO, 26 % MG',  '21 cl', 2.38, 2, 6,65,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/gorgonzola/8ce819db185ca1f068e5775006424917.jpg');

INSERT INTO product (product_name, product_quantity, product_price, category_id, seller_id, product_stock, product_image) VALUES
('Brie de Meaux AOP BIO au lait cru 20 % MG/PF Lait Plaisirs ', '170g', 5.70, 2, 4,23,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/14475/9ef42bac2681759c6da25622cc96d483.jpg'),
('Carré au lait pasteurisé BIO 20 % MG/PF Le Montsûrais', '25 cl', 3.99, 2, 4,26,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/7929/d356b8ff21425c40f549b0aae1d84366.jpg'),
('Bleu Auvergne AOP BIO, 29 % MG/PF, Lait Plaisirs', '1.5 L', 5.52, 2, 1,12,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/9434/35cee2513ccec8eea71c2570144ebf66.jpg'),
('Gorgonzola DOP BIO, 26 % MG',  '21 cl', 2.38, 2, 1,65,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/gorgonzola/8ce819db185ca1f068e5775006424917.jpg'),
('Bleu Auvergne AOP BIO, 29 % MG/PF, Lait Plaisirs', '1.5 L', 5.52, 2, 5,12,'https://fridg-front.s3.amazonaws.com/media/CACHE/images/products/9434/35cee2513ccec8eea71c2570144ebf66.jpg'),
('Risella BIO', '200 g', 4.80, 2, 5,12,'https://media.bio.coop/media/catalog/product/cache/2b0c9f47140744074a8c099021678323/3/3/3305447995-8032754340851-bio_risella-biorisella_200g-to3052.jpeg');


INSERT INTO product (product_name, product_quantity, product_price, category_id, seller_id, product_stock, product_image) VALUES
('Roti de boeuf bio, La Noblesse Des Viandes Bio ORIGINE FRANCE', '600g', 23.52, 3, 1,52,'https://media.houra.fr/ART-IMG-L/00/00/2307058000000-2.jpg'),
('Nature De France Poulet blanc Bio',  '1,35kg', 14.28, 3, 1,55,'https://media.houra.fr/ART-IMG-L/80/72/3422210437280-2.jpg'),
('Roti de boeuf bio, La Noblesse Des Viandes Bio ORIGINE FRANCE', '600g', 23.52, 3, 2,52,'https://media.houra.fr/ART-IMG-L/00/00/2307058000000-2.jpg'),
('Nature De France Poulet blanc Bio',  '1,35kg', 14.28, 3, 2,55,'https://media.houra.fr/ART-IMG-L/80/72/3422210437280-2.jpg'),
('Roti de boeuf bio, La Noblesse Des Viandes Bio ORIGINE FRANCE', '600g', 23.52, 3, 3,52,'https://media.houra.fr/ART-IMG-L/00/00/2307058000000-2.jpg'),
('Nature De France Poulet blanc Bio',  '1,35kg', 14.28, 3, 3,55,'https://media.houra.fr/ART-IMG-L/80/72/3422210437280-2.jpg'),
('Roti de boeuf bio, La Noblesse Des Viandes Bio ORIGINE FRANCE', '600g', 23.52, 3, 4,52,'https://media.houra.fr/ART-IMG-L/00/00/2307058000000-2.jpg'),
('Nature De France Poulet blanc Bio',  '1,35kg', 14.28, 3, 4,55,'https://media.houra.fr/ART-IMG-L/80/72/3422210437280-2.jpg'),
('Roti de boeuf bio, La Noblesse Des Viandes Bio ORIGINE FRANCE', '600g', 23.52, 3, 5,52,'https://media.houra.fr/ART-IMG-L/00/00/2307058000000-2.jpg'),
('Nature De France Poulet blanc Bio',  '1,35kg', 14.28, 3, 5,55,'https://media.houra.fr/ART-IMG-L/80/72/3422210437280-2.jpg'),
('Roti de boeuf bio, La Noblesse Des Viandes Bio ORIGINE FRANCE', '600g', 23.52, 3, 6,52,'https://media.houra.fr/ART-IMG-L/00/00/2307058000000-2.jpg'),
('Nature De France Poulet blanc Bio',  '1,35kg', 14.28, 3, 6,55,'https://media.houra.fr/ART-IMG-L/80/72/3422210437280-2.jpg');

INSERT INTO product (product_name, product_quantity, product_price, category_id, seller_id, product_stock, product_image) VALUES
('Roti de boeuf bio', '600g', 12.52, 3, 1,12,'https://media.houra.fr/ART-IMG-L/00/00/2307044000000-1.jpg'),
('Roti de boeuf bio', '600g', 12.52, 3, 2,12,'https://media.houra.fr/ART-IMG-L/00/00/2307044000000-1.jpg'),
('Roti de boeuf bio', '600g', 12.52, 3, 3,12,'https://media.houra.fr/ART-IMG-L/00/00/2307044000000-1.jpg'),
('Roti de boeuf bio', '600g', 12.52, 3, 5,12,'https://media.houra.fr/ART-IMG-L/00/00/2307044000000-1.jpg'),
('Roti de boeuf bio', '600g', 12.52, 3, 4,12,'https://media.houra.fr/ART-IMG-L/00/00/2307044000000-1.jpg'),
('Roti de boeuf bio', '600g', 12.52, 3, 6,12,'https://media.houra.fr/ART-IMG-L/00/00/2307044000000-1.jpg');

INSERT INTO product (product_name, product_quantity, product_price, category_id, seller_id, product_stock, product_image) VALUES
('Celeri rave','Unique (~1kg)', 3.52, 4, 1,12,'https://media.houra.fr/ART-IMG-L/79/23/2050000352379-1.jpg'),
('Betterave Rouge crue','Barquette de 500g', 2.28, 4, 1,65,'https://media.houra.fr/ART-IMG-L/47/73/2050000317347-4.jpg'),
('Aubergine Catégorie 1, Calibre 3/4',  'Unique', 1.20, 4, 1,54,'https://media.houra.fr/ART-IMG-L/38/28/2050000332838-1.jpg'),
('Champignon de Paris Blanc','Barquette de 500g', 3.32, 4, 1,43,'https://media.houra.fr/ART-IMG-L/92/01/3700552800192-1.jpg'),
('Celeri rave','Unique (~1kg)', 3.52, 4, 2,12,'https://media.houra.fr/ART-IMG-L/79/23/2050000352379-1.jpg'),
('Betterave Rouge crue','Barquette de 500g', 2.28, 4, 2,65,'https://media.houra.fr/ART-IMG-L/47/73/2050000317347-4.jpg'),
('Aubergine Catégorie 1, Calibre 3/4',  'Unique', 1.20, 4, 2,54,'https://media.houra.fr/ART-IMG-L/38/28/2050000332838-1.jpg'),
('Champignon de Paris Blanc','Barquette de 500g', 3.32, 4, 2,43,'https://media.houra.fr/ART-IMG-L/92/01/3700552800192-1.jpg'),
('Celeri rave','Unique (~1kg)', 3.52, 4, 3,12,'https://media.houra.fr/ART-IMG-L/79/23/2050000352379-1.jpg'),
('Betterave Rouge crue','Barquette de 500g', 2.28, 4, 3,65,'https://media.houra.fr/ART-IMG-L/47/73/2050000317347-4.jpg'),
('Aubergine Catégorie 1, Calibre 3/4',  'Unique', 1.20, 4, 3,54,'https://media.houra.fr/ART-IMG-L/38/28/2050000332838-1.jpg'),
('Champignon de Paris Blanc','Barquette de 500g', 3.32, 4, 3,43,'https://media.houra.fr/ART-IMG-L/92/01/3700552800192-1.jpg'),
('Celeri rave','Unique (~1kg)', 3.52, 4, 4,12,'https://media.houra.fr/ART-IMG-L/79/23/2050000352379-1.jpg'),
('Betterave Rouge crue','Barquette de 500g', 2.28, 4, 4,65,'https://media.houra.fr/ART-IMG-L/47/73/2050000317347-4.jpg'),
('Aubergine Catégorie 1, Calibre 3/4',  'Unique', 1.20, 4, 4,54,'https://media.houra.fr/ART-IMG-L/38/28/2050000332838-1.jpg'),
('Champignon de Paris Blanc','Barquette de 500g', 3.32, 4, 4,43,'https://media.houra.fr/ART-IMG-L/92/01/3700552800192-1.jpg'),
('Celeri rave','Unique (~1kg)', 3.52, 4, 5,12,'https://media.houra.fr/ART-IMG-L/79/23/2050000352379-1.jpg'),
('Betterave Rouge crue','Barquette de 500g', 2.28, 4, 5,65,'https://media.houra.fr/ART-IMG-L/47/73/2050000317347-4.jpg'),
('Aubergine Catégorie 1, Calibre 3/4',  'Unique', 1.20, 4, 5,54,'https://media.houra.fr/ART-IMG-L/38/28/2050000332838-1.jpg'),
('Champignon de Paris Blanc','Barquette de 500g', 3.32, 4, 5,43,'https://media.houra.fr/ART-IMG-L/92/01/3700552800192-1.jpg'),
('Celeri rave','Unique (~1kg)', 3.52, 4, 6,12,'https://media.houra.fr/ART-IMG-L/79/23/2050000352379-1.jpg'),
('Betterave Rouge crue','Barquette de 500g', 2.28, 4, 6,65,'https://media.houra.fr/ART-IMG-L/47/73/2050000317347-4.jpg'),
('Aubergine Catégorie 1, Calibre 3/4',  'Unique', 1.20, 4, 6,54,'https://media.houra.fr/ART-IMG-L/38/28/2050000332838-1.jpg'),
('Champignon de Paris Blanc','Barquette de 500g', 3.32, 4, 6,43,'https://media.houra.fr/ART-IMG-L/92/01/3700552800192-1.jpg');

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