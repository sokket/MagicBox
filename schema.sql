CREATE TABLE categories (
    id bigserial,
    name text,
    color bytea (4)
);

CREATE TABLE requests (
    id bigserial,
    category_id bigint REFERENCES categories(id),
    summary text,
    content text,
    created_at timestamp default now(),
    lon numeric (9, 5),
    lat numeric (9, 5)
);