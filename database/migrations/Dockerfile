FROM golang:1.20.5-alpine3.18

RUN go install github.com/pressly/goose/v3/cmd/goose@latest

COPY wait-for-it.sh /
RUN chmod +x /wait-for-it.sh

WORKDIR /app

CMD ["goose"]
