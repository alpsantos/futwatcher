-- +goose Up
create table customers
(
    id    bigint not null,
    name  varchar                                 not null,
    email varchar                                 not null,
    primary key (id)
);

-- +goose Down
DROP TABLE customers;