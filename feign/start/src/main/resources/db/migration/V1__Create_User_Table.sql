create table "user"
(
    id          text primary key,
    user_id     text        not null,
    create_time timestamptz not null default current_timestamp,
    update_time timestamptz not null default current_timestamp
);
create unique index uk_user_user_id on "user" (user_id);
comment on table "user" IS '用户表';
comment on COLUMN "user"."id" IS '用户id';
comment on COLUMN "user"."create_time" IS '创建时间';
comment on COLUMN "user"."update_time" IS '更新时间';
