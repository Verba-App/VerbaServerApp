create type word_type as enum ('verb', 'noun');

CREATE TABLE "word"
(
    "id"            serial       NOT NULL,
    "word"          VARCHAR(255) NOT NULL UNIQUE,
    "transcription" VARCHAR(255) NOT NULL,
    "type"     word_type      NOT NULL,
    CONSTRAINT "word_pk" PRIMARY KEY ("id")
);