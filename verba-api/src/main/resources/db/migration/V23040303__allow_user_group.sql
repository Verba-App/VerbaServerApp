CREATE TABLE "allow_user_group"
(
    "id"             serial  NOT NULL,
    "user"           integer NOT NULL,
    "group"          integer NOT NULL,
    "access_read"    BOOLEAN NOT NULL DEFAULT 'true',
    "access_changes" BOOLEAN NOT NULL DEFAULT 'false',
    "tactic"         integer NOT NULL,
    CONSTRAINT "allow_user_group_pk" PRIMARY KEY ("id")
);