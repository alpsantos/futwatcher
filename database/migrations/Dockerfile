FROM alpine:latest

RUN apk --no-cache add postgresql-client

COPY *.sql /scripts/
COPY wait-for-it.sh /scripts/

# Define a senha na variável de ambiente PGPASSWORD
ENV PGPASSWORD=$DATABASE_PASSWORD

# Use o wait-for-it.sh para esperar pelo PostgreSQL antes de iniciar os comandos de migração
ENTRYPOINT ["/scripts/wait-for-it.sh", "-t", "120", "$DATABASE_HOST:5432", "--", \
            "sh", "-c", "for script in /scripts/*.sql; do \
                          psql -h $DATABASE_HOST -U $DATABASE_USER -d $DATABASE_NAME -a -f \"$script\"; \
                      done"]
