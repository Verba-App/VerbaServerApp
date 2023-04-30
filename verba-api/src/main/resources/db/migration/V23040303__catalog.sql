CREATE TABLE "catalog"
(
    "id"         serial       NOT NULL,
    "name"       VARCHAR(255) NOT NULL,
    "author_id"     BIGINT      REFERENCES "verba_user",
    "group_id"      BIGINT      REFERENCES "group_catalog" NOT NULL,
    CONSTRAINT "catalog_pk" PRIMARY KEY ("id")
);

ALTER TABLE catalog ADD CONSTRAINT catalog_name_author_group_unique UNIQUE (name, author_id, group_id);