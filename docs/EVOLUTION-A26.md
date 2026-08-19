# Demande d'évolution — Session Automne 2026

> Ce document simule une **demande de fonctionnalité** faite par la « direction de la clinique »
> à l'équipe de maintenance (vous). C'est le fil conducteur de vos TP tout au long de la session.

## Contexte

La clinique vétérinaire souhaite offrir un nouveau service à ses client·e·s : pouvoir consulter,
pour un animal donné, un **résumé de son historique de visites** directement depuis l'API,
sans avoir à combiner plusieurs appels HTTP côté client.

## Fonctionnalité demandée

Ajouter un nouvel endpoint (dans l'API **v2**, cohérent avec le style déjà en place dans
`PetRestControllerV2` / `PetV2Api`) :

```
GET /api/v2/pets/{petId}/visits/summary
```

Réponse attendue (exemple) :

```json
{
  "petId": 7,
  "petName": "Samantha",
  "totalVisits": 4,
  "firstVisitDate": "2023-01-15",
  "lastVisitDate": "2024-11-02",
  "visits": [
    { "date": "2024-11-02", "description": "rabies shot" },
    { "date": "2023-01-15", "description": "spayed" }
  ]
}
```

**Règles métier à respecter :**
1. Les visites doivent être triées de la **plus récente à la plus ancienne**.
2. Si l'animal n'a aucune visite, retourner `totalVisits: 0` et un tableau `visits` vide
   (pas une erreur 404 — un animal sans visite est un cas normal, pas une erreur).
3. Si `petId` n'existe pas, retourner `404 Not Found`.
4. Le endpoint doit être protégé par le même modèle de sécurité (rôles) que les autres
   endpoints de pets.

## Pourquoi cette fonctionnalité est un bon exercice de maintenance

* Elle **réutilise** du code existant (`ClinicService`, `PetMapper`, `VisitMapper`) — vous devez
  d'abord le comprendre avant d'écrire une seule ligne.
* Elle vous oblige à **repérer et corriger** un bogue existant dans `Pet.getVisits()` (voir
  la règle 1 ci-dessus — comparez avec le comportement actuel du code!).
* Elle nécessite d'**étendre le contrat OpenAPI** (`src/main/resources/openapi.yml`) de façon
  rétrocompatible — aucune route existante ne doit changer de comportement.
* Elle se prête bien aux tests : unitaires (mapping, tri, cas vide) et d'intégration
  (comportement HTTP complet, y compris la sécurité).

## Portée suggérée par TP (à ajuster selon l'avancement du groupe)

| TP | Ce qui est demandé |
|----|---------------------|
| TP2 (réusinage) | Corriger `Pet.getVisits()` et appliquer au moins 2 techniques de réusinage vues en classe ailleurs dans le contrôleur/service touché. |
| TP3 (nouvelle fonctionnalité + qualité) | Implémenter l'endpoint complet avec tests, documentation OpenAPI, et respecter le Quality Gate SonarQube/SonarCloud. |
| TP4 (déploiement) | Déployer la version contenant le nouvel endpoint via le pipeline CI/CD (build, image Docker, scan Trivy, déploiement K8s). |

