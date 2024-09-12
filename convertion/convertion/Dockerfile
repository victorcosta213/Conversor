# Usar a imagem base do Maven com JDK 17 para construir o projeto
FROM maven:3.9.0-eclipse-temurin-17 AS build

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml para baixar as dependências
COPY pom.xml .

# Copiar o restante dos arquivos do projeto para dentro do container
COPY src ./src

# Baixar as dependências do Maven
RUN mvn dependency:go-offline

# Construir o projeto, gerando o arquivo JAR
RUN mvn clean package

# Usar a imagem base do JDK 17 para rodar a aplicação
FROM eclipse-temurin:17-jdk

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o JAR gerado da imagem anterior
COPY --from=build /app/target/convertion-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

