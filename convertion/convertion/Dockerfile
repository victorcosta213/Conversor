# Usar a imagem base do Maven para construir o projeto
FROM maven:3.9.0-eclipse-temurin-22 AS build

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml e as dependências do Maven
COPY pom.xml .

# Baixar dependências do Maven
RUN mvn dependency:go-offline

# Copiar todo o código do projeto
COPY . .

# Construir o projeto, gerando o arquivo JAR
RUN mvn clean package

# Usar a imagem base do JDK 22 para rodar a aplicação
FROM openjdk:22-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o JAR gerado da imagem anterior
COPY --from=build /app/target/convertion-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
