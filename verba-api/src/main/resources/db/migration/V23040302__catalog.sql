CREATE TABLE "catalog"
(
    "id"         serial       NOT NULL,
    "name"       VARCHAR(255) NOT NULL,
    "create_date" DATE  NOT NULL,
    "author_id"     BIGINT      REFERENCES "user",
    "group"      BIGINT      NOT NULL,
    CONSTRAINT "catalog_pk" PRIMARY KEY ("id")
)
