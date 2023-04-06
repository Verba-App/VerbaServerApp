CREATE TABLE "tactics"
(
    "id"        serial                   NOT NULL,
    "name"      VARCHAR(255)             NOT NULL,
    "author_id" BIGINT REFERENCES "user" NOT NULL,
    CONSTRAINT "tactics_pk" PRIMARY KEY ("id")
)
