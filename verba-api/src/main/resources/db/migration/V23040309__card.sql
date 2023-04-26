CREATE TYPE card_type AS ENUM ('PHOTO', 'QUOTE');

CREATE TABLE "card"
(
    "id"         BIGINT                      NOT NULL,
    "create"     TIMESTAMP WITH TIME ZONE    NOT NULL,
    "repetition" TIMESTAMP WITH TIME ZONE    NOT NULL,
    "catalog_id" BIGINT REFERENCES "catalog" NOT NULL,
    "word_id"    BIGINT REFERENCES "word"    NOT NULL,
    "type"       resources_type              NOT NULL
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
