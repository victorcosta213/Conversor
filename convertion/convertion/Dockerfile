# Usar a imagem base do JDK 17
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY target/convertion-0.0.1-SNAPSHOT.jar app.jar

# Informar a porta que será exposta
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
