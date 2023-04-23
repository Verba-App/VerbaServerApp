INSERT INTO verba_user (id, name, email, region, password)
VALUES (2, 'John Smool', 'john.smool@example.com', 'US', 'a1b2c3d4e5f6');

INSERT INTO allow_user_group (group_id, user_id, tactic_id)
VALUES (1, 2, 0);
