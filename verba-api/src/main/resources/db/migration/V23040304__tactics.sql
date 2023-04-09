CREATE TABLE "tactics"
(
    "id"        serial                   NOT NULL,
    "name"      VARCHAR(255)             NOT NULL,
    "author_id" BIGINT REFERENCES "verba_user" NOT NULL,
    "stages"    jsonb                    NOT NULL,
    CONSTRAINT "tactics_pk" PRIMARY KEY ("id")
)
