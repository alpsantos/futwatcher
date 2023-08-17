-- +goose Up
CREATE TABLE player (
    id int   NOT NULL,
    name varchar(200)   NOT NULL,
    player_status_id int   NOT NULL,
    create_date timestamp DEFAULT current_timestamp NOT NULL,
    CONSTRAINT pk_player PRIMARY KEY (
        id
     )
);

CREATE TABLE player_status (
    id int   NOT NULL,
    name varchar(50)   NOT NULL,
    CONSTRAINT pk_player_status PRIMARY KEY (
        id
     ),
    CONSTRAINT uc_player_status_name UNIQUE (
        name
    )
);

CREATE TABLE player_history (
    id bigint   NOT NULL,
    price decimal   NOT NULL,
    player_id int   NOT NULL,
    create_date timestamp DEFAULT current_timestamp NOT NULL,
    CONSTRAINT pk_player_history PRIMARY KEY (
        id
     )
);

ALTER TABLE player ADD CONSTRAINT fk_player_player_status_id FOREIGN KEY(player_status_id)
REFERENCES player_status (id);

ALTER TABLE player_history ADD CONSTRAINT fk_player_history_player_id FOREIGN KEY(player_id)
REFERENCES player (id);


-- +goose Down
DROP TABLE player;
DROP TABLE player_status;
DROP TABLE player_history;