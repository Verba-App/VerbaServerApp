CREATE TABLE "group_catalog"
(
    "id"         serial       NOT NULL,
    "name"       VARCHAR(255) NOT NULL UNIQUE,
    "author_id"     BIGINT REFERENCES "verba_user" NOT NULL,
    CONSTRAINT "group_catalog_pk" PRIMARY KEY ("id")
);

CREATE OR REPLACE FUNCTION add_group_to_allow_user_group()
    RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO allow_user_group (user_id, group_id, access_read, access_changes, status_cards, tactic_id)
    VALUES (NEW.author_id, NEW.id, true, true, '{}', 0);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;



CREATE TRIGGER insert_into_allow_user_group
    AFTER INSERT
    ON group_catalog
    FOR EACH ROW
EXECUTE FUNCTION add_group_to_allow_user_group();
