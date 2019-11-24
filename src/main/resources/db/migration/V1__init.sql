create table blogs
(
    id             bigint primary key,
    title          text,
    idempotent_key text unique
);

create table authors
(
    id             bigint primary key,
    name           text,
    idempotent_key text unique
);

create table news
(
    id             bigint primary key,
    title          text,
    content        text,
    image_url      text,
    idempotent_key text unique,
    blog_id        bigint references blogs (id),
    author_id      bigint references authors (id)
);

CREATE SEQUENCE news_sequence
    start 10
    increment 1;