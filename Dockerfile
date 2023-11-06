# Utilisez une image de base Java
FROM openjdk

# Définissez le répertoire de travail dans le conteneur
EXPOSE 8082
# Copiez le fichier JAR de votre application dans le conteneur
ADD target/khaddem-4.0.jar khaddem-4.0.jar


# Commande pour exécuter votre application Spring Boot
CMD ["java", "-jar", "khaddem-4.0.jar"]
