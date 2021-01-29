CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.profile (
    id UUID not null default uuid_generate_v4(),
    name varchar(30),
    enabled boolean default true,
    PRIMARY KEY(id)
);

CREATE TABLE public.users (
    id UUID not null default uuid_generate_v4(),
    email varchar(255),
    password varchar(255),
    profile_id UUID not null,
    PRIMARY KEY (id),
    foreign key (profile_id) references profile (id)
);

INSERT INTO profile (name, enabled) VALUES ('admin', true);
INSERT INTO users (email, password, profile_id) VALUES (
    'rafael.souza.silva@hotmail.com.br',
    '$2a$10$ydIb2SITXDZFqFfLkGurwOcyKk3XQJCULde13a1hORPufCh22bamy',
    (SELECT id FROM profile WHERE name = 'admin')
);
