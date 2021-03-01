# Microservices Catastima
Catastima est une solution permettant une visibilité des produits de l'ensemble d'une enseigne de franchise bio.
La solution permet une visibilité de l'ensemble des magasins (seller) disponible au sein de la franchise.

### Techonologie
La solution a été réalisée en microservices avec Docker. 
Utilisation de dockerfile et docker-compose. 
Un travail sur docker swarm a également été essayé, mais non aboutis.

Concernant le developpement, il a principalement été réalisé en Java Spring Boot avec API rest, spring security, ou encore l'usage de technologie developpé par Spotify.

Le powerpoint du projet avec un descriptif complet est disponible sur le lien suivant (accessible uniquement pour l'enseignant) :
https://docs.google.com/presentation/d/1dtHue-hyfMCjdjifYWxZiljplaH_i2NbMUrkZ17cH2U/edit?usp=sharing

Il est également disponible en PDF dans le dossier du projet.

### Micro-services du projet :
- User (gestion données utilisateurs) // port : 9005
- Authentification (conservation pseudonyme, password et token de connexion) // port : 9004
- Seller (correspond à nos points de ventes) // port : 9003
- Category (gestion des categories de nos produits) // port : 9002
- Product (gestion de nos produit, nombre de pièce disponible, information pratique sur le produit, etc.) // port : 9001

- Catastima (notre front-office) // port : 9021

Chaque micro-services dispose de deux conteneurs docker :
	- Executable code
	- Base de données attribuée
	
Le code source étant en Java, le code source est compilé au sein du dockerfile lorsque le docker-compose fait appel à ce dernier.


### Prérequis
- Docker installé et lancé
- Connexion internet
- Espace de stockage disponible +3gb

### Execution
- Faire sur votre terminal à la racine du projet : docker compose up (vous pouvez ajouter sudo devant)
- Patienter le temps du chargement (environ 20/30 minutes)
- une fois terminé, ouvrez un navigateur Web, puis rechercher : localhost:9021

### Une fois sur le site (dans l'ordre)
- Cliquer sur un magasin (seller)
- Trier par catégorie
- Cliquer sur le bouton intranet et identifiez-vous (username : marecar, password : password)
- Et naviguer ;-)

### Disposition du site
- Une partie client ouverte à tous
- une partie back-office (intranet) destiné à la gestion interne nécessitant une connexion

### Contact
Pour tout contact sur le projet, veuillez contacter Ansary MARECAR ansary.marecar'@'edu.esiee.fr

### Date de réalisation
1er trimestre 2021

### Réalisation
Ansary MARECAR dans le cadre de l'enseignement micro-services à l'école d'ingénieur de l'ESIEE Paris