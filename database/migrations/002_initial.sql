-- +goose Up
INSERT INTO player_status (id, name)
VALUES
    (1, 'Active'),
    (2, 'Inactive'),
    (5, 'Unknown');

INSERT INTO player (id, name, player_status_id, create_date)
VALUES
    (22660, 'xavi-simons', 1, NOW()),
    (21767, 'xavi-simons', 1, NOW()),
    (22648, 'kylian-mbappe', 1, NOW()),
    (26, 'kylian-mbappe', 2, NOW()),
    (19444, 'kylian-mbappe', 1, NOW());

INSERT INTO player_history (id, price, player_id, create_date)
VALUES
    (1, 100.50, 22660, NOW() - INTERVAL '1 hour'),
    (2, 150.75, 21767, NOW() - INTERVAL '1 hour'),
    (3, 80.25, 22648, NOW() - INTERVAL '1 hour'),
    (4, 200.00, 26, NOW() - INTERVAL '1 hour'),
    (5, 200.00, 19444, NOW() - INTERVAL '1 hour'),

    (6, 200.50, 22660, NOW() - INTERVAL '2 hour'),
    (7, 250.75, 21767, NOW() - INTERVAL '2 hour'),
    (8, 180.25, 22648, NOW() - INTERVAL '2 hour'),
    (9, 100.00, 26, NOW() - INTERVAL '2 hour'),
    (10, 150.00, 19444, NOW() - INTERVAL '2 hour');

-- +goose Down

TRUNCATE TABLE player_status;
TRUNCATE TABLE player;
TRUNCATE TABLE player_history;
