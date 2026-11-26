# Task API

API REST de gestion de tâches développée avec Spring Boot, Spring Data JPA et H2.

## Fonctionnalités
- Créer, lister, modifier et supprimer des tâches (CRUD)
- Réponses au format JSON
- Base de données H2 en mémoire

## Endpoints
| Méthode | URL | Description |
|---------|-----|-------------|
| GET | /api/tasks | Lister les tâches |
| GET | /api/tasks/{id} | Détail d'une tâche |
| POST | /api/tasks | Créer une tâche |
| PUT | /api/tasks/{id} | Modifier une tâche |
| DELETE | /api/tasks/{id} | Supprimer une tâche |

## Lancer le projet
Avec Java 21 installé :

    ./mvnw spring-boot:run

L'API démarre sur http://localhost:8085

## Exemple

    curl -X POST localhost:8085/api/tasks -H "Content-Type: application/json" -d '{"title":"Ma tâche","description":"Test","done":false}'

## Technologies
Java 21, Spring Boot, Spring Data JPA, H2, Maven
