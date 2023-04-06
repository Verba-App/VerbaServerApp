CREATE TABLE "card"
(
    "id"         serial                      NOT NULL,
    "create"     DATE                        NOT NULL,
    "repetition" DATE                        NOT NULL,
    "catalog_id"    BIGINT REFERENCES "catalog" NOT NULL,
    "word_id"       BIGINT REFERENCES "word"    NOT NULL,
    "photo_resource_id" BIGINT REFERENCES "photo_resources" not null ,
    CONSTRAINT "card_pk" PRIMARY KEY ("id")
);