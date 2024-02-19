FROM postgres:15

ENV POSTGRES_USER=security-user
ENV POSTGRES_PASSWORD=abc1

ENV POSTGRES_DB=futebol-amigo

EXPOSE 5432

# docker build -t meu-postgres .
# docker run -d -p 5432:5432 --name meu-postgres-container meu-postgres

# docker exec -it meu-postgres-container psql -U security-user -d futebol-amigo
#  Isso permitirá que você execute comandos SQL diretamente no banco de dados,
# como consultas, inserções, atualizações, entre outros, diretamente do terminal do seu sistema.

# docker stop meu-postgres-container

# docker start meu-postgres-container

# docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' nome-do-seu-contêiner