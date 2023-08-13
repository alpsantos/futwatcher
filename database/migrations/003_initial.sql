-- +goose Up
insert into customers(id, name, email)
values (1,'john', 'john@mail.com'),
       (2,'rambo', 'rambo@mail.com');

-- +goose Down
