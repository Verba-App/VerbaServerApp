CREATE TABLE "verba_user"
(
    "id"       SERIAL PRIMARY KEY    NOT NULL,
    "name"     VARCHAR(255) NOT NULL UNIQUE,
    "email"    VARCHAR(255) NOT NULL UNIQUE,
    "region"   VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL
);

