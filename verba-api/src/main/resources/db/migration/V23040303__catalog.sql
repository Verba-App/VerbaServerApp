CREATE TABLE "catalog"
(
    "id"         serial       NOT NULL,
    "name"       VARCHAR(255) NOT NULL,
    "create_date" DATE  NOT NULL,
    "author_id"     BIGINT      REFERENCES "user",
    "group_id"      BIGINT REFERENCES "group_catalog" NOT NULL,
    CONSTRAINT "catalog_pk" PRIMARY KEY ("id")
)
