CREATE TABLE "category"
(
    "id"   serial       NOT NULL,
    "name" VARCHAR(255) NOT NULL UNIQUE,
    CONSTRAINT "category_pk" PRIMARY KEY ("id")
);


CREATE TABLE "category_word"
(
    "category_id" BIGINT REFERENCES "category" NOT NULL,
    "word_id"     BIGINT REFERENCES "word"     NOT NULL,
    PRIMARY KEY ("category_id", "word_id")
);
