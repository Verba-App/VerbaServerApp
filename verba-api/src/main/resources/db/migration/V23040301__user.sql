CREATE TABLE "verba_user"
(
    "id"       SERIAL PRIMARY KEY    NOT NULL,
    "name"     VARCHAR(255) NOT NULL UNIQUE,
    "email"    VARCHAR(255) NOT NULL UNIQUE CHECK (email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'),
    "region"   VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL
);

