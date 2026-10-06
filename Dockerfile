# Dockerfile — Option A : « exécution seulement »
#
# Ce Dockerfile NE compile PAS le projet : il réutilise un .jar déjà construit par Maven
# (ex. par le pipeline CI de la semaine 5, ou localement via `./mvnw clean package`).
# C'est l'approche recommandée quand une étape de build/test existe déjà ailleurs
# (CI ou commande manuelle) : on évite de recompiler une seconde fois dans l'image.
#
# Prérequis AVANT de construire cette image :
#   ./mvnw clean package -DskipTests
# (le .jar attendu est target/spring-petclinic-rest-4.0.2-S.jar)

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copie uniquement le .jar déjà construit (pas le code source, pas de recompilation ici)
COPY target/spring-petclinic-rest-*.jar app.jar

EXPOSE 9966

ENTRYPOINT ["java", "-jar", "app.jar"]
