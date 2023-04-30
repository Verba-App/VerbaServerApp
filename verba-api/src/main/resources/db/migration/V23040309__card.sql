CREATE TYPE card_type AS ENUM ('PHOTO', 'QUOTE');

CREATE TABLE "card"
(
    "id"          BIGINT                      NOT NULL,
    "create_date" TIMESTAMP WITH TIME ZONE    NOT NULL,
    "catalog_id"  BIGINT REFERENCES "catalog" NOT NULL,
    "word_id"     BIGINT REFERENCES "word"    NOT NULL,
    "type"        resources_type              NOT NULL
);

CREATE TABLE "photo_card"
(
    "id"                BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type                resources_type                      NOT NULL CHECK (type = 'PHOTO'),
    "photo_resource_id" BIGINT REFERENCES "photo_resources" NOT NULL
) INHERITS ("card");


CREATE TABLE "quote_card"
(
    "id"                BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type                resources_type                      NOT NULL CHECK (type = 'QUOTE'),
    "quote_resource_id" BIGINT REFERENCES "quote_resources" NOT NULL
) INHERITS ("card");

CREATE OR REPLACE FUNCTION add_card_to_group()
    RETURNS TRIGGER AS
$$
DECLARE
    group_id_s BIGINT;
BEGIN
    -- Get the group ID for the new card

    SELECT group_id INTO group_id_s FROM catalog WHERE id = NEW.catalog_id;

    -- Update the statusCards hashmap with the new card information
    UPDATE allow_user_group as al
    SET status_cards = status_cards || jsonb_build_object(NEW.id, jsonb_build_object('stages', 0, 'repetitionDate',
                                                                                     (NOW() AT TIME ZONE 'UTC')::TIMESTAMP WITH TIME ZONE))
    WHERE al.group_id = group_id_s;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER add_card_to_group_trigger
    AFTER INSERT
    ON photo_card
    FOR EACH ROW
EXECUTE FUNCTION add_card_to_group();

CREATE OR REPLACE PROCEDURE next_step_card(
    IN p_card_id BIGINT,
    IN p_user_id BIGINT
)
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE allow_user_group as aug
    SET status_cards = jsonb_set(
            status_cards,
            ARRAY [p_card_id::text, 'stages'],
            ((status_cards -> p_card_id::text -> 'stages')::int + 1)::text::jsonb
        )
    where aug.user_id = p_user_id
      and EXISTS (SELECT 1
                  FROM catalog cat
                           join card c on cat.id = c.catalog_id
                  WHERE c.id = p_card_id
                    AND cat.group_id = aug.group_id);
END;
$$;


CREATE OR REPLACE PROCEDURE repeat_card(
    IN p_card_id BIGINT,
    IN p_user_id BIGINT
)
    LANGUAGE plpgsql
AS
$$
DECLARE
    p_repetition_date TIMESTAMP WITH TIME ZONE := NOW() AT TIME ZONE 'UTC';
BEGIN
    UPDATE allow_user_group as aug
    SET status_cards = jsonb_set(
            status_cards,
            ARRAY [p_card_id::text, 'repetitionDate'],
            to_jsonb(p_repetition_date)::text::jsonb
        )
    WHERE aug.user_id = p_user_id
      AND EXISTS (SELECT 1
                  FROM catalog cat
                           JOIN card c ON cat.id = c.catalog_id
                  WHERE c.id = p_card_id
                    AND cat.group_id = aug.group_id);
END;
$$;
