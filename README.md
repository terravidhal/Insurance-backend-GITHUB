# Application de Gestion des Souscriptions d’Assurance

Ce projet consiste en une application backend développée avec Spring Boot pour gérer les souscriptions à des produits d’assurance. L’application offre une API REST pour effectuer des opérations CRUD sur les produits et souscriptions tout en gérant les utilisateurs et les rôles.

## Fonctionnalités principales

- Gestion des utilisateurs et des rôles (administrateurs et utilisateurs).
- CRUD (Création, Lecture, Mise à jour, Suppression) sur les produits d’assurance.
- CRUD sur les souscriptions aux produits.
- Système d’authentification sécurisé basé sur JWT.

## Modèle de Données

### Produit d’Assurance
- **Nom** : nom du produit.
- **Description** : détails et caractéristiques du produit.
- **Montant** : prix du produit.

### Souscription
- **Date** : date de souscription.
- **Date de début de la couverture**.
- **Date de fin de la couverture**.
- **Montant total** : montant final de la souscription.
- **Référence au produit souscrit**.
- **Référence à l'utilisateur**.

## Technologies Utilisées

- **Backend** : Spring Boot (Java)
- **Base de données** : MySQL
- **Sécurité** : JWT pour l’authentification
- **Gestion des dépendances** : Maven

## Prérequis

- Java 11+
- Maven 3.6+
- IDE compatible avec Java (IntelliJ, Eclipse, etc.)

## Installation et Configuration

1. Clonez le répertoire du projet :
   ```bash
   git clone https://github.com/terravidhal/Insurance-backend-GITHUB.git
   cd Insurance-backend-GITHUB
   ```

2. Installez les dépendances Maven :
   ```bash
   mvn clean install
   ```

3. Configurez le fichier `application.properties` dans `src/main/resources` pour vous connecter à la base de données mysql :
   ```properties
   spring.application.name=Insurance-backend
   spring.datasource.url=jdbc:mysql://localhost:3306/insurance?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=votre mot de passe
   spring.jpa.hibernate.ddl-auto=update
   app.secret-key=munTYrK&E5hfd2466122323131sssssf888888888888sfdfdffffff555ffffsfs 
   app.expiration-time=7200000 # Durée en millisecondes (2 heures)
   ```

4. Lancez l’application :
   ```bash
   mvn spring-boot:run
   ```
   ou lancer en cliquant sur le bouton `run` dans l'éditeur de code

5. Accédez à ma sqlWorkbench ou à la console "mysql" pour vérifier les données 

## Points d’API Principaux

### Authentification
- **POST** `/auth/login` : Générer un token JWT.

### Utilisateurs
- **GET** `/api/users` : Liste des utilisateurs (administrateurs uniquement).
- **GET** `/api/users/{id}` : Liste un utilisateur précis (administrateurs uniquement).
- **POST** `/api/users` : Ajouter un utilisateur.(administrateurs uniquement)
- **PUT** `/api/users/{id}` : Mettre à jour un utilisateur.(administrateurs uniquement)
- **DELETE** `/api/users/{id}` : Supprimer un utilisateur.(administrateurs uniquement)

### Produits d'Assurance
- **GET** `/api/products` : Liste des produits d’assurance.
- **GET** `/api/products/{id}` : Liste d'un produits d’assurance précis.
- **POST** `/api/products` : Ajouter un produit (administrateurs uniquement).
- **PUT** `/api/products/{id}` : Mettre à jour un produit.(administrateurs uniquement).
- **DELETE** `/api/products/{id}` : Supprimer un produit.(administrateurs uniquement).

### Souscriptions
- **GET** `/api/subscriptions` : Liste des souscriptions.
- **GET** `/api/subscriptions/{id}` : Liste une souscription précises.
- **POST** `/api/subscriptions` : souscrire à un produit.
- **PUT** `/api/subscriptions/{id}` : Mettre à jour une souscriptions.(administrateurs uniquement).
- **DELETE** `/api/subscriptions/{id}` : Supprimer une souscriptions.(administrateurs uniquement).

## Structure du Projet

- **src/main/java** : Code source principal
  - `controller` : Contrôleurs REST
  - `service` : Logique métier
  - `repository` : Gestion des entités avec Spring Data JPA
  - `entity` : Classes des entités
  - `configuration` : Configuration et gestion JWT
- **src/main/resources** : Configuration et fichiers statiques


## Configuration Cors
prendre en compte cette configuration cors qui
se trouve dans le fichier "jwtFilter.java"

```bash
   Configuration des en-têtes CORS
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
   ```
 




