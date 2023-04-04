CREATE TABLE "group_catalog"
(
    "id"         serial       NOT NULL,
    "name"       VARCHAR(255) NOT NULL UNIQUE,
    "author_id"     BIGINT REFERENCES "user" NOT NULL,
    CONSTRAINT "group_catalog_pk" PRIMARY KEY ("id")
);