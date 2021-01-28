CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.employee (
    id uuid not null default uuid_generate_v4(),
    name varchar(255) not null,
    birthdate date not null,
    area varchar(255) not null,
    user_id uuid,
    enabled boolean,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);
