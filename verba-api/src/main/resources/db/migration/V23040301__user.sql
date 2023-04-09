CREATE TABLE "verba_user"
(
    "id"       serial       NOT NULL,
    "name"     VARCHAR(255) NOT NULL UNIQUE,
    "email"    VARCHAR(255) NOT NULL UNIQUE,
    "birthday" DATE         NOT NULL,
    "region"   VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    CONSTRAINT "user_pk" PRIMARY KEY ("id")
);

