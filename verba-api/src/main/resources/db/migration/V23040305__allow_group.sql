CREATE TABLE "allow_user_group"
(
    "id"             serial                            NOT NULL,
    "user_id"        BIGINT REFERENCES "verba_user"          NOT NULL,
    "group_id"          BIGINT REFERENCES "group_catalog" NOT NULL,
    "access_read"    BOOLEAN                           NOT NULL DEFAULT 'true',
    "access_changes" BOOLEAN                           NOT NULL DEFAULT 'false',
    "tactic_id"         BIGINT                           NOT NULL,
    CONSTRAINT "allow_user_group_pk" PRIMARY KEY ("id")
);

CREATE OR REPLACE FUNCTION add_group_to_allow_user_group()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO allow_user_group (user_id, group_id, access_read, access_changes, tactic_id)
    VALUES (NEW.author_id, NEW.id, true, true, 0);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;




CREATE TRIGGER insert_into_allow_user_group
    AFTER INSERT ON group_catalog
    FOR EACH ROW
EXECUTE FUNCTION add_group_to_allow_user_group();


CREATE OR REPLACE PROCEDURE remove_user_from_group(
    IN userid BIGINT,
    IN groupid BIGINT
)
    LANGUAGE plpgsql
AS $$
BEGIN

    IF EXISTS (
        SELECT 1 FROM group_catalog WHERE author_id = userid AND id = groupid
    ) THEN
        DELETE FROM allow_user_group WHERE group_id = groupid;
        DELETE FROM group_catalog WHERE author_id = userid AND id = groupid;
    ELSE
        DELETE FROM allow_user_group WHERE user_id = userid AND group_id = groupid;
    END IF;
END;
$$;
