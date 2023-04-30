create type word_type as enum ('VERB', 'NOUN');

CREATE TABLE "word"
(
    "id"            serial       NOT NULL,
    "text"          VARCHAR(255) NOT NULL UNIQUE,
    "transcription" VARCHAR(255) NOT NULL,
    "type"     word_type      NOT NULL,
    CONSTRAINT "word_pk" PRIMARY KEY ("id")
);