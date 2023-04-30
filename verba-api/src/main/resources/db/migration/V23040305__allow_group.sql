CREATE TABLE "allow_user_group"
(
    "id"             serial                            NOT NULL,
    "user_id"        BIGINT REFERENCES "verba_user"    NOT NULL,
    "group_id"       BIGINT REFERENCES "group_catalog" NOT NULL,
    "access_read"    BOOLEAN                           NOT NULL DEFAULT 'true',
    "access_changes" BOOLEAN                           NOT NULL DEFAULT 'false',
    "status_cards"   jsonb                             NOT NULL DEFAULT '{}',
    "tactic_id"      BIGINT                            NOT NULL,
    CONSTRAINT "allow_user_group_pk" PRIMARY KEY ("id")
);

CREATE OR REPLACE FUNCTION add_group_cards_to_status_cards()
    RETURNS TRIGGER AS
$$
DECLARE
    card_ids BIGINT[];
BEGIN
    -- Get the IDs of all cards in the group
    SELECT array_agg(c.id)
    INTO card_ids
    FROM group_catalog as gc
             join catalog cat on gc.id = cat.group_id
             join card c on cat.id = c.catalog_id
    where gc.id = new.group_id;

    UPDATE allow_user_group
    SET status_cards = status_cards || jsonb_build_object(card_id, jsonb_build_object('stages', 0, 'repetitionDate',
                                                                                      (NOW() AT TIME ZONE 'UTC')::TIMESTAMP WITH TIME ZONE))
    FROM unnest(card_ids) AS card_id
    WHERE allow_user_group.id = NEW.id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER add_card_to_group_cards_trigger
    AFTER INSERT
    ON allow_user_group
    FOR EACH ROW
EXECUTE FUNCTION add_group_cards_to_status_cards();




CREATE OR REPLACE PROCEDURE remove_user_from_group(
    IN userid BIGINT,
    IN groupid BIGINT
)
    LANGUAGE plpgsql
AS
$$
BEGIN

    IF EXISTS (SELECT 1
               FROM group_catalog
               WHERE author_id = userid
                 AND id = groupid) THEN
        DELETE FROM allow_user_group WHERE group_id = groupid;
        DELETE FROM group_catalog WHERE author_id = userid AND id = groupid;
    ELSE
        DELETE FROM allow_user_group WHERE user_id = userid AND group_id = groupid;
    END IF;
END;
$$;
