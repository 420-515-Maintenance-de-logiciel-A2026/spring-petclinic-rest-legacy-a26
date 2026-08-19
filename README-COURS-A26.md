# 🩺 Application legacy — 420-515-MV — Automne 2026

**Bienvenue dans votre projet de maintenance logicielle de la session !**

Ce dépôt est une version **legacy** (modifiée volontairement) du projet open source
[spring-petclinic-rest](https://github.com/spring-petclinic/spring-petclinic-rest), une API REST
Java/Spring Boot pour une clinique vétérinaire. C'est le fil conducteur de tous vos TP cette session :
chaque semaine, vous allez lire, comprendre, déboguer, réusiner et faire évoluer ce code.

> ℹ️ Le `readme.md` original du projet (plus bas dans ce fichier / dans `readme.md`) reste disponible
> pour la documentation technique générale (comment lancer l'app, structure du projet, etc.).
> Ce présent addendum contient les informations **spécifiques au cours**.

## ⚠️ Important — ce projet contient volontairement des bogues et de la dette technique

Comme dans un vrai emploi de développeur·euse junior, vous héritez d'un code qui n'est **pas
parfait**. Certains comportements sont incorrects par rapport à ce qui est documenté ou attendu.
**Votre travail sera, entre autres, de les découvrir vous-mêmes** (lecture de code, tests, débogage) —
ils ne vous seront pas tous révélés à l'avance. C'est une compétence professionnelle essentielle :
apprendre à ne jamais faire une confiance aveugle à du code existant, même s'il « a l'air » de fonctionner.

Quelques pistes de réflexion pour vous lancer (sans tout dévoiler) :
* Le tri d'une des listes retournées par l'API ne correspond pas à ce que la Javadoc de la classe
  laisse croire. Écrivez un test qui l'expose.
* Une comparaison entre deux nombres utilise un opérateur qui fonctionne « par hasard » la plupart
  du temps en Java, mais qui est reconnu comme une mauvaise pratique. Où, et pourquoi ça « marche »
  quand même dans les jeux de données de test ?
* Une règle de validation métier (âge d'un animal) semble avoir été modifiée à un moment donné
  d'une façon qui n'a plus vraiment de sens. Est-ce cohérent avec le message d'erreur affiché ?

## 📄 Demande d'évolution de la session

Voir [`docs/EVOLUTION-A26.md`](docs/EVOLUTION-A26.md) : une nouvelle fonctionnalité vous est
demandée par la « direction de la clinique ». C'est ce que vous allez construire, TP après TP,
par-dessus (et en corrigeant) le code existant.

## 🌱 Organisation du dépôt / des branches

* `main` : le code de départ fourni (ne pas modifier directement — partez-en pour créer vos branches).
* Créez une branche par équipe/TP selon les consignes données en classe (ex. `equipeX-tp2`).
* Les Pull Requests serviront à documenter vos changements et à déclencher le pipeline CI/CD
  (GitHub Actions et/ou GitLab CI, à confirmer en tout début de session).

## 🚀 Démarrage rapide

```sh
./mvnw spring-boot:run
```

Puis testez l'API : http://localhost:9966/petclinic/api/pets — voir `readme.md` pour la doc complète
(Swagger UI, comptes de test, profils de base de données, etc.).

**Prérequis :** Java 17+ (ce projet utilise Spring Boot 4 — vérifiez votre JDK avant de commencer!).

## 🧪 Lancer les tests

```sh
./mvnw test
```

Bonne session — et rappelez-vous : le code que vous maintenez aujourd'hui, c'est le genre de code
que vous maintiendrez en stage et en emploi. 💪
