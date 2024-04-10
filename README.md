# Test Technique

## Objectif
Le but de ce test est de développer une application complète permettant la création et la vérification d'identités à travers une API REST et une interface utilisateur simple.

## Spécifications Techniques

### Backend
- **API REST :** Développer une API REST avec les endpoints suivants :
  - **Création de personne :** Un endpoint pour créer une nouvelle personne. Les données requises sont : un numéro d'identité unique, nom, prénom, et date de naissance.
  - **Liste des personnes :** Un endpoint pour récupérer la liste de toutes les personnes créées.
  - **Vérification d'existence :** Un endpoint pour vérifier l'existence d'une personne en utilisant son numéro d'identité, nom, prénom, ou date de naissance. Cet endpoint doit retourner un score de matching (0 à 100) pour chaque champ (nom, prénom, date de naissance) par rapport au numéro d'identité fourni. Utiliser une logique de comparaison pour attribuer un score de similitude.

### Frontend
- Développer une interface utilisateur simple comprenant trois écrans :
  - **Création de personne :** Un formulaire permettant de saisir les informations nécessaires pour créer une nouvelle personne.
  - **Liste des personnes :** Une vue pour afficher la liste des personnes créées avec leurs informations.
  - **Recherche et vérification :** Un formulaire permettant de saisir un numéro d'identité, nom, prénom, ou date de naissance pour vérifier l'existence et afficher les scores de matching.

## Librairies recommandées

### Pour le backend (Java ou Kotlin/Spring Boot)
- Spring Boot : Utilisez `Spring Initializr` pour générer le squelette de l'application.

### Pour le scoring
- Java : Utilisez `Apache Commons Lang` (StringUtils.getJaroWinklerDistance).

### Pour le frontend
- Utilisez `React`  pour développer les interfaces utilisateur. Utilisez `Axios` ou `ReactQuery` pour les appels API.

## Exemples de code pour le scoring
- **Java (Apache Commons Lang) :**
  ```java
  double score = StringUtils.getJaroWinklerDistance("texte1", "texte2");

## Consignes supplémentaires
- Vous n'êtes pas obligé d'utiliser `Spring Initializr` pour initialiser le projet.
- Vous êtes libre d'utiliser la librairie de votre choix pour le scoring, le but ici est de ne pas réinventer la roue.
- Le code doit être propre et suivre les principes de clean code. Faites du mieux que vous pouvez en tout cas.
- Si vous ne terminez pas tous le test avant le délais, envoyez nous ce que vous aurez pu faire. Le but n'est pas de tout finir mais de présenter une solution qui fonctionne et qu'on pourra faire évoluer.
- Pour nous envoyer votre solution, pusher votre code sur une branche portant votre nom+premon sur ce repository

# Bonne Chance à vous et merci d'avance de vous être prêté au jeu
