CREATE TABLE "allow_user_group"
(
    "id"             serial                            NOT NULL,
    "user_id"        BIGINT REFERENCES "user"          NOT NULL,
    "group_id"          BIGINT REFERENCES "group_catalog" NOT NULL,
    "access_read"    BOOLEAN                           NOT NULL DEFAULT 'true',
    "access_changes" BOOLEAN                           NOT NULL DEFAULT 'false',
    "tactic"         BIGINT                           NOT NULL,
    CONSTRAINT "allow_user_group_pk" PRIMARY KEY ("id")
)