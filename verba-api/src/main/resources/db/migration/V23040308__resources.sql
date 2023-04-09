CREATE TYPE resources_type AS ENUM ('PHOTO', 'QUOTE');

CREATE TABLE "resources"
(
    "id"        BIGINT                   not null,
    "name"      VARCHAR(255)             NOT NULL,
    "author_id" BIGINT REFERENCES "user" NOT NULL,
    "type"      resources_type           NOT NULL
);


CREATE TABLE "photo_resources"
(
    "id"   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type   resources_type NOT NULL CHECK (type = 'PHOTO'),
    "path" VARCHAR(255)   NOT NULL UNIQUE
) INHERITS (resources);

CREATE TABLE "quote_resources"
(
    "id"   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type   resources_type NOT NULL CHECK (type = 'QUOTE'),
    "context" VARCHAR(255)   NOT NULL UNIQUE
) INHERITS (resources);

